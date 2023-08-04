class minSizeSubArraySum {

    //Attempt 1 -> 2 ms
    /*public static int minSubArrayLen(int target, int[] nums) {
        int front=0,end=0, min=Integer.MAX_VALUE, tempSum=0;

        while (front<nums.length || end<nums.length){
            if(end==0){
                tempSum+=nums[end];
            }
            if(tempSum==target){
//                min=Math.min((end-front+1),min);
                if (end-front+1 < min){
                    min=end-front+1;
                }

                tempSum-=nums[front++];
                if(end<nums.length-1){
                    tempSum+=nums[++end];
                }
                continue;
            }

            if(tempSum<target){
                if(end==nums.length-1){
                    break;
                }
                tempSum+=nums[++end];
                continue;
            }

            if(tempSum>target){
//                min=Math.min((end-front+1),min);
                if (end-front+1 < min){
                    min=end-front+1;
                }
                if(front==nums.length-1){
                    break;
                }
                if(front==end){
                    tempSum-=nums[front];
                    tempSum+=nums[++front];
                    end=front;
                    continue;
                }
                tempSum-=nums[front++];
            }
        }

        if(min==Integer.MAX_VALUE){
            min=0;
        }
        return min;

    }

     */

    //Attempt 2 -> 2 ms
    /*public static int minSubArrayLen(int target, int[] nums) {
        int front=0,end=0, min=Integer.MAX_VALUE, tempSum=0;

        while (front<nums.length || end<nums.length){
            if(end==0){
                tempSum+=nums[end];
            }
            if(tempSum>=target){
                if (end-front+1 < min){
                    min=end-front+1;
                }

                if(front==nums.length-1){
                    break;
                }
                if(front==end){
                    tempSum-=nums[front];
                    tempSum+=nums[++front];
                    end=front;
                    continue;
                }

                tempSum-=nums[front++];
                continue;
            }

            if(tempSum<target){
                if(end==nums.length-1){
                    break;
                }
                tempSum+=nums[++end];
                continue;
            }
        }

        if(min==Integer.MAX_VALUE){
            min=0;
        }
        return min;

    }

     */

    //Attempt 3 -> 3ms (wrong direction ik)
/*    public static int minSubArrayLen(int target, int[] nums) {
        int front=0,end=0, min=Integer.MAX_VALUE, tempSum=0;

        while (front<nums.length || end<nums.length){
            if(end==0){
                tempSum+=nums[end];
            }
            if(tempSum>=target){
                if (end-front+1 < min){
                    min=end-front+1;
                }

                if(front==nums.length-1){
                    break;
                }
                if(front==end){
                    tempSum-=nums[front];
                    tempSum+=nums[++front];
                    end=front;
                    continue;
                }

                tempSum-=nums[front++];
                continue;
            }

            if(tempSum<target){
                if(end==nums.length-1){
                    break;
                }
                if((end-front+1) == min) { //disregard any window bigger than min and move on to next options
                    tempSum-=nums[front++];
                    tempSum+=nums[++end];
                } else {
                    tempSum+=nums[++end];
                }
                continue;
            }

        if(min==Integer.MAX_VALUE){
            min=0;
        }
        return min;

    }

 */

    //Attempt 4 -> 1 ms basically just optimized for a set number of rotations in a better coding approach
    public static int minSubArrayLen(int target, int[] nums){
        int start=0,end=0,min=Integer.MAX_VALUE,tempSum=0;

        for(;end<nums.length;end++){
            tempSum+=nums[end];
            if(tempSum>=target){
                boolean valid=true;
                min=Math.min(min, end-start+1);

                while(valid){
                    if(tempSum-nums[start] >= target){
                        tempSum-=nums[start++];
                        min=Math.min(min, end-start+1);
                        continue;
                    }
                    valid=false;
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            min=0;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums;
        int target;

        nums=new int[]{2,3,1,2,4,3};
        target=7;
        System.out.println(minSubArrayLen(target, nums));

        nums=new int[]{1,4,4};
        target=4;
        System.out.println(minSubArrayLen(target, nums));

        nums=new int[]{1,1,1,1,1,1,1,1};
        target=11;
        System.out.println(minSubArrayLen(target, nums));

        nums=new int[]{1,2,3,4,5};
        target=11;
        System.out.println(minSubArrayLen(target, nums));

    }

}