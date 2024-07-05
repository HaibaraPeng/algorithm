//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1237 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        solution.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public class TreeNode {
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode dfs(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
            if (postLeft >= postorder.length || postRight >= postorder.length || inLeft >= inorder.length || inRight >= inorder.length || postLeft > postRight || inLeft > inRight) {
                return null;
            }
            TreeNode node = new TreeNode(postorder[postRight]);
            if (postLeft == postRight) {
                return node;
            }
            int inorderNodeIndex = inLeft;
            while (inorderNodeIndex <= inRight) {
                if (inorder[inorderNodeIndex] == node.val) {
                    break;
                }
                inorderNodeIndex++;
            }
            int leftLength = inorderNodeIndex - inLeft;
            node.left = leftLength == 0 ? null : dfs(inorder, inLeft, inorderNodeIndex - 1, postorder, postLeft, postLeft + leftLength - 1);
            node.right = dfs(inorder, inorderNodeIndex + 1, inRight, postorder, postLeft + leftLength, postRight - 1);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}