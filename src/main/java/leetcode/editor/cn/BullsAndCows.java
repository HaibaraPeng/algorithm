//你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下： 
//
// 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示： 
//
// 
// 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛）， 
// 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。 
// 
//
// 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。 
//
// 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。 
//
// 请注意秘密数字和朋友猜测的数字都可能含有重复数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：secret = "1807", guess = "7810"
//输出："1A3B"
//解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
//"1807"
//  |
//"7810" 
//
// 示例 2： 
//
// 
//输入：secret = "1123", guess = "0111"
//输出："1A1B"
//解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
//"1123"        "1123"
//  |      or     |
//"0111"        "0111"
//注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。 
//
// 
//
// 提示： 
//
// 
// 1 <= secret.length, guess.length <= 1000 
// secret.length == guess.length 
// secret 和 guess 仅由数字组成 
// 
//
// Related Topics 哈希表 字符串 计数 👍 344 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public static void main(String[] args) {
        Solution solution = new BullsAndCows().new Solution();
        solution.getHint("1123", "0111");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getHint(String secret, String guess) {
            int bullCount = 0, cowCount = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < secret.length(); i++) {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
            for (int i = 0; i < guess.length(); i++) {
                char c = guess.charAt(i);
                if (guess.charAt(i) == secret.charAt(i)) {
                    int num = map.get(c);
                    if (num == 0) {
                        bullCount++;
                        cowCount--;
                    } else {
                        bullCount++;
                        map.put(c, --num);
                    }
                } else if (map.containsKey(c)) {
                    if (map.get(c) > 0) {
                        cowCount++;
                        map.put(c, map.get(c) - 1);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(bullCount).append("A").append(cowCount).append("B");
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}