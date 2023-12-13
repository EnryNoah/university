package org.main.logsystem.linkedlist;

public class Task4 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // Break the original list into two halves

        // Merge the two halves
        mergeLists(head, secondHalf);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private void mergeLists(ListNode first, ListNode second) {
        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    // Helper function to print the linked list for testing
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
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        System.out.println("Example 1:");
        System.out.print("Input: ");
        printList(head1);
        Task4 reorderList1 = new Task4();
        reorderList1.reorderList(head1);
        System.out.print("Output: ");
        printList(head1);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printList(head2);
        Task4 reorderList2 = new Task4();
        reorderList2.reorderList(head2);
        System.out.print("Output: ");
        printList(head2);
    }
}
