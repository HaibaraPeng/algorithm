//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1561 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        System.out.println(1);
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

        Map<Integer, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int left, int right) {
            int key = left * 10 + right;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            List<TreeNode> res = new ArrayList<>();
            if (left == right) {
                res.add(new TreeNode(left));
                map.put(key, res);
                return res;
            }
            for (int i = left; i <= right; i++) {
                if (i == left) {
                    List<TreeNode> treeNodes = generateTrees(i + 1, right);
                    for (TreeNode treeNode : treeNodes) {
                        TreeNode node = new TreeNode(i);
                        node.right = treeNode;
                        res.add(node);
                    }
                } else if (i == right) {
                    List<TreeNode> treeNodes = generateTrees(left, i - 1);
                    for (TreeNode treeNode : treeNodes) {
                        TreeNode node = new TreeNode(i);
                        node.left = treeNode;
                        res.add(node);
                    }
                } else {
                    List<TreeNode> leftTreeNodes = generateTrees(left, i - 1);
                    List<TreeNode> rightTreeNodes = generateTrees(i + 1, right);
                    for (TreeNode leftTreeNode : leftTreeNodes) {
                        for (TreeNode rightTreeNode : rightTreeNodes) {
                            TreeNode node = new TreeNode(i);
                            node.left = leftTreeNode;
                            node.right = rightTreeNode;
                            res.add(node);
                        }
                    }
                }
            }
            map.put(key, res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}