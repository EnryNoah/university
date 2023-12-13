package org.main.logsystem.linkedlist;

import java.util.PriorityQueue;

public class Task7 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;

            if (node.next != null) {
                minHeap.offer(node.next);
            }
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
        ListNode[] lists1 = new ListNode[3];
        lists1[0] = new ListNode(1);
        lists1[0].next = new ListNode(4);
        lists1[0].next.next = new ListNode(5);

        lists1[1] = new ListNode(1);
        lists1[1].next = new ListNode(3);
        lists1[1].next.next = new ListNode(4);

        lists1[2] = new ListNode(2);
        lists1[2].next = new ListNode(6);

        System.out.println("Example 1:");
        System.out.print("Input: ");
        for (ListNode list : lists1) {
            printList(list);
        }

        Task7 merger1 = new Task7();
        ListNode result1 = merger1.mergeKLists(lists1);
        System.out.print("Output: ");
        printList(result1);

        // Example 2
        ListNode[] lists2 = new ListNode[0];
        System.out.println("\nExample 2:");
        System.out.print("Input: ");
        for (ListNode list : lists2) {
            printList(list);
        }

        Task7 merger2 = new Task7();
        ListNode result2 = merger2.mergeKLists(lists2);
        System.out.print("Output: ");
        printList(result2);

        // Example 3
        ListNode[] lists3 = new ListNode[1];
        lists3[0] = new ListNode(0);

        System.out.println("\nExample 3:");
        System.out.print("Input: ");
        for (ListNode list : lists3) {
            printList(list);
        }

        Task7 merger3 = new Task7();
        ListNode result3 = merger3.mergeKLists(lists3);
        System.out.print("Output: ");
        printList(result3);
    }
}
