//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
// 
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
//
// Related Topics 几何 数组 哈希表 数学 👍 561 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new MaxPointsOnALine().new Solution();
        System.out.println(solution.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPoints(int[][] points) {
            int n = points.length;
            if (n < 3) {
                return n;
            }
            int max = 0;
            for (int i = 0; i < n - 2; i++) {
                Map<String, Integer> map = new HashMap<>();
                int a0 = points[i][0], a1 = points[i][1];
                for (int j = i + 1; j < n; j++) {
                    int b0 = points[j][0], b1 = points[j][1];
                    int x0 = b0 - a0, x1 = b1 - a1;
                    int gcd = gcd(x0, x1);
                    String key = (x0 / gcd) + "_" + (x1 / gcd);
                    map.put(key, map.getOrDefault(key, 1) + 1);
                }
                for (Integer value : map.values()) {
                    max = Math.max(max, value);
                }
            }
            return max;
        }

        public int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}