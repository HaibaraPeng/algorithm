//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 546 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            int numRows = rowIndex + 1;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i <= numRows; i++) {
                List<Integer> list = new ArrayList<>();
                if (i == 1) {
                    list.add(1);
                } else {
                    List<Integer> preList = res.get(i - 2);
                    int size = preList.size() - 1;
                    list.add(1);
                    for (int j = 0; j < size; j++) {
                        list.add(preList.get(j) + preList.get(j + 1));
                    }
                    list.add(1);
                }
                res.add(list);
            }
            return res.get(rowIndex);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}