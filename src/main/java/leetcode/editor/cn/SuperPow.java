//你的任务是计算 aᵇ 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = [3]
//输出：8
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = [1,0]
//输出：1024
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = [4,3,3,8,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：a = 2147483647, b = [2,0,0]
//输出：1198
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 2³¹ - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b 不含前导 0 
// 
//
// Related Topics 数学 分治 👍 335 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class SuperPow {
    public static void main(String[] args) {
        Solution solution = new SuperPow().new Solution();
        solution.superPow(2147483647, new int[]{2, 0, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = 1337;
        public int superPow(int a, int[] b) {
            return dfs(a, b, b.length - 1);
        }
        int dfs(int a, int[] b, int u) {
            if (u == 0) {
                return pow(a, b[0]);
            }
            return pow(dfs(a, b, u - 1), 10) * pow(a, b[u]) % MOD;
        }
        int pow(int a, int b) {
            int mod = a % MOD;
            int ans = 1;
            while (b > 0) {
                ans = ans * mod % MOD;
                b--;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}