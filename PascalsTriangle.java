import java.util.ArrayList;
import java.util.List;


public class PascalsTriangle {
    // Attempt 1 (1 ms beat 89%) The most basic and straightforward solution
    public List<List<Integer>> generate(int numRows) {
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

        return list;
    }


}
