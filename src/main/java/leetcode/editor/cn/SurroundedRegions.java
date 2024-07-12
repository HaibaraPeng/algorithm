//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域： 
//
// 
// 连接：一个单元格与水平或垂直方向上相邻的单元格连接。 
// 区域：连接所有 'O' 的单元格来形成一个区域。 
// 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。 
// 
//
// 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
// 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]] 
// 
//
// 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]] 
//
//
// 解释： 
// 
// 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。 
//
// 示例 2： 
//
// 
// 输入：board = [["X"]] 
// 
//
// 输出：[["X"]] 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1130 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
        solution.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solve(char[][] board) {
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') {
                    render(board, i, 0, 'O', 'A');
                }
                if (board[i][n - 1] == 'O') {
                    render(board, i, n - 1, 'O', 'A');
                }
            }
            for (int i = 0; i < n; i++) {
                if (board[0][i] == 'O') {
                    render(board, 0, i, 'O', 'A');
                }
                if (board[m - 1][i] == 'O') {
                    render(board, m - 1, i, 'O', 'A');
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') board[i][j] = 'X';
                    if (board[i][j] == 'A') board[i][j] = 'O';
                }
            }
        }

        private void render(char[][] board, int m, int n, char oldChar, char newChar) {
            board[m][n] = newChar;
            if (m > 0 && board[m - 1][n] == oldChar) {
                render(board, m - 1, n, oldChar, newChar);
            }
            if (m < board.length - 1 && board[m + 1][n] == oldChar) {
                render(board, m + 1, n, oldChar, newChar);
            }
            if (n > 0 && board[m][n - 1] == oldChar) {
                render(board, m, n - 1, oldChar, newChar);
            }
            if (n < board[0].length - 1 && board[m][n + 1] == oldChar) {
                render(board, m, n + 1, oldChar, newChar);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}