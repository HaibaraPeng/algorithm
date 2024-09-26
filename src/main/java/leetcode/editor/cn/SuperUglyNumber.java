//超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。 
//
// 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。 
//
// 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12, primes = [2,7,13,19]
//输出：32 
//解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,
//28,32] 。 
//
// 示例 2： 
//
// 
//输入：n = 1, primes = [2,3,5]
//输出：1
//解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
// 
//
// 
//
// 
// 
// 
// 提示： 
// 
// 
// 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= primes.length <= 100 
// 2 <= primes[i] <= 1000 
// 题目数据 保证 primes[i] 是一个质数 
// primes 中的所有值都 互不相同 ，且按 递增顺序 排列 
// 
//
// Related Topics 数组 数学 动态规划 👍 412 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperUglyNumber {
    public static void main(String[] args) {
        Solution solution = new SuperUglyNumber().new Solution();
        solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            long[] dp = new long[n];
            dp[0] = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int prime : primes) {
                map.put(prime, 0);
            }
            long min = Long.MAX_VALUE;
            List<Integer> primesList = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                for (int p : primes) {
                    long value = dp[map.get(p)] * p;
                    if (value < min) {
                        min = value;
                        primesList.clear();
                        primesList.add(p);
                    } else if (value == min) {
                        primesList.add(p);
                    }
                }
                dp[i] = min;
                for (Integer prime : primesList) {
                    map.put(prime, map.get(prime) + 1);
                }
                min = Long.MAX_VALUE;
            }
            return (int) dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}