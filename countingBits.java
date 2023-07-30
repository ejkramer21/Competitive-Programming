public class countingBits {

    /* Attempt 1 -> 13ms beat 15.46% (hard code appraoch)
    public static int[] countBits(int n) {

        int[] bits;
        int ones;
        int[] list=new int[n+1];

        for(int i=0;i<=n;i++) {
            bits=makeBits(i);
            ones=countOnes(bits);
            list[i]=ones;
        }

        return list;

    }

    private static int[] makeBits(int x){
        int i=0;
        int[] bits = new int[21];
        while (x > 0) {
            int remainder = x % 2;
            bits[i++]=remainder;
            x /= 2;
        }
        return bits;
    }

    private static int countOnes(int[] bits){
        int count=0;
        for(int i=0;i<bits.length;i++){
            if(bits[i]==1){
                count++;
            }
        }
        return count;
    }

     */

    /* Attempt 2 --> 8ms beat 23.36% --> extension of prev just got rid of extra steps
    public static int[] countBits(int n) {

        int bits;
        int[] list=new int[n+1];

        for(int i=0;i<=n;i++) {
            bits=makeBits(i);
            list[i]=bits;
        }

        return list;

    }

    private static int makeBits(int x){
        int i=0, count=0;
        while (x > 0) {
            int remainder = x % 2;
            x /= 2;
            if(remainder==1){
                count++;
            }
        }
        return count;
    }

     */
    /* Attempt 3 -> 2ms beat 59.08% -> similar approach but with bit masking
    public static int[] countBits(int n) {

        int bits;
        int[] list=new int[n+1];

        for(int i=0;i<=n;i++) {
            bits=makeBits(i);
            list[i]=bits;
        }

        return list;

    }

    private static int makeBits(int x){
        int i=0, count=0;
        while (x != 0) { //essentially cancels out the lowest value bits and hits 0 after all bits are cancelled so only reenters loop as many as there are 1.  Just straight bit masking
            x&=(x-1);
            count++;
        }
        return count;
    }

     */

    //written by some other brilliant mind on leet code, I'm indeed amazed (also 2ms tho)
    public static int[] countBits(int n) {

        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++)
            ans[i] = ans[i / 2] + (i % 2 == 0 ? 0 : 1);

        return ans;
    }


}
