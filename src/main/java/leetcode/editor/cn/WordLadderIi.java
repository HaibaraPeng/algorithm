//按字典 wordList 完成从单词 beginWord 到单词 endWord 转化，一个表示此过程的 转换序列 是形式上像 beginWord -> 
//s1 -> s2 -> ... -> sk 这样的单词序列，并满足： 
//
// 
// 
// 
// 每对相邻的单词之间仅有单个字母不同。 
// 转换过程中的每个单词 si（1 <= i <= k）必须是字典 wordList 中的单词。注意，beginWord 不必是字典 wordList 中的单
//词。 
// sk == endWord 
// 
// 
// 
//
// 给你两个单词 beginWord 和 endWord ，以及一个字典 wordList 。请你找出并返回所有从 beginWord 到 endWord 的
// 最短转换序列 ，如果不存在这样的转换序列，返回一个空列表。每个序列都应该以单词列表 [beginWord, s1, s2, ..., sk] 的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
//解释：存在 2 种最短的转换序列：
//"hit" -> "hot" -> "dot" -> "dog" -> "cog"
//"hit" -> "hot" -> "lot" -> "log" -> "cog"
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：[]
//解释：endWord "cog" 不在字典 wordList 中，所以不存在符合要求的转换序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 5 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 500 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有单词 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 回溯 👍 718 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.*;

public class WordLadderIi {
    public static void main(String[] args) {
        Solution solution = new WordLadderIi().new Solution();
        List<List<String>> ladders = solution.findLadders("magic", "pearl", Arrays.asList("flail", "halon", "lexus", "joint", "pears",
                "slabs", "lorie", "lapse", "wroth", "yalow", "swear", "cavil", "piety", "yogis", "dhaka", "laxer", "tatum",
                "provo", "truss", "tends", "deana", "dried", "hutch", "basho", "flyby", "miler", "fries", "floes", "lingo",
                "wider", "scary", "marks", "perry", "igloo", "melts", "lanny", "satan", "foamy", "perks", "denim", "plugs",
                "cloak", "cyril", "women", "issue", "rocky", "marry", "trash", "merry", "topic", "hicks", "dicky", "prado",
                "casio", "lapel", "diane", "serer", "paige", "parry", "elope", "balds", "dated", "copra", "earth", "marty",
                "slake", "balms", "daryl", "loves", "civet", "sweat", "daley", "touch", "maria", "dacca", "muggy", "chore",
                "felix", "ogled", "acids", "terse", "cults", "darla", "snubs", "boats", "recta", "cohan", "purse", "joist",
                "grosz", "sheri", "steam", "manic", "luisa", "gluts", "spits", "boxer", "abner", "cooke", "scowl", "kenya",
                "hasps", "roger", "edwin", "black", "terns", "folks", "demur", "dingo", "party", "brian", "numbs", "forgo",
                "gunny", "waled", "bucks", "titan", "ruffs", "pizza", "ravel", "poole", "suits", "stoic", "segre", "white",
                "lemur", "belts", "scums", "parks", "gusts", "ozark", "umped", "heard", "lorna", "emile", "orbit", "onset",
                "cruet", "amiss", "fumed", "gelds", "italy", "rakes", "loxed", "kilts", "mania", "tombs", "gaped", "merge",
                "molar", "smith", "tangs", "misty", "wefts", "yawns", "smile", "scuff", "width", "paris", "coded", "sodom",
                "shits", "benny", "pudgy", "mayer", "peary", "curve", "tulsa", "ramos", "thick", "dogie", "gourd", "strop",
                "ahmad", "clove", "tract", "calyx", "maris", "wants", "lipid", "pearl", "maybe", "banjo", "south", "blend",
                "diana", "lanai", "waged", "shari", "magic", "duchy", "decca", "wried", "maine", "nutty", "turns", "satyr",
                "holds", "finks", "twits", "peaks", "teems", "peace", "melon", "czars", "robby", "tabby", "shove", "minty",
                "marta", "dregs", "lacks", "casts", "aruba", "stall", "nurse", "jewry", "knuth"));
        System.out.println("1111");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            // 因为需要快速判断扩展出的单词是否在 wordList 里，因此需要将 wordList 存入哈希表，这里命名为「字典」
            Set<String> dict = new HashSet<>(wordList);
            // 特殊用例判断
            if (!dict.contains(endWord)) {
                return res;
            }

            dict.remove(beginWord);

            // 第 1 步：广度优先遍历建图
            // 记录扩展出的单词是在第几次扩展的时候得到的，key：单词，value：在广度优先遍历的第几层
            Map<String, Integer> steps = new HashMap<>();
            steps.put(beginWord, 0);
            // 记录了单词是从哪些单词扩展而来，key：单词，value：单词列表，这些单词可以变换到 key ，它们是一对多关系
            Map<String, List<String>> from = new HashMap<>();
            int step = 1;
            boolean found = false;
            int wordLen = beginWord.length();
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String currWord = queue.poll();
                    char[] charArray = currWord.toCharArray();
                    // 将每一位替换成 26 个小写英文字母
                    for (int j = 0; j < wordLen; j++) {
                        char origin = charArray[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            charArray[j] = c;
                            String nextWord = String.valueOf(charArray);
                            if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                                from.get(nextWord).add(currWord);
                            }
                            if (!dict.contains(nextWord)) {
                                continue;
                            }
                            // 如果从一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜索到已经遍历到，且距离更远的单词，需要将它从 dict 中删除
                            dict.remove(nextWord);
                            // 这一层扩展出的单词进入队列
                            queue.offer(nextWord);

                            // 记录 nextWord 从 currWord 而来
                            from.putIfAbsent(nextWord, new ArrayList<>());
                            from.get(nextWord).add(currWord);
                            // 记录 nextWord 的 step
                            steps.put(nextWord, step);
                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                        charArray[j] = origin;
                    }
                }
                step++;
                if (found) {
                    break;
                }
            }

            // 第 2 步：深度优先遍历找到所有解，从 endWord 恢复到 beginWord ，所以每次尝试操作 path 列表的头部
            if (found) {
                Deque<String> path = new ArrayDeque<>();
                path.add(endWord);
                dfs(from, path, beginWord, endWord, res);
            }
            return res;
        }

        public void dfs(Map<String, List<String>> from, Deque<String> path, String beginWord, String cur, List<List<String>> res) {
            if (cur.equals(beginWord)) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (String precursor : from.get(cur)) {
                path.addFirst(precursor);
                dfs(from, path, beginWord, precursor, res);
                path.removeFirst();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}