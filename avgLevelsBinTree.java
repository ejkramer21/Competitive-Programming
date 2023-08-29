import java.util.ArrayList;
import java.util.List;

//attempt 1 -> 1 ms beat 100%
//used recursive preorder
public class avgLevelsBinTree {
    List<Double> averages;
    List<Double> numInLev;
    List<Double> sum;

    public List<Double> averageOfLevels(TreeNode root) {
        averages = new ArrayList<>();
        numInLev = new ArrayList<>();
        sum = new ArrayList<>();

        traverse(root, 0);


        return averages;
    }

    private void traverse(TreeNode node, int level){

        if(node==null){
            return;
        }

        if(numInLev.size() <= level){
            numInLev.add(0.0);
            sum.add(0.0);
            averages.add(0.0);
        }
        numInLev.set(level, numInLev.get(level)+1);
        sum.set(level, sum.get(level)+node.val);
        averages.set(level,sum.get(level)/ numInLev.get(level));
        level++;

        traverse(node.right,level);
        traverse(node.left,level);

        return;

    }

}
