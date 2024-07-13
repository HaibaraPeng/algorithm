//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 748 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class PalindromePartitioningIi {
    public static void main(String[] args) {
        Solution solution = new PalindromePartitioningIi().new Solution();
        solution.minCut("aab");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCut(String s) {
            int n = s.length();
            int[] dp = new int[n];
            Arrays.fill(dp, Integer.MAX_VALUE);
            int[][] paDp = new int[n][n];
            for (int i = 0; i < n; i++) {
                if (isPalindrome(paDp, s, 0, i)) {
                    dp[i] = 0;
                } else {
                    for (int j = 1; j <= i; j++) {
                        if (isPalindrome(paDp, s, j, i)) {
                            dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                        }
                    }
                }
            }
            return dp[n - 1];
        }

        private boolean isPalindrome(int[][] paDp, String s, int left, int right) {
            int l = left, r = right;
            while (l < r) {
                if (paDp[l][r] != 0) {
                    boolean res = paDp[l][r] == 1;
                    paDp[left][right] = res ? 1 : -1;
                    return res;
                }
                if (s.charAt(l) != s.charAt(r)) {
                    paDp[left][right] = -1;
                    return false;
                }
                l++;
                r--;
            }
            paDp[left][right] = 1;
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}