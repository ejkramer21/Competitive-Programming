import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class outofsorts {

    public static void main(String[] args) {
        Solution();
    }

    /*
    * Input:
    * n m a c x0
    *
    * n=number of numbers in sequence
    * m = number to mod by
    * a = scalar
    * c = constant additive
    * x_0 = initial value (not in seq)
    *
    * Note:
    * xi = (ax_(i-1) +c) % m
    *
    *
    * n=5 m=8 a=1 c=3 x_0=3
    *
    * x0 = 3
    * x1 = (1(3)+3)%8 = 6
    * x2 = (9)%8 = 1
    * x3 = 4
    * x4 = 7
    * x5 = 2
    *
    * Sequence:
    * 6 1 4 7 2
     */
    public static void Solution() {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numInSeq = in.nextInt();
        int mod = in.nextInt();
        int scale = in.nextInt();
        int constant = in.nextInt();
        int init = in.nextInt();

        long seq[] = new long[numInSeq];

        int i;
        long prev=0;

        for(i=0;i<numInSeq;i++) {
            if (i==0) {
                prev = init;
            }
            seq[i] = equation(prev,scale,constant,mod);
            prev=seq[i];
        }

        int count = 0;
        for (i=0;i<seq.length;i++) {
            boolean bool = count(seq, seq[i]);
            if(bool) {
                count++;
            }
        }

        System.out.println(count);


    }

    public static long equation(long prev, int scalar, int constant, int mod) {
        long ans = scalar*prev;
        ans+=constant;
        return ans%mod;
    }

    public static boolean count(long[] seq, long target) {
        int ledge, redge, mid, count=0;
        boolean bool = false;
//        int copy[] = seq;
//        Arrays.sort(copy);

        ledge = 0;
        redge=seq.length-1;

        while (ledge>=0 && redge<(seq.length) && redge>=ledge) {
            mid = (int) Math.floor((ledge+redge)/2);
            if (target < seq[mid]) {
                redge=mid-1;
            } else if (target > seq[mid]) {
                ledge=mid+1;
            } else {
                bool=true;
                return bool;
            }
        }

        return bool;

    }
}
