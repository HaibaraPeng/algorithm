//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
// 
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 881 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}}, new String[]{"oa", "oaa"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Node {
            Node[] children = new Node[26];
            boolean isEnd = false;

            public Node() {
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            Node[] roots = new Node[26];
            // 初始化roots
            for (String word : words) {
                Node node = new Node();
                for (int i = 0; i < word.length(); i++) {
                    int index = word.charAt(i) - 'a';
                    if (i == 0) {
                        Node root = roots[index];
                        if (root == null) {
                            roots[index] = node;
                        } else {
                            node = root;
                        }
                    } else {
                        Node child = node.children[index];
                        if (child == null) {
                            node.children[index] = new Node();
                        }
                        node = node.children[index];
                    }
                    if (i == word.length() - 1) {
                        node.isEnd = true;
                    }
                }
            }
            Set<String> res = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    findWords(board, i, j, roots, res, new StringBuilder());
                }
            }
            return new ArrayList<>(res);
        }

        private void findWords(char[][] board, int x, int y, Node[] roots, Set<String> res, StringBuilder stringBuilder) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '0') {
                return;
            }
            char c = board[x][y];
            int index = c - 'a';
            if (roots[index] == null) {
                return;
            }
            stringBuilder.append(c);
            board[x][y] = '0';
            if (roots[index].isEnd) {
                res.add(stringBuilder.toString());
            }
            findWords(board, x - 1, y, roots[index].children, res, stringBuilder);
            findWords(board, x + 1, y, roots[index].children, res, stringBuilder);
            findWords(board, x, y - 1, roots[index].children, res, stringBuilder);
            findWords(board, x, y + 1, roots[index].children, res, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            board[x][y] = c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}