//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 20 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
//
// Related Topics 递归 字符串 动态规划 👍 3886 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            int sLen = s.length(), pLen = p.length();
            s = " " + s;
            p = " " + p;
            boolean[][] res = new boolean[sLen + 1][pLen + 1];
            res[0][0] = true;
            for (int i = 0; i <= sLen; i++) {
                for (int j = 1; j <= pLen; j++) {
                    if (j + 1 <= pLen && p.charAt(j + 1) == '*' && p.charAt(j) != '*') {
                        continue;
                    }
                    if (i - 1 >= 0 && p.charAt(j) != '*') {
                        res[i][j] = res[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                    } else if (p.charAt(j) == '*') {
                        res[i][j] = (j - 2 >= 0 && res[i][j - 2]) || (i - 1 >= 0 && res[i - 1][j] && (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'));
                    }
                }
            }
            return res[sLen][pLen];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}