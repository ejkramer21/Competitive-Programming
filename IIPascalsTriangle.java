import java.util.ArrayList;
import java.util.List;


public class IIPascalsTriangle {

    /*Attempt 1 2ms beat 12.83%
    public List<Integer> getRow(int numRows){
        numRows+=1;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        int row=0;
        int count=0;
        int newTotal;

        while(row<numRows){

            if (count==0){
                curr=new ArrayList<>();
                curr.add(1);
                count++;
                if(row==1){
                    curr.add(1);
                    row++;
                    count=0;
                    list.add(curr);
                }
                if (row==0){
                    row++;
                    count=0;
                    list.add(curr);
                }
                continue;
            }
            if(count==(row)){
                curr.add(1);
                list.add(curr);
                count=0;
                row++;
                continue;
            }

            newTotal=list.get(row-1).get(count-1) + list.get(row-1).get(count);
            curr.add(newTotal);
            count++;


        }

        if(numRows==0){
            return list.get(0);
        }

        return list.get(numRows-1);
    }

     */

    //Attempt 2 (0ms beat 100%)
    //To get values in pascal triangle, use the Math equation in the while loop before (it's just useful to know don't try to derive)
    //note the bounds of the problem so I use long the first time and don't have overflow issues
    public static List<Integer> getRow(int numRows){
        numRows+=1;
        List<Integer> curr = new ArrayList<>();

        if(numRows<=1){
            curr.add(1);
            return curr;
        } else if (numRows==2){
            curr.add(1);
            curr.add(1);
            return curr;
        }


        curr.add(1);
        int count=1;
        long num=1;

        while(count<numRows){

            num*=(numRows-count);
            num/=count;
            count++;
            curr.add((int)num);


        }
        return curr;

    }

    public static void main(String[] args) {
        getRow(3);
    }

}
