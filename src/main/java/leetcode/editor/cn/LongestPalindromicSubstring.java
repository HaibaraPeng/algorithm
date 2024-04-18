//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7162 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                // 回文串为奇数
                int l = i - 1, r = i + 1;
                String sub = getString(s, l, r);
                if (sub.length() > ans.length()) ans = sub;

                // 回文串为偶数
                l = i - 1;
                r = i + 1 - 1;
                sub = getString(s, l, r);
                if (sub.length() > ans.length()) ans = sub;
            }
            return ans;
        }
        String getString(String s, int l, int r) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}