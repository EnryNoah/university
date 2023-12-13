package org.main.logsystem.linkedlist;

public class Task6 {
    public ListNode doubleLinkedListNumber(ListNode head) {
        if (head == null) {
            return null;
        }

        head = reverseLinkedList(head);

        ListNode current = head;
        int carry = 0;
        while (current != null) {
            int sum = current.val * 2 + carry;
            current.val = sum % 10;
            carry = sum / 10;

            if (current.next == null && carry > 0) {
                current.next = new ListNode(carry);
                break;
            }

            current = current.next;
        }

        return reverseLinkedList(head);
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
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
        head1.next = new ListNode(8);
        head1.next.next = new ListNode(9);
        System.out.println("Example 1:");
        System.out.print("Input: ");
        printList(head1);
        Task6 doubler1 = new Task6();
        ListNode result1 = doubler1.doubleLinkedListNumber(head1);
        System.out.print("Output: ");
        printList(result1);

        // Example 2
        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printList(head2);
        Task6 doubler2 = new Task6();
        ListNode result2 = doubler2.doubleLinkedListNumber(head2);
        System.out.print("Output: ");
        printList(result2);
    }
}
