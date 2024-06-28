//使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
//
// 
// 如果字符串的长度为 1 ，算法停止 
// 如果字符串的长度 > 1 ，执行下述步骤： 
// 
// 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。 
// 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + 
//x 。 
// 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。 
// 
// 
//
// 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "great", s2 = "rgeat"
//输出：true
//解释：s1 上可能发生的一种情形是：
//"great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
//"gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
//"gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
//"g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
//"r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
//"r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
//算法终止，结果字符串和 s2 相同，都是 "rgeat"
//这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abcde", s2 = "caebd"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "a", s2 = "a"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// s1.length == s2.length 
// 1 <= s1.length <= 30 
// s1 和 s2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 568 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ScrambleString {
    public static void main(String[] args) {
        Solution solution = new ScrambleString().new Solution();
        solution.isScramble("great", "rgeat");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean isScramble(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            int[][][][] dp = new int[s1.length()][s1.length()][s2.length()][s2.length()];
            return dfs(dp, s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
        }

        private boolean dfs(int[][][][] dp, String s1, String s2, int s1left, int s1right, int s2left, int s2right) {
            if (dp[s1left][s1right][s2left][s2right] > 0) {
                return dp[s1left][s1right][s2left][s2right] == 1;
            }
            if (s1right - s1left != s2right - s2left) {
                dp[s1left][s1right][s2left][s2right] = 2;
                return false;
            }
            if (s1left == s1right && s2left == s2right) {
                boolean res = s1.charAt(s1left) == s2.charAt(s2left);
                dp[s1left][s1right][s2left][s2right] = res ? 1 : 2;
                return res;
            }
            for (int i = s1left; i < s1right; i++) {
                if (dfs(dp, s1, s2, s1left, i, s2left, s2left + i - s1left) && dfs(dp, s1, s2, i + 1, s1right, s2left + i - s1left + 1, s2right)) {
                    dp[s1left][s1right][s2left][s2right] = 1;
                    return true;
                }
                if (dfs(dp, s1, s2, s1left, i, s2right - i + s1left, s2right) && dfs(dp, s1, s2, i + 1, s1right, s2left, s2right - i + s1left - 1)) {
                    dp[s1left][s1right][s2left][s2right] = 1;
                    return true;
                }
            }
            dp[s1left][s1right][s2left][s2right] = 2;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}