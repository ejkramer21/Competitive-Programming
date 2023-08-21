import java.util.ArrayList;
import java.util.List;


//0ms beat 100%
//O(n) for iterating through array, StringBuilder functions are O(1) I believe so overall program is linear time
public class summaryRanges {
    public static List<String> summaryRanges(int[] nums) {

        List<String> ranges = new ArrayList<>();

        if(nums.length==0){
            return ranges;
        }

        StringBuilder sb = new StringBuilder();
        int prev=0;
        int count=0;

        for(int num : nums){

            if(sb.length()==0){
                sb.append(num);
                prev=num;
                count+=1;
                continue;
            }

            if(num == prev+1) { //is consecutive

                if(count==1){ //- and > haven't been added
                    sb.append('-');
                    sb.append('>');
                    sb.append(num);
                    count+=3;
                } else { //need to replace end of range
                    int tens = 0;

                    while(prev != 0){
                        prev/=10;
                        tens+=1;
                    }
                    sb.delete(sb.length()-tens,sb.length());
                    sb.append(num);
                }
            } else {
                ranges.add(sb.toString());
                sb.delete(0,sb.length());
                sb.append(num);
                count=1;
            }
            prev=num;

        }
        ranges.add(sb.toString());
        return ranges;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        summaryRanges(nums);
    }
}
