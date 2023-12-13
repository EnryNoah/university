package org.main.logsystem.linkedlist;

public class Task2 {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
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
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        System.out.println("Example 1:");
        System.out.print("Input: ");
        printList(head1);
        Task2 remover1 = new Task2();
        ListNode result1 = remover1.removeDuplicates(head1);
        System.out.print("Output: ");
        printList(result1);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);
        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printList(head2);
        Task2 remover2 = new Task2();
        ListNode result2 = remover2.removeDuplicates(head2);
        System.out.print("Output: ");
        printList(result2);
    }
}
