//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
//
// Related Topics 设计 树状数组 线段树 数组 👍 743 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class RangeSumQueryMutable {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        int[] tree;
        int n;

        public NumArray(int[] nums) {
            if (nums.length > 0) {
                n = nums.length;
                tree = new int[n * 2];
                buildTree(nums);
            }
        }

        private void buildTree(int[] nums) {
            for (int i = n, j = 0; i < 2 * n; i++, j++) {
                tree[i] = nums[j];
            }
            for (int i = n - 1; i > 0; i--) {
                tree[i] = tree[i * 2] + tree[i * 2 + 1];
            }
        }

        public void update(int index, int val) {
            index += n;
            tree[index] = val;
            while (index > 0) {
                int left = index;
                int right = index;
                if (index % 2 == 0) {
                    right = index + 1;
                } else {
                    left = index - 1;
                }
                tree[index / 2] = tree[left] + tree[right];
                index /= 2;
            }
        }

        public int sumRange(int left, int right) {
            left += n;
            right += n;
            int sum = 0;
            while (left <= right) {
                if (left % 2 == 1) {
                    sum += tree[left];
                    left++;
                }
                if (right % 2 == 0) {
                    sum += tree[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }
            return sum;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}