package com.letcode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question13 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * 没通过的原因是，如果只有一顶点怎么版，删除都是让前一个指向后一个，跳过中间这个，所以找到前一个很重要，但是只有一个的时候，不存在前一个。
     * @param head
     * @param n
     * @return
     */
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            if (head==null){
                return null;
            }
            ListNode rootTemp = head;
            int i = 1;
            int j = 1;
            while (rootTemp.next!=null){
                i++;
                rootTemp = rootTemp.next;
            }

            rootTemp = head;
            while (rootTemp.next!=null){
                if (j==i-n){
                    break;
                }
                j++;
                rootTemp = rootTemp.next;
            }

            if (rootTemp.next!=null)
                rootTemp = rootTemp.next.next;
            else {
                rootTemp = null;
            }
            return head;
        }


    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head==null){
            return null;
        }
        ListNode rootTemp = head;
        int i = 1;
        int j = 1;
        while (rootTemp.next!=null){
            i++;
            rootTemp = rootTemp.next;
        }

        rootTemp = head;
        while (rootTemp.next!=null){
            if (j==i-n){
                break;
            }
            j++;
            rootTemp = rootTemp.next;
        }

        if (rootTemp.next!=null)
            rootTemp = rootTemp.next.next;
        else {
            rootTemp = null;
        }
        return head;
    }

    /**
     * public ListNode removeNthFromEnd(ListNode head, int n) {
     *     ListNode dummy = new ListNode(0);
     *     dummy.next = head;
     *     int length  = 0;
     *     ListNode first = head;
     *     while (first != null) {
     *         length++;
     *         first = first.next;
     *     }
     *     length -= n;
     *     first = dummy;
     *     while (length > 0) {
     *         length--;
     *         first = first.next;
     *     }
     *     first.next = first.next.next;
     *     return dummy.next;
     * }
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = null;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        removeNthFromEnd(listNode1,2);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}