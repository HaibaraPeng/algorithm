//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2330 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        solution.sortList(listNode);
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
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return tail;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) fast = fast.next;
            }
            return merge(sortList(head, slow), sortList(slow, tail));
        }

        private ListNode merge(ListNode left, ListNode right) {
            if (left == null && right == null) {
                return null;
            }
            ListNode pre = new ListNode(0);
            ListNode temp = pre;
            while (left != null || right != null) {
                if (left == null) {
                    temp.next = right;
                    break;
                }
                if (right == null) {
                    temp.next = left;
                    break;
                }
                if (left.val <= right.val) {
                    temp.next = left;
                    left = left.next;
                } else {
                    temp.next = right;
                    right = right.next;
                }
                temp = temp.next;
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}