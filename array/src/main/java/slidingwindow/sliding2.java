package slidingwindow;

import java.util.HashMap;

import static java.util.Arrays.fill;

public class sliding2 {
    public int totalFruit(int[] fruits) {
        //[1,2,3,2,2,2,3,2,3,2,2,3,1,3,3,1,2,1,2,3,1,2]
        int left = 0;
        int leftLocation = 0;//记录第一种水果最晚出现的位置
        int rightLocation = 0;
        int[] type = new int[2];
        int typeNum = 0;
        //fill(type, -1);
        int result = 0;
        for (int right = 0; right < fruits.length; right++) {
            if (typeNum == 0) {
                type[0] = fruits[right];
                typeNum = 1;
                leftLocation = right;
                result = Integer.max(1, result);
                //right++;
            } else if (typeNum == 1) {
                if (type[0] == fruits[right]) {
                    leftLocation = right;
                    //right++;
                } else {
                    type[1] = fruits[right];
                    //right++;
                    typeNum = 2;
                    rightLocation = right;
                }
                result = Integer.max(result, right - left + 1);
            } else {
                if (type[0] == fruits[right]) {
                    //right++;
                    leftLocation = right;
                    result = Integer.max(result, right - left + 1);
                    System.out.println(left + "," + right);
                } else if (type[1] == fruits[right]) {
                    //right++;
                    result = Integer.max(result, right - left + 1);
                    System.out.println(left + "," + right);
                    rightLocation = right;
                } else {
                    if (leftLocation < rightLocation) {
                        type[0] = type[1];
                        type[1] = fruits[right];
                        //调节窗口起始位置
                        //保证left到right只有两种水果
                        //left = Integer.min(leftLocation,rightLocation)
                        left = leftLocation + 1;
                        leftLocation = rightLocation;
                        rightLocation = right;
                        //System.out.println(left+","+right);
                        result = Integer.max(result, right - left + 1);
                    } else {
                        type[1] = fruits[right];
                        left = rightLocation + 1;
                        rightLocation = right;
                        result = Integer.max(result, right - left + 1);
                    }
                }
            }
        }
        return result;
    }


    /**
     * 使用滑窗法模板
     *
     * @param fruits
     * @return
     */


    public int totalFruit2(int[] fruits) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        int result = 0;
        while (right < fruits.length) {
            int c = fruits[right];
            right++;
            if (!window.containsKey(c) || window.get(c) == 0) {
                valid++;
            }
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (valid > 2) {
                int d = fruits[left];
                left++;
                window.put(d, window.get(d) - 1);
                if (window.get(d) == 0) {
                    valid--;
                }
            }
            result = Integer.max(result, right - left);
        }
        return result;
    }
}