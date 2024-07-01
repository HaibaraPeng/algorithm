//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1425 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("0279245587303");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> res = new ArrayList<>();
            dfs(s, 0, 0, s.length(), new ArrayList<>(), res);
            return res;
        }

        private void dfs(String s, int index, int left, int right, ArrayList<Integer> list, List<String> res) {
            if (left == right) {
                return;
            }
            if (index == 3) {
                if (s.charAt(left) == '0' && left + 1 != right) {
                    return;
                }
                long value = Long.parseLong(s.substring(left, right));
                if (value <= 255) {
                    list.add((int) value);
                    StringBuilder sb = new StringBuilder();
                    for (Integer i : list) {
                        sb.append(i).append(".");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    res.add(sb.toString());
                    list.remove(list.size() - 1);
                    return;
                }
                return;
            }
            if (s.charAt(left) == '0') {
                list.add(0);
                dfs(s, index + 1, left + 1, right, list, res);
                list.remove(list.size() - 1);
                return;
            }
            for (int i = left; i < right; i++) {
                int value = Integer.parseInt(s.substring(left, i + 1));
                if (value <= 255) {
                    list.add(value);
                    dfs(s, index + 1, i + 1, right, list, res);
                    list.remove(list.size() - 1);
                } else {
                    return;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}