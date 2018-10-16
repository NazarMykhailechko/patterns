package structures.tree;

import java.util.IntSummaryStatistics;
import java.util.List;

public class TreeNodeUtiles {

    public static int getYearProfit(TreeNode root){

        int profit = root.getValue();

        List<TreeNode> children = root.getChildren();

        if (children==null){
            return profit;
        }

        profit += children.stream().mapToInt(TreeNodeUtiles::getYearProfit).sum();


//        for (TreeNode child : children) {
//            profit += getYearProfit(child);
//        }

        return profit;
    }

}
