//给定一个字符串 s 和一个字符串字典
// wordDict ，在字符串
// s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。 
//
// 注意：词典中的同一个单词可能在分段中被重复使用多次。 
//
// 
//
// 示例 1： 
//
// 
//输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//输出:["cats and dog","cat sand dog"]
// 
//
// 示例 2： 
//
// 
//输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//输出:[]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 20 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 10 
// s 和 wordDict[i] 仅有小写英文字母组成 
// wordDict 中所有字符串都 不同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 回溯 👍 752 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new WordBreakIi().new Solution();
        solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            int len = s.length();
            List<List<String>> dp = new ArrayList<>();
            dp.add(new ArrayList<>());
            for (int i = 1; i <= len; i++) {
                List<String> list = new ArrayList<>();
                for (int j = i - 1; j >= 0; j--) {
                    String str = s.substring(j, i);
                    if (set.contains(str)) {
                        if (j == 0) {
                            list.add(str);
                            break;
                        } else if (!dp.get(j).isEmpty()) {
                            List<String> dpList = dp.get(j);
                            for (String string : dpList) {
                                list.add(string + " " + str);
                            }
                        }
                    }
                }
                dp.add(list);
            }
            return dp.get(len);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}