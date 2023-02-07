import java.io.*;
import java.util.Scanner;

public class thanos {
    /*
    * P = the planet's population (whole number)
    * R = rate of population growth (1 to 10^9 inclusive)
    * F = tons of food produced per year (1 to 10^9 inclusvie)
    *
    * None of food can be saved for the next year
    *
    * Find : Number of years before not enough food for population (when P>F)
    *
    *  Note: 1 individual = 1 ton
    *
    * Input:
    * Number of planets analyzed
    * P R F
    *
    * Output:
    * Years until not sustainable
     */
    private static void Solution() throws IOException {
        //Compound interest formula: new = initial(1 + rate)^time --> get new population/yr
        long T, P, R, F, yrs, div;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        T = in.nextLong();
        for (int i = 0; i<T; i++) { //numPlanets number of lines next
            yrs = 0; //initialize as if overpopulation has already happened
            P = in.nextLong();
            R = in.nextLong();
            F = in.nextLong();

            while (P <= F) { //exact amount of food to population is still fine
                yrs++;
                if (P==F){
                    break;
                }
                P *=R;
            }
//            div = (int) Math.floor(F/P);
//            yrs = (int) Math.floor(Math.log10(div)/Math.log10(R)) + 1;

            out.write(yrs+"\n");
        }

        out.flush();

        in.close();
        out.close();

    }

    public static void main(String[] args) throws IOException {
        Solution();
    }
}
