//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 
//values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替
//代这个答案。 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
//注意：x 是未定义的 => -1.0 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], 
//queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],[
//"a","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 数组 字符串 最短路 👍 1146 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.*;

public class EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new EvaluateDivision().new Solution();
        solution.calcEquation(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c")), new double[]{2.0, 3.0},
                Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 存储图的邻接表，key 是变量，value 是该变量与邻接节点的比率映射
        private Map<String, Map<String, Double>> graph = new HashMap<>();

        /**
         * 主函数，计算 queries 中的每个结果
         */
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            // 1. 构建图
            buildGraph(equations, values);

            // 2. 遍历每个查询，使用DFS来查找路径上的乘积
            double[] results = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {
                String numerator = queries.get(i).get(0);
                String denominator = queries.get(i).get(1);
                if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                    results[i] = -1.0;
                } else if (numerator.equals(denominator)) {
                    results[i] = 1.0;
                } else {
                    Set<String> visited = new HashSet<>();
                    results[i] = dfs(numerator, denominator, 1.0, visited);
                }
            }

            return results;
        }

        /**
         * 构建图，将equations和values转化为邻接表
         */
        private void buildGraph(List<List<String>> equations, double[] values) {
            for (int i = 0; i < equations.size(); i++) {
                String var1 = equations.get(i).get(0);
                String var2 = equations.get(i).get(1);
                double value = values[i];

                // 初始化邻接表的节点
                graph.putIfAbsent(var1, new HashMap<>());
                graph.putIfAbsent(var2, new HashMap<>());

                // var1 -> var2 的比率
                graph.get(var1).put(var2, value);
                // var2 -> var1 的比率（倒数）
                graph.get(var2).put(var1, 1.0 / value);
            }
        }

        /**
         * 使用DFS深度优先搜索，查找从numerator到denominator的路径，并计算乘积
         */
        private double dfs(String current, String target, double product, Set<String> visited) {
            if (current.equals(target)) {
                return product;
            }

            // 标记当前节点为已访问
            visited.add(current);

            // 遍历当前节点的邻接点
            Map<String, Double> neighbors = graph.get(current);
            for (String neighbor : neighbors.keySet()) {
                if (visited.contains(neighbor)) continue;

                double result = dfs(neighbor, target, product * neighbors.get(neighbor), visited);
                if (result != -1.0) {
                    return result;
                }
            }

            // 没有找到路径，回溯
            return -1.0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}