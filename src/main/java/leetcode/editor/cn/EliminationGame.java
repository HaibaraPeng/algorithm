//列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法： 
//
// 
// 
// 
// 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。 
// 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。 
// 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 
// 
// 
// 
//
// 给你整数 n ，返回 arr 最后剩下的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 9
//输出：6
//解释：
//arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//arr = [2, 4, 6, 8]
//arr = [2, 6]
//arr = [6]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 递归 数学 👍 344 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class EliminationGame {
    public static void main(String[] args) {
        Solution solution = new EliminationGame().new Solution();
        solution.lastRemaining(9);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lastRemaining(int n) {
            int a1 = 1;               // 初始的第一个数字是 1
            int k = 0;                // 轮次，从 0 开始
            int cnt = n;              // 当前剩余数字总数，初始化为 n
            int step = 1;             // 相邻两个数字的间隔，初始化为 1

            // 当剩余数字大于 1 时，继续删除
            while (cnt > 1) {
                if (k % 2 == 0) { // 正向删除
                    a1 = a1 + step;  // 每次正向删除后，第一个数字必然增加 step
                } else { // 反向删除
                    a1 = (cnt % 2 == 0) ? a1 : a1 + step;
                    // 如果当前剩余数字为奇数，反向删除后第一个数字会增加 step；
                    // 如果为偶数，第一个数字保持不变。
                }
                k++;                 // 轮次增加
                cnt = cnt >> 1;      // 当前剩余数字总数减半
                step = step << 1;    // 相邻两个数字间隔翻倍
            }

            return a1;               // 最后剩下的数字即为答案
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
