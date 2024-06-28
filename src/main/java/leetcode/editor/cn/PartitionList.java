//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 842 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        solution.partition(node, 3);
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
        public ListNode partition(ListNode head, int x) {
            if (head == null) {
                return head;
            }
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode smail = pre;
            ListNode node = pre;
            boolean isSame = true;
            while (node.next != null) {
                if (node.next.val >= x) {
                    node = node.next;
                    isSame = false;
                } else if (isSame) {
                    smail = smail.next;
                    node = node.next;
                } else {
                    ListNode smailNode = node.next;
                    node.next = node.next.next;
                    ListNode temp = smail.next;
                    smail.next = smailNode;
                    smailNode.next = temp;
                    smail = smail.next;
                }
            }
            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}