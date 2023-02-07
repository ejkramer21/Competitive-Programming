import java.io.*;
import java.util.Scanner;

public class estimatingtheareaofacircle {

    /*
    * Up to 1000 test cases, 1/line
    *
    * r = radius
    * m = number of points
    * c = points in the circle
    *
    * end when input is 0 0 0
    *
    * output:
    * True area and estimate by experiment (relative error at most 10^-5)
     */
    public static void Solution() throws IOException {
//look online for if it fits eq of circle

        double r,m,c,rArea,estArea,sqArea,ratio;

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        while ((r=in.nextDouble()) != 0 && (m=in.nextDouble()) != 0 && (c=in.nextDouble()) != 0) {
            rArea = Math.PI * Math.pow(r,2);
            out.write(rArea+" ");
            sqArea = Math.pow(2*r,2);
            ratio = c/m;
            estArea = ratio*sqArea;
            out.write(estArea+"\n");
        }

        out.flush();
        out.close();
        in.close();
    }

    public static void main(String[] args) throws IOException {
        Solution();
    }
}
