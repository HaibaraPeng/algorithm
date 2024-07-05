//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2323 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        TreeNode treeNode = solution.buildTree(new int[]{3, 2, 1, 4}, new int[]{1, 2, 3, 4});
        System.out.println("1");
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
            if (preLeft >= preorder.length || preRight >= preorder.length || inLeft >= inorder.length || inRight >= inorder.length || preLeft > preRight || inLeft > inRight) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[preLeft]);
            if (preLeft == preRight) {
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
            node.left = leftLength == 0 ? null : dfs(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft, inorderNodeIndex - 1);
            node.right = dfs(preorder, preLeft + leftLength + 1, preRight, inorder, inorderNodeIndex + 1, inRight);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}