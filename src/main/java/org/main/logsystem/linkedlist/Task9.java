package org.main.logsystem.linkedlist;

public class Task9 {
    public ListNode splitLinkedList(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode lessThanX = new ListNode(0);
        ListNode greaterOrEqualX = new ListNode(0);
        ListNode lessThanXCurrent = lessThanX;
        ListNode greaterOrEqualXCurrent = greaterOrEqualX;

        while (head != null) {
            if (head.val < x) {
                lessThanXCurrent.next = head;
                lessThanXCurrent = lessThanXCurrent.next;
            } else {
                greaterOrEqualXCurrent.next = head;
                greaterOrEqualXCurrent = greaterOrEqualXCurrent.next;
            }
            head = head.next;
        }

        lessThanXCurrent.next = greaterOrEqualX.next;
        greaterOrEqualXCurrent.next = null;

        return lessThanX.next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);

        System.out.println("Example 1:");
        System.out.print("Input: ");
        printList(head1);

        Task9 splitter1 = new Task9();
        ListNode result1 = splitter1.splitLinkedList(head1, 3);

        System.out.print("Output: ");
        printList(result1);

        // Example 2
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(1);

        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printList(head2);

        Task9 splitter2 = new Task9();
        ListNode result2 = splitter2.splitLinkedList(head2, 2);

        System.out.print("Output: ");
        printList(result2);
    }
}
