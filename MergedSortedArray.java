import java.util.Arrays;

public class MergedSortedArray {

    /* Attempt 1 (1 ms beat 37.24%) -> the most obvious approach
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j=0;
        for(int i=m;i<(m+n);i++){
            nums1[i]=nums2[j++];
        }

        Arrays.sort(nums1);
    }

     */

    //Attempt 2 (0ms beat 100%) -> next most obvious just make prog on both
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int one=0;
        int two=0;
        int start=0;
        int[] nums = new int[m+n];
        while(start<(m+n)) {

            //regular case
            if (one < m && two < n) {
                if (nums1[one] <= nums2[two]) {
                    nums[start++] = nums1[one++];
                } else {
                    nums[start++] = nums2[two++];
                }
                continue;
            }

            //one or the other is maxed out
            if (one >= m) {
                while (two < n) {
                    nums[start++] = nums2[two++];
                }
                break;
            }
            if (two >= n) {
                while (one < m) {
                    nums[start++] = nums1[one++];
                }
                break;
            }

        }

        for(int i=0;i<(m+n);i++){
            nums1[i]=nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};

        merge(nums1,3,nums2,3);
    }
}
