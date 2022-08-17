## KMP

利用有限状态机（dp数组）进行查询

下一步转移到哪个状态由下一个待匹配字符决定

dp数组只和模式串有关系

**确定状态转移的行为，必须明确两个变量，一个是当前的匹配状态，另一个是遇到的字符**，只要确定这两个变量就可以确定向前推进还是回退

进行搜索代码如下

```java
public int search(String txt) {
    int M = pat.length();
    int N = txt.length();
    // pat 的初始态为 0
    int j = 0;
    for (int i = 0; i < N; i++) {
        // 当前是状态 j，遇到字符 txt[i]，
        // pat 应该转移到哪个状态？
        j = dp[j][txt.charAt(i)];
        // 如果达到终止态，返回匹配开头的索引
        if (j == M) return i - M + 1;
    }
    // 没到达终止态，匹配失败
    return -1;
}
```

### 构建状态转移图

**如果遇到的字符 `c` 和 `pat[j]` 匹配的话**，状态就应该向前推进一个，也就是说 `next = j + 1`

**如果字符 `c` 和 `pat[j]` 不匹配的话**，状态就要回退（或者原地不动）

需要找到和当前状态**具有相同的前缀**的状态X来回退

遇到字符j不能让状态继续推进，要**尽可能少的回退**

1. 如果X遇到j可以推进，下一个状态就是dp[X] [j]（因为前缀是相同的，就表明前缀已经匹配过了不需要重新匹配）

2. 如果X遇到j不可以推进，就跟随X进行回退，状态也是dp[X] [j]

   

框架如下

```java
int X # 影子状态
    for 0 <= j < M:
for 0 <= c < 256:
if c == pat[j]:
# 状态推进
    dp[j][c] = j + 1
    else: 
# 状态重启
    # 委托 X 计算重启位置
    dp[j][c] = dp[X][c] 
```

#### dp数组

*dp[状态] [字符] = 下个状态*

其中状态长度就是pat长度；

字符个数就是ASCII个数256

#### base case

```java
// base case
dp[0][pat.charAt(0)] = 1;
```

pat初始状态为0

只有遇到pat.charAt(0)才会前进

#### 更新影子状态

```java
X = dp[X][pat.charAt(j)];
```

X的更新和Search中更新状态j非常相似

```java
int j = 0;
for (int i = 0; i < N; i++) {
    // 当前是状态 j，遇到字符 txt[i]，
    // pat 应该转移到哪个状态？
    j = dp[j][txt.charAt(i)];
    ...
}
```

更新状态j是在txt中匹配pat；

而更新状态X相当于在pat中匹配



最终代码如下

```java
public class KMP {
    private int[][] dp;
    private String pat;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++)
                dp[j][c] = dp[X][c];
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) return i - M + 1;
        }
        // 没到达终止态，匹配失败
        return -1;
    }
}
```

