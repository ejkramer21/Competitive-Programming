import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class roompainting {

    public static void main(String[] args) {
        Solution();
    }

    /*
    * Input:
    * n m
    * n lines -> sizes
    * m lines -> micro liters of given color
    *
    * n = number of paint can sizes offered
    * m = number of colors Joe needs
    *
    * Output:
    * number of microliters of paint wasted if Joe buy the smallest can
    * he needs for each color
     */
    public static void Solution() {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int numSizes, numColsNeeded;
        int i=0;

        numSizes=in.nextInt(); //number of can sizes
        numColsNeeded = in.nextInt(); //number of colors Joe wants
        long canSizes[] = new long[numSizes]; //the size of the can options
        long amtOfEach[] = new long[numColsNeeded]; //the amount of each color Joe needs
        long amtExcess[] = new long[numColsNeeded]; //the excess for each paint

        for(i=0;i<numSizes;i++) {
            canSizes[i] = in.nextLong();
        }

        for(i=0;i<numColsNeeded;i++) {
            amtOfEach[i] = in.nextLong();
        }

        Arrays.sort(canSizes);
        Arrays.sort(amtOfEach);

        int j = 0; //track the can size
        long sumExcess = 0;

        for (i = 0;i<numColsNeeded;i++) {
            while (amtOfEach[i] > canSizes[j]) {
                j++;
            }

            amtExcess[i] = canSizes[j] - amtOfEach[i];
            j=0;
        }

        for (i=0;i<numColsNeeded;i++) {
            sumExcess+=amtExcess[i];
        }

        System.out.println(sumExcess);

    }
}
