//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2926 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("aaflslflsldkalskaaa", "aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            int[] tarr = new int[128];
            int count = 0;
            for (int i = 0; i < t.length(); i++) {
                if (tarr[t.charAt(i)] == 0) {
                    count++;
                }
                tarr[t.charAt(i)]++;
            }
            int[] sarr = new int[128];
            String res = "";
            int left = 0, right = t.length() - 1;

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = left; i <= right; i++) {
                Character c = s.charAt(i);
                sarr[c]++;
                if (tarr[c] == sarr[c]) {
                    count--;
                }
                stringBuilder.append(c);
            }

            while (right - left + 1 >= t.length()) {
                if (stringBuilder.length() == res.length()) {
                    sarr[s.charAt(left)]--;
                    if (sarr[s.charAt(left)] + 1 == tarr[s.charAt(left)]) {
                        count++;
                    }
                    left++;
                    stringBuilder.deleteCharAt(0);
                    continue;
                }
                boolean equal = count == 0;
                if (equal) {
                    res = stringBuilder.toString();
                    sarr[s.charAt(left)]--;
                    if (sarr[s.charAt(left)] + 1 == tarr[s.charAt(left)]) {
                        count++;
                    }
                    left++;
                    stringBuilder.deleteCharAt(0);
                }
                if (right == s.length() - 1 && !equal) {
                    break;
                }
                if (!equal && right < s.length() - 1) {
                    Character c = s.charAt(++right);
                    sarr[c]++;
                    if (tarr[c] == sarr[c]) {
                        count--;
                    }
                    stringBuilder.append(c);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}