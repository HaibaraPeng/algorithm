//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3506 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(4);
        solution.mergeTwoLists(list1, list2);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode head = new ListNode();
            ListNode pre = head;
            while (list1 != null || list2 != null) {
                if (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        head.next = list1;
                        list1 = list1.next;
                    } else {
                        head.next = list2;
                        list2 = list2.next;
                    }
                } else if (list1 != null) {
                    head.next = list1;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    list2 = list2.next;
                }
                head = head.next;
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}