package org.main.logsystem.recursion;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class second {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = head.next;

        ListNode temp = head.next.next;
        head.next.next = head;
        head.next = swapPairs(temp);

        return newHead;
    }

    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        second swapper = new second();

        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        System.out.println("Before:");
        swapper.printList(head1);

        ListNode result1 = swapper.swapPairs(head1);

        System.out.println("After:");
        swapper.printList(result1);

        // Example 2
        ListNode head2 = null;

        System.out.println("Before:");
        swapper.printList(head2);

        ListNode result2 = swapper.swapPairs(head2);

        System.out.println("After:");
        swapper.printList(result2);

        // Example 3
        ListNode head3 = new ListNode(1);

        System.out.println("Before:");
        swapper.printList(head3);

        ListNode result3 = swapper.swapPairs(head3);

        System.out.println("After:");
        swapper.printList(result3);
    }
}
