package structures.tree;

import java.util.Arrays;

public class TestTree {

    public static void main(String[] args) {

        TreeNode employee1 = new TreeNode(50);
        TreeNode employee2 = new TreeNode(150);
        TreeNode employee3 = new TreeNode(250);
        TreeNode employee4 = new TreeNode(120);
        TreeNode employee5 = new TreeNode(85);

        TreeNode manager1 = new TreeNode(600, Arrays.asList(employee1,employee3));
        TreeNode manager2 = new TreeNode(500, Arrays.asList(employee2,employee5));
        TreeNode manager3 = new TreeNode(400, Arrays.asList(employee4));

        TreeNode director = new TreeNode(100,Arrays.asList(manager1,manager2,manager3));

        System.out.printf("The annual profit is %d", TreeNodeUtiles.getYearProfit(director));

    }

}
