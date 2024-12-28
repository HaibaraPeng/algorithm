//给你一个大小为 m x n 的矩阵 board 表示棋盘，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在棋盘 board 上放置的
// 舰队 的数量。 
//
// 舰队 只能水平或者垂直放置在 board 上。换句话说，舰队只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状放置，其中 k 可以
//是任意大小。两个舰队之间至少有一个水平或垂直的空格分隔 （即没有相邻的舰队）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
//
// Related Topics 深度优先搜索 数组 矩阵 👍 304 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class BattleshipsInABoard {
    public static void main(String[] args) {
        Solution solution = new BattleshipsInABoard().new Solution();
        solution.countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBattleships(char[][] board) {
            int m = board.length, n = board[0].length, res = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        res++;
                        dfs(board, i, j, m, n);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] board, int i, int j, int m, int n) {
            board[i][j] = '0';
            while (i + 1 < m && board[i + 1][j] == 'X') {
                dfs(board, i + 1, j, m, n);
            }
            while (j + 1 < n && board[i][j + 1] == 'X') {
                dfs(board, i, j + 1, m, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}