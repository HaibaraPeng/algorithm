//给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。 
//
// 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。 
//
// 
//class Node {
//    public int val;
//    public List<Node> neighbors;
//} 
//
// 
//
// 测试用例格式： 
//
// 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻
//接列表表示。 
//
// 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。 
//
// 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：adjList = [[2,4],[1,3],[2,4],[1,3]]
//输出：[[2,4],[1,3],[2,4],[1,3]]
//解释：
//图中有 4 个节点。
//节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
//节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
//节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
//节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：adjList = [[]]
//输出：[[]]
//解释：输入包含一个空列表。该图仅仅只有一个值为 1 的节点，它没有任何邻居。
// 
//
// 示例 3： 
//
// 
//输入：adjList = []
//输出：[]
//解释：这个图是空的，它不含任何节点。
// 
//
// 
//
// 提示： 
//
// 
// 这张图中的节点数在 [0, 100] 之间。 
// 1 <= Node.val <= 100 
// 每个节点值 Node.val 都是唯一的， 
// 图中没有重复的边，也没有自环。 
// 图是连通图，你可以从给定节点访问到所有节点。 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 哈希表 👍 725 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public static void main(String[] args) {
        Solution solution = new CloneGraph().new Solution();
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

    class Solution {

        Map<Integer, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Node newNode = new Node(node.val, new ArrayList<>());
            map.put(newNode.val, newNode);
            if (node.neighbors != null && !node.neighbors.isEmpty()) {
                for (int i = 0; i < node.neighbors.size(); i++) {
                    if (!map.containsKey(node.neighbors.get(i).val)) {
                        cloneGraph(node.neighbors.get(i));
                    }
                    newNode.neighbors.add(map.get(node.neighbors.get(i).val));
                }
            }
            return newNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}