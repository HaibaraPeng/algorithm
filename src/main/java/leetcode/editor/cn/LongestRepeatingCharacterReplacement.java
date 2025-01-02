//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。 
//
// 在执行上述操作后，返回 包含相同字母的最长子字符串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
//可能存在其他的方法来得到同样的结果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由大写英文字母组成 
// 0 <= k <= s.length 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 899 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution solution = new LongestRepeatingCharacterReplacement().new Solution();
        solution.characterReplacement("ABAB", 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] arr = new int[26];
            char[] chars = s.toCharArray();
            int len = s.length();
            int res = 0;
            if (k >= len - 1) {
                return len;
            }
            int left = 0, right = 0;
            // 初始化
            for (; right < k + 1; right++) {
                int v = chars[right] - 'A';
                arr[v]++;
            }
            res = right - left;
            for (; right < len; right++) {
                arr[chars[right] - 'A']++;
                if (right - left < res) {
                    continue;
                }
                // 获取最大值
                int max = 0;
                for (int i : arr) {
                    max = Math.max(i, max);
                }
                while (right - left + 1 - max > k) {
                    arr[chars[left++] - 'A']--;
                    for (int i : arr) {
                        max = Math.max(i, max);
                    }
                }
                res = Math.max(res, right - left + 1);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}