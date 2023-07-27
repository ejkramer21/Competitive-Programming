import java.util.ArrayList;
import java.util.List;

public class generateParentheses {

    static List<String> list;

    public static List<String> generateParenthesis(int n) {
        char[] arr = new char[n*2]; //all spaces to be filled with valid ()
        list = new ArrayList<>(); //list of strings to return
        createSet(n,n,arr);
        return list;
    }

    public static void createSet(int numOpen, int numClose, char[] arr) {
        if (numOpen==0 && numClose==0) { //all open and close brackets have been utilized for this set
            list.add(new String(arr));
        }
        if (numOpen != 0) { //still open parentheses needed, should be placed at beginning of a set
            arr[arr.length-numClose-numOpen]='(';
            createSet(numOpen-1,numClose,arr); //num open parentheses to use has decreased+continue set
        }
        if(numOpen<numClose){//an open has been used so a close is necessary to complete valid set
            arr[arr.length-numClose-numOpen]=')';
            createSet(numOpen,numClose-1,arr); //cont set and note 1 of the close have been used
        }
    }


    public static void main(String[] args) {
        List<String> s = generateParenthesis(4);

        for (int i=0;i<s.size();i++){
            System.out.println(s.get(i));
        }
    }
}
