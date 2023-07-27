public class climbingStairs {

/* Attempt 1 (fails above 4)
    static int[][] arr;

    public static int climbStairs(int n){
        arr = new int[n+1][n+1];
        arr[1][0]=1;

        int i=1,j=1;

        while (i < (n+1) && j < (n+1)){
            arr[i][j] = rowTotal(i,j-1);
            fillNxtCol(i,j);
            i++;
            j++;
        }

        return arr[n][n];
    }

    public static int rowTotal(int i, int j){
        int total=0;
        if (i!=1){
            i-=1;
        }


        while (j>=0 && i<arr.length && arr[i][j]!=0){
            total+=arr[i++][j];
        }
        return total;
    }

    public static void fillNxtCol(int i, int j) {
        int k=0;
        int orig=i;

        while (k<orig && k<2 && ++i<arr.length){
            arr[i][j]=1;
            k++;
        }
    }

 */

    static int[][] arr;

    //Attempt 2 (0ms beats 100%) IT WAS LITERALLY FIBONACCI FML
    public static int climbStairs(int n){
        if (n==1){
            return 1;
        }

        arr=new int[n+1][n+1];
        arr[0][0]=1;
        arr[1][1]=1;

        int i=2,j=2;

        while (i<=n && j<=n){
            arr[i][j]=arr[i-1][j-1]+arr[i-2][j-2];
            i++;
            j++;
        }

        return arr[n][n];

    }

    public static void main(String[] args) {
        int x = climbStairs(3);
        System.out.println(x);
    }
}
