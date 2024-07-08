//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1691 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        solution.flatten(node);
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
        public void flatten(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            dfs(root, list);
            for (int i = 0; i < list.size() - 1; i++) {
                TreeNode treeNode = list.get(i);
                treeNode.left = null;
                treeNode.right = list.get(i + 1);
            }
        }

        private void dfs(TreeNode node, List<TreeNode> list) {
            if (node == null) {
                return;
            }
            list.add(node);
            dfs(node.left, list);
            dfs(node.right, list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}