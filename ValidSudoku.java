public class ValidSudoku {
    //literally just the hard code because there are only 27 cases
    //key note is use / for sections and % for subsections
    public static boolean isValidSudoku(char[][] board) {
        boolean[] contains = new boolean[9];
        int offset = 49;

        //check each row
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(!contains[board[i][j]-offset]){
                    contains[board[i][j]-offset] = true;
                } else{
                    return false;
                }
            }
            contains = new boolean[9];
        }

        //check each column
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                if(!contains[board[j][i]-offset]){
                    contains[board[j][i]-offset] = true;
                } else{
                    return false;
                }
            }
            contains = new boolean[9];
        }

        //check each section
        for(int k=0;k<9;k++){
            for(int i=0;i<board.length/3;i++){
                for(int j=0;j<board[i].length/3;j++){
                    char current = board[i + (3 * (k / 3))][j + (3 * (k % 3))]; //twas the key to clean code but didn't necessarily have to be this pretty
                    if(current=='.'){
                        continue;
                    }
                    if(!contains[current-offset]){
                        contains[current-offset] = true;
                    } else{
                        return false;
                    }
                }
            }
            contains=new boolean[9];
        }


        return true;
    }
}
