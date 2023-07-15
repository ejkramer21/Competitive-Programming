import java.lang.reflect.Array;
import java.util.ArrayList;

public class reverseInteger {

    //1st attempt (6ms)
/*    public static int reverse(int x) {
        boolean neg=false;
        boolean near=false;
        int[] max = {2,1,4,7,4,8,3,6,4,8};

        if (x>=-9 && x<=9){ //single digits
            return x;
        }

        if (x<0){
            neg=true;
        }

        int[] arr = String.valueOf(Math.abs(x)).chars().map(c->c-48).toArray();

        if(arr.length>10){
            return 0;
        } else if (arr.length==10){
            near=true;
            if(arr[arr.length-1]>2){
                return 0;
            }
        }

        int j=0,k=arr.length-1;
        int temp;

        for (int i=0;i<arr.length/2;i++){
            temp=arr[j];
            arr[j++]=arr[k];
            arr[k--]=temp;


        }

        int ten=1;
        int sum=0;
        for(int i=arr.length-1;i>=0;i--){
            sum+=(arr[i]*ten);
            ten*=10;

            if (sum<0){
                return 0;
            }
        }
        if(neg){
            sum*=-1;
        }

        return sum;

    }

 */

    //2nd attempt (7ms but way better memory at least lmao
/*    public static int reverse(int x){
        boolean neg=false;
        if (x>=-9 && x<=9){ //single digits
            return x;
        }

        if (x<0){
            neg=true;
        }

        int[] arr = String.valueOf(Math.abs(x)).chars().map(c->c-48).toArray();

        if(arr.length>10){
            return 0;
        } else if (arr.length==10){
            if(arr[arr.length-1]>2){
                return 0;
            }
        }

        int ten=1;
        int sum=0;

        for (int i=0;i<arr.length;i++){
            sum+=(arr[i]*ten);
            ten*=10;
            if(sum<0){
                return 0;
            }
        }
        if(neg){
            sum*=-1;
        }
        return sum;
    }

 */

    //3rd attempt (100% yippee)
    public static int reverse(int x) {
        double sum=0;
        int k=x;

        if(x<0) {
            k*=-1;
        }

        while(k>0){
            sum*=10;
            sum+=(x%10);
            x/=10; //returns int not decimal
            k/=10;
        }
        if(sum<Math.pow(-2,31) || sum>Math.pow(2,31) )
            return 0;
        else
            return (int)sum;
    }

    public static void main(String[] args) {
        int x = reverse(1534236469);
        System.out.println(x);
    }
}
