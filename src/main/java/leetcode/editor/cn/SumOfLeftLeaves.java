//给定二叉树的根节点 root ，返回所有左叶子之和。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 752 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        solution.sumOfLeftLeaves(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public int sumOfLeftLeaves(TreeNode root) {
            return sumOfLeftLeaves(root, false);
        }

        public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
            if (root == null) {
                return 0;
            }
            boolean isLeaf = root.left == null && root.right == null;
            int leftSum = sumOfLeftLeaves(root.left, true);
            int rightSum = sumOfLeftLeaves(root.right, false);
            return isLeft && isLeaf ? root.val + leftSum + rightSum :
                    leftSum + rightSum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}