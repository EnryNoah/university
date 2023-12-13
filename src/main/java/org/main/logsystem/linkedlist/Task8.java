package org.main.logsystem.linkedlist;

public class Task8 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int count = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        ListNode nextGroupStart = dummy;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        while (count >= k) {
            current = nextGroupStart.next;
            for (int i = 1; i < k; i++) {
                ListNode temp = current.next;
                current.next = temp.next;
                temp.next = nextGroupStart.next;
                nextGroupStart.next = temp;
            }
            nextGroupStart = current;
            count -= k;
        }

        return dummy.next;
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
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println("Example 1:");
        System.out.print("Input: ");
        printList(head1);

        Task8 reverser1 = new Task8();
        ListNode result1 = reverser1.reverseKGroup(head1, 2);

        System.out.print("Output: ");
        printList(result1);

        // Example 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        printList(head2);

        Task8 reverser2 = new Task8();
        ListNode result2 = reverser2.reverseKGroup(head2, 3);

        System.out.print("Output: ");
        printList(result2);
    }
}
