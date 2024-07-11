//字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1383 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        Solution solution = new WordLadder().new Solution();
        solution.ladderLength("hot", "dog", Arrays.asList("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }
            Deque<String> beginQueue = new LinkedList<>();
            Map<String, Integer> beginMap = new HashMap<>();
            Deque<String> endQueue = new LinkedList<>();
            Map<String, Integer> endMap = new HashMap<>();
            beginQueue.addLast(beginWord);
            beginMap.put(beginWord, 0);
            endQueue.addLast(endWord);
            endMap.put(endWord, 0);
            while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
                int res = -1;
                if (beginQueue.size() > endQueue.size()) {
                    res = bfs(endQueue, false, beginMap, endMap, wordSet);
                } else {
                    res = bfs(beginQueue, true, beginMap, endMap, wordSet);
                }
                if (res > -1) {
                    return res;
                }
            }
            return 0;
        }

        private int bfs(Deque<String> queue, boolean isBegin, Map<String, Integer> beginMap, Map<String, Integer> endMap, Set<String> wordSet) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String first = queue.removeFirst();
                for (int j = 0; j < first.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        char c = (char) ('a' + k);
                        String newWord = first.substring(0, j) + c + first.substring(j + 1);
                        if (!wordSet.contains(newWord) || newWord.equals(first)) {
                            continue;
                        }
                        if (isBegin) {
                            if (beginMap.containsKey(newWord)) {
                                continue;
                            } else if (endMap.containsKey(newWord)) {
                                return beginMap.get(first) + endMap.get(newWord) + 2;
                            } else {
                                beginMap.put(newWord, beginMap.get(first) + 1);
                            }
                        } else {
                            if (endMap.containsKey(newWord)) {
                                continue;
                            } else if (beginMap.containsKey(newWord)) {
                                return endMap.get(first) + beginMap.get(newWord) + 2;
                            } else {
                                endMap.put(newWord, endMap.get(first) + 1);
                            }
                        }
                        queue.addLast(newWord);
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}