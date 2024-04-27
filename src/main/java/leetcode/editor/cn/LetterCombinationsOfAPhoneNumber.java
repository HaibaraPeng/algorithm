//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2805 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<String, String[]> map = new HashMap<String, String[]>() {{
            put("2", new String[]{"a", "b", "c"});
            put("3", new String[]{"d", "e", "f"});
            put("4", new String[]{"g", "h", "i"});
            put("5", new String[]{"j", "k", "l"});
            put("6", new String[]{"m", "n", "o"});
            put("7", new String[]{"p", "q", "r", "s"});
            put("8", new String[]{"t", "u", "v"});
            put("9", new String[]{"w", "x", "y", "z"});
        }};

        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if (digits.length() == 0) {
                return res;
            }
            dfs(digits, 0, new StringBuilder(), res);
            return res;
        }

        public void dfs(String digits, int i, StringBuilder sb, List<String> res) {
            if (i == digits.length()) {
                res.add(sb.toString());
                return;
            }
            String[] strings = map.get(digits.substring(i, i + 1));
            for (String s : strings) {
                sb.append(s);
                dfs(digits, i + 1, sb, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}