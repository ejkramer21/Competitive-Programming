public class containerWithMostWater {

    //1st attempt (all possibilities so TLE)
/*    public static int maxArea (int[] height){
        int len = height.length;
        int area=0;
        int tempArr;
        if (len <=2){
            area = Math.min(height[0],height[1]);
            return area;
        }

        for (int i=0;i<len;i++){
            for(int j=(i+1);j<len;j++){
                tempArr = (j-i)*(Math.min(height[i],height[j]));
                if (tempArr>area){
                    area=tempArr;
                }
            }
        }
        return area;
    }

 */

    //2nd attempt (beat 81.8% at 4ms)
/*    public static int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int area=0,tempArea;

        tempArea=(right-left)*Math.min(height[left],height[right]);
        if (tempArea>area){
            area=tempArea;
        }

        while(right != left && right != (left+1)){
            if (height[left]<=height[right]){
                left++;
            } else {
                right--;
            }

            tempArea=(right-left)*Math.min(height[left],height[right]);
            if (tempArea>area){
                area=tempArea;
            }
        }
        return area;
    }

 */

    //attempt 3 (beat 93.45% w 3ms)
    //only change was really just the while condition and got rid of Math calls
/*    public static int maxArea(int[] height) {
        int left=0, right=height.length-1, area=0,tempArea, curMin;

        while(left<right){

            if (height[left]<=height[right]){
                curMin=height[left];
            } else {
                curMin=height[right];
            }

            tempArea=(right-left)*curMin;
            if (tempArea>area){
                area=tempArea;
            }

            if (height[left]<=height[right]){
                left++;
            } else {
                right--;
            }


        }
        return area;
    }

 */

    //4th attempt (beat 100% with 1ms)
    //move pointer until a higher column is reached bc that is the only way to be more optimum
    public static int maxArea(int[] height) {
        int left=0, right=height.length-1, area=0,tempArea, curMin;

        while(left<right){

            if (height[left]<=height[right]){
                curMin=height[left];
            } else {
                curMin=height[right];
            }

            tempArea=(right-left)*curMin;
            if (tempArea>area){
                area=tempArea;
            }


            while((height[left]<=curMin) && left<right) {
                left++;
            }
            while(height[right]<=curMin && left < right) {
                right--;
            }



        }
        return area;
    }

    public static void main(String[] args) {
        int[] height={2,3,4,5,18,17,6};
        int x = maxArea(height);
        System.out.println(x);
    }
}
