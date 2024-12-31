//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
//
// Related Topics 哈希表 数学 字符串 👍 215 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.Arrays;

public class ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        Solution solution = new ReconstructOriginalDigitsFromEnglish().new Solution();
        solution.originalDigits("zerozerozero");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};

        public String originalDigits(String s) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int p : priority) {
                String num = ss[p];
                int min = Integer.MAX_VALUE;
                for (char c : num.toCharArray()) {
                    min = Math.min(min, arr[c - 'a']);
                }
                for (char c : num.toCharArray()) {
                    arr[c - 'a'] -= min;
                }
                for (int i = 0; i < min; i++) {
                    sb.append(p);
                }
            }
            char[] charArray = sb.toString().toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}