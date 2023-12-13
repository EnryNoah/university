package org.main.logsystem.linkedlist;

public class Task5 {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
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
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(9);

        ListNode node1 = head1.next;

        System.out.println("Example 1:");
        System.out.print("Input: ");
        printList(head1);
        Task5 deleteNode1 = new Task5();
        deleteNode1.deleteNode(node1);
        System.out.print("Output: ");
        printList(head1);

        // Example 2
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(9);

        ListNode node2 = head2.next.next;

        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printList(head2);
        Task5 deleteNode2 = new Task5();
        deleteNode2.deleteNode(node2);
        System.out.print("Output: ");
        printList(head2);
    }
}
