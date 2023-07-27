public class uniquePaths {
    static int paths;

    /* Attempt 1 -> TLE because kept coming back ie no saved work
    public static int uniquePaths(int rows, int columns) {
        paths=1; //base case

        if (rows==1 || columns==1){
            return paths;
        }

        followPath(0,0, rows, columns);

        return paths;
    }

    public static void followPath(int curRow, int curColumn, int rows, int columns){
        if (curColumn == (columns-1)){ //only can go down
            return;
        }
        if (curRow == (rows-1)) { //only can go across
            return;
        }
        if (curColumn != (columns-1)) { //going right is valid
            if (curRow != (rows-1)) { //do not count as new path if that is only route option
                paths++;
            } else {
                return;
            }

            followPath(curRow,curColumn+1,rows,columns);
        }
        if(curRow != (rows-1)) { //continue going down ie default so path not added
            followPath(curRow+1,curColumn,rows,columns);
        }
    }

     */

    //Attempt 2 0ms beat 100% -> given grid so I should track progress like in a grid
    public static int uniquePaths(int rows, int columns) {
        int i=0,j=0;
        int[][] arr = new int[rows][columns];
        for (;i<rows;i++){
            arr[i][0]=1;
        }
        for(;j<columns;j++){
            arr[0][j]=1;
        }
        for(i=1;i<rows;i++){
            for(j=1;j<columns;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[rows-1][columns-1];
    }



    public static void main(String[] args) {
        int s = uniquePaths(3,7);
        System.out.println(s);
    }
}
