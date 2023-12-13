package org.main.logsystem.linkedlist;

public class Task3 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;

        System.out.println("Example 1:");
        Task3 cycleChecker1 = new Task3();
        boolean result1 = cycleChecker1.hasCycle(head1);
        System.out.println("Output: " + result1);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;

        System.out.println("\nExample 2:");
        Task3 cycleChecker2 = new Task3();
        boolean result2 = cycleChecker2.hasCycle(head2);
        System.out.println("Output: " + result2);

        // Example 3
        ListNode head3 = new ListNode(1);
        System.out.println("\nExample 3:");
        Task3 cycleChecker3 = new Task3();
        boolean result3 = cycleChecker3.hasCycle(head3);
        System.out.println("Output: " + result3);
    }
}
