import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class firefly {

    public static void main(String[] args) {
        Solution();
    }

    /*
    * Input:
    * N H
    * N lines --> size of obstacles
    *
    * N = length of cave
    * H = height of cave
    *
    * Output: (space separated)
    * min number of obstacles to destroy
    * level that is achieved at
     */
    public static void Solution() {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int length, height, i;

        length = in.nextInt();
        height = in.nextInt();
        long min;

        int[] bottom = new int[length/2];
        int[] top = new int[length/2];

        for (i=0;i<length/2;i++) {
            bottom[i] = in.nextInt();
            top[i] = in.nextInt();
        }

        Arrays.sort(top);
        Arrays.sort(bottom);

        i = 0;
        int numHit = length/2;
        int j =0;
        long cols[] = new long[height];

        while (i<bottom[length/2 -1]) {

            while (i<bottom[j]) {
                cols[i++] += numHit;
            }
            j++;
            numHit--;

        }


        i=height-1;
        numHit = length/2;
        j = 0;
        while(i>=(height-top[length/2-1])) {

            while (i >= (height-top[j])) {
                cols[i--]+=numHit;
            }
            j++;
            numHit--;

        }

        min = length;
        int numOc=0;
        for (i=0;i<height;i++) {

            if (cols[i] <min) {
                min = cols[i];
                numOc=0;
                numOc++;
            } else if (cols[i] == min) {
                numOc++;
            }

        }

        System.out.println(min + " " + numOc);

    }
}
