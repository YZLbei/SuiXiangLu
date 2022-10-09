/**
 * @Auther: YuZhenLong
 * @Date: 2022/9/29 14:05
 * @Description:
 */
public class alli {
   static public void merge(int []nums1,int []nums2,int m, int n){
        int curIndex  = m+n-1;
        int nums1Index = m -1;
        int nums2Index = n-1;
        while (nums1Index>=0){
            int i = nums1[nums1Index--];
            while (nums2Index>=0&&i<nums2[nums2Index]){
                nums1[curIndex--] = nums2[nums2Index--];
            }
            nums1[curIndex--] = i;
        }
        while (nums2Index>=0){
            nums1[curIndex--] = nums2[nums2Index--];
        }
    }
    static void sort (int []nums1,int left ,int right){
       int i;
       int j;
       int p;
       if (left>right){
           return;
       }
       p = nums1[left];
       i = left;
       j = right;
       while (i<j){
           while (nums1[j]>=p&&i<j){
               j--;
           }
           nums1[i] = nums1[j];
           while (nums1[i]<=p&&i<j){
               i++;
           }
           nums1[j] = nums1[i];
       }
       nums1[i] = p;
       sort(nums1,left,i-1);
       sort(nums1,i+1,right);
    }
    public static void main(String[] args) {
        int []nums1 = new int[]{1,2,3,0,0,0};
        int []nums2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        //merge(nums1,nums2,3,3);
        for (int i = m; i < m + n; i++) {
            nums1[i] =nums2[i-m];
        }
        sort(nums1,0,m+n-1);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }
    }
}
