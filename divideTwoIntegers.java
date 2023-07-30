public class divideTwoIntegers {

    //Attempt 1 (1ms beat 99.44%)
    //Utilize bit manipulation to see how many times we must shift the divisor to achieve a number closest to dividend
    public static int divide(int dividend, int divisor) {

        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }

        boolean neg = ((dividend<0 && divisor>0) || (dividend>0 && divisor<0) ? true : false);
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);


        long sum;
        long count,quotient=0;

        while(absDivisor<=absDividend){
            count=1;
            sum=absDivisor;
            while(sum<<1 <= absDividend) {
                count=count<<1;
                sum=sum<<1;
            }
            absDividend-=sum;
            quotient+=count;
        }

        if(neg){
            quotient*=-1; //couldn't figure out way around this mult.  Attempting bit masking but several edge cases came up in the 500ths test cases

        }

        if(quotient<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        } else if(quotient>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }


        return (int)quotient;
    }



    public static void main(String[] args) {
        int x;

        x = divide(10,3);
        System.out.println(x);

        x = divide(7,-3);
        System.out.println(x);

        x = divide(Integer.MIN_VALUE,1);
        System.out.println(x);
    }
}
