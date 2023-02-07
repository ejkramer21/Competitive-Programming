import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class therectangles {
    /*
    * Find: Number of grid squares surrounded by all rectangles
    *
    * Input:
    * number of rectangles (n)
    * a b c d
    *
    * Note:
    * a<c , b<d
    * (a,b) = bottom left corner, (c,d) = upper right corner
    * a,b,c,d <=500 (non neg)
    *
     */
    static void Solution() throws IOException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int numCases = 0;
        int a,b,c,d,n,i,j,k,sum; //min and max?
        int area = 0;
        int arr[][] = new int[500][500];
        //idea: store all four corners of each rect
        // check 4 cases:
        // rect is within another
        // rect is partially in other
        // rect outside other
        // rect is completely on top of another
        while ((n=in.nextInt()) != 0) {
            sum=0;
            arr = new int[500][500];
            for (i=0;i<n;i++) {

                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                d = in.nextInt();

                for (k=a;k<c;k++) {
                    for(j=b;j<d;j++) {
                        if (arr[k][j] != 1) {
                            arr[k][j] = 1;
                            sum+=1;
                        }
                    }
                }
            }
            out.write(sum+"\n");
        }
        out.flush();
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Solution();
    }
}
