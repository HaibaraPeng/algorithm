//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2326 👎 0

/**
 * @author dongp
 */
package leetcode.editor.cn;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode listNode = solution.reverseKGroup(node, 2);
        System.out.println(1);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode cur = dummy;
            while (cur != null) {
                reverse(cur, k);
                int u = k;
                while (u-- > 0 && cur != null) cur = cur.next;
            }
            return dummy.next;
        }

        public void reverse(ListNode root, int k) {
            // 检查 root 后面是否有 k 个节点
            int u = k;
            ListNode cur = root;
            while (u-- > 0 && cur != null) cur = cur.next;
            if (cur == null) return;
            // 进行翻转
            ListNode tail = cur.next;
            ListNode a = root.next, b = a.next;
            // 当需要翻转 k 个节点时，中间有 k - 1 个 next 指针需要翻转
            while (k-- > 1) {
                ListNode c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            root.next.next = tail;
            root.next = a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}