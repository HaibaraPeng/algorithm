////给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。
////
//// 列表中的每个元素只可能是整数或整数嵌套列表
////
////
////
//// 示例 1：
////
////
////输入：s = "324",
////输出：324
////解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
////
////
//// 示例 2：
////
////
////输入：s = "[123,[456,[789]]]",
////输出：[123,[456,[789]]]
////解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
////1. 一个 integer 包含值 123
////2. 一个包含两个元素的嵌套列表：
////    i.  一个 integer 包含值 456
////    ii. 一个包含一个元素的嵌套列表
////         a. 一个 integer 包含值 789
////
////
////
////
//// 提示：
////
////
//// 1 <= s.length <= 5 * 10⁴
//// s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成
//// 用例保证 s 是可解析的 NestedInteger
//// 输入中的所有值的范围是 [-10⁶, 10⁶]
////
////
//// Related Topics 栈 深度优先搜索 字符串 👍 218 👎 0
//
///**
// * @author dongp
// */
//package leetcode.editor.cn;
//
//import java.util.List;
//
//public class MiniParser {
//    public static void main(String[] args) {
//        Solution solution = new MiniParser().new Solution();
//        System.out.println(solution.deserialize("[123,[456,[789]]]"));
//    }
//
//    public interface NestedInteger {
//        // Constructor initializes an empty nested list.
////        public NestedInteger();
//
//        // Constructor initializes a single integer.
////        public NestedInteger(int value);
//
//        // @return true if this NestedInteger holds a single integer, rather than a nested list.
//        public boolean isInteger();
//
//        // @return the single integer that this NestedInteger holds, if it holds a single integer
//        // Return null if this NestedInteger holds a nested list
//        public Integer getInteger();
//
//        // Set this NestedInteger to hold a single integer.
//        public void setInteger(int value);
//
//        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//        public void add(NestedInteger ni);
//
//        // @return the nested list that this NestedInteger holds, if it holds a nested list
//        // Return empty list if this NestedInteger holds a single integer
//        public List<NestedInteger> getList();
//    }
//
//    //leetcode submit region begin(Prohibit modification and deletion)
//
//    /**
//     * // This is the interface that allows for creating nested lists.
//     * // You should not implement it, or speculate about its implementation
//     * public interface NestedInteger {
//     * // Constructor initializes an empty nested list.
//     * public NestedInteger();
//     * <p>
//     * // Constructor initializes a single integer.
//     * public NestedInteger(int value);
//     * <p>
//     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
//     * public boolean isInteger();
//     * <p>
//     * // @return the single integer that this NestedInteger holds, if it holds a single integer
//     * // Return null if this NestedInteger holds a nested list
//     * public Integer getInteger();
//     * <p>
//     * // Set this NestedInteger to hold a single integer.
//     * public void setInteger(int value);
//     * <p>
//     * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//     * public void add(NestedInteger ni);
//     * <p>
//     * // @return the nested list that this NestedInteger holds, if it holds a nested list
//     * // Return empty list if this NestedInteger holds a single integer
//     * public List<NestedInteger> getList();
//     * }
//     */
//    class Solution {
//        //递归函数通过字符数组和cur下标确定要处理的位置
//        char[] chars;
//        int cur = 0;
//        public NestedInteger deserialize(String s) {
//            chars = s.toCharArray();
//            //本身不是一个集合而是一个整数的情况
//            if(chars[0]!='[') return new NestedInteger(Integer.valueOf(s));
//            //调用递归函数返回根集合
//            return getNest();
//        }
//        public NestedInteger getNest(){
//            NestedInteger nest = new NestedInteger();
//            int num = 0;//num用于缓存用逗号分割的整数类型的值
//            int sign = 1;//当前记录的整数的符号，1代表整数，-1代表负数
//            while(cur!=chars.length-1){
//                cur ++;
//                if(chars[cur]==',') continue;
//                if(chars[cur]=='[') nest.add(getNest());//遇到[递归获取子集合
//                else if(chars[cur]==']') return nest;
//                else if(chars[cur]=='-') sign = -1;
//                else{//是数字的情况
//                    num = 10*num + sign * (chars[cur]-'0');
//                    //如果下一个字符是,或者]说明当前数字已经记录完了，需要加入集合中
//                    if(chars[cur+1]==','||chars[cur+1]==']'){
//                        nest.add(new NestedInteger(num));
//                        num = 0;
//                        sign = 1;
//                    }
//                }
//            }
//            return null;
//        }
//    }
////leetcode submit region end(Prohibit modification and deletion)
//
//}