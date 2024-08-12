//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aacecaaa"
//输出："aaacecaaa"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出："dcbabcd"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 👍 593 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new ShortestPalindrome().new Solution();
        solution.shortestPalindrome("abbd");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            if (s.length() == 0) {
                return "";
            }
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (isCircular(s, left, right)) {
                    break;
                }
                right--;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s.substring(right + 1)).reverse().append(s);
            return sb.toString();
        }

        private boolean isCircular(String s, int left, int right) {
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}