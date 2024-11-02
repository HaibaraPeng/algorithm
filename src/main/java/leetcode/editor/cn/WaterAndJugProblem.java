//有两个水壶，容量分别为 x 和 y 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 target 升。 
//
// 你可以： 
//
// 
// 装满任意一个水壶 
// 清空任意一个水壶 
// 将水从一个水壶倒入另一个水壶，直到接水壶已满，或倒水壶已空。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: x = 3,y = 5,target = 4
//输出: true
//解释：
//按照以下步骤操作，以达到总共 4 升水：
//1. 装满 5 升的水壶(0, 5)。
//2. 把 5 升的水壶倒进 3 升的水壶，留下 2 升(3, 2)。
//3. 倒空 3 升的水壶(0, 2)。
//4. 把 2 升水从 5 升的水壶转移到 3 升的水壶(2, 0)。
//5. 再次加满 5 升的水壶(2, 5)。
//6. 从 5 升的水壶向 3 升的水壶倒水直到 3 升的水壶倒满。5 升的水壶里留下了 4 升水(3, 4)。
//7. 倒空 3 升的水壶。现在，5 升的水壶里正好有 4 升水(0, 4)。
//参考：来自著名的 "Die Hard" 
//
// 示例 2: 
//
// 
//输入: x = 2, y = 6, target = 5
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: x = 1, y = 2, target = 3
//输出: true
//解释：同时倒满两个水壶。现在两个水壶中水的总量等于 3。 
//
// 
//
// 提示: 
//
// 
// 1 <= x, y, target <= 10³ 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数学 👍 535 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class WaterAndJugProblem {
    public static void main(String[] args) {
        Solution solution = new WaterAndJugProblem().new Solution();
        solution.canMeasureWater(3, 5, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canMeasureWater(int x, int y, int target) {
            Deque<int[]> queue = new ArrayDeque<>();
            Set<Long> seenSet = new HashSet<>();
            queue.addLast(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] first = queue.removeFirst();
                Long hash = hash(first[0], first[1]);
                if (seenSet.contains(hash)) {
                    continue;
                }
                if (first[0] + first[1] == target || first[0] == target || first[1] == target) {
                    return true;
                }
                seenSet.add(hash);
                // x 倒满水
                queue.addLast(new int[]{x, first[1]});
                // x 倒空水
                queue.addLast(new int[]{0, first[1]});
                // y 倒满水
                queue.addLast(new int[]{first[0], y});
                // y 倒空水
                queue.addLast(new int[]{first[0], 0});
                // x 向y倒水
                queue.addLast(new int[]{first[0] - Math.min(first[0], y - first[1]), first[1] + Math.min(first[0], y - first[1])});
                // y 向x倒水
                queue.addLast(new int[]{first[0] + Math.min(first[1], x - first[0]), first[1] - Math.min(first[1], x - first[0])});
            }
            return false;
        }

        private Long hash(int x, int y) {
            return (long) x * 1000000 + y;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}