//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
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
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 10⁴] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 👍 1240 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        Codec ser = new Codec();
//        String serialize = ser.serialize(root);
//        ser.deserialize(serialize);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.addLast(root);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int i = 0; i < size; i++) {
                        TreeNode node = queue.removeFirst();
                        if (node != null) {
                            list.add(node.val);
                            queue.addLast(node.left);
                            queue.addLast(node.right);
                        } else {
                            list.add(null);
                        }
                    }
                }
            }
            return Arrays.toString(list.toArray());
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int n = data.length();
            if (n == 2) {
                return null;
            }
            String substring = data.substring(1, n - 1);
            String[] arr = substring.split(",");
            LinkedList<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(arr[0].trim()));
            queue.add(root);
            for (int i = 1; i < arr.length; i += 2) {
                TreeNode poll = queue.poll();
                TreeNode left = arr[i].trim().equals("null") ? null : new TreeNode(Integer.valueOf(arr[i].trim()));
                poll.left = left;
                if (left != null) {
                    queue.add(left);
                }
                TreeNode right = arr[i + 1].trim().equals("null") ? null : new TreeNode(Integer.valueOf(arr[i + 1].trim()));
                poll.right = right;
                if (right != null) {
                    queue.add(right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}