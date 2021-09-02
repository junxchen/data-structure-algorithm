package org.example.linkedlist;

/**
 * 单链表
 */
public class LinkedListInversion {

    public static void main(String[] args) {
        // 哨兵节点
        Node<Integer> sentry = new Node<>();
        sentry.setValue(null);

        Node<Integer> firstNode = new Node<>();
        firstNode.setValue(1);
        sentry.setNext(firstNode);


        Node<Integer> secondNode = new Node<>();
        secondNode.setValue(2);
        firstNode.setNext(secondNode);

        Node<Integer> threeNode = new Node<>();
        threeNode.setValue(3);
        secondNode.setNext(threeNode);

        Node<Integer> fourNode = new Node<>();
        fourNode.setValue(4);
        threeNode.setNext(fourNode);

        Node<Integer> fiveNode = new Node<>();
        fiveNode.setValue(5);
        fourNode.setNext(fiveNode);

        // 链表反转
        Node<Integer> reverseList1 = reverseList1(sentry.getNext());
        System.out.println(reverseList1);
        Node<Integer> reverseList2 = reverseList2(reverseList1);
        System.out.println(reverseList2);
    }

    public static <T> Node reverseList1(Node<T> head) {
        if (head == null) {
            return null;
        }
        Node<T> dummy = new Node<>();
        dummy.setValue(null);

        dummy.setNext(head);

        Node<T> prev = dummy.getNext();
        Node<T> pCur = prev.getNext();
        while (pCur != null) {
            prev.setNext(pCur.getNext());
            pCur.setNext(dummy.getNext());
            dummy.setNext(pCur);
            pCur = prev.getNext();
        }
        return dummy.getNext();
    }

    public static <T> Node reverseList2(Node<T> head) {
        if (head == null) {
            return null;
        }
        Node<T> dummy = new Node<>();
        dummy.setValue(null);

        Node<T> pCur = head;
        while (pCur != null) {
            Node<T> pNext = pCur.getNext();
            pCur.setNext(dummy.getNext());
            dummy.setNext(pCur);
            pCur = pNext;
        }
        return dummy.getNext();
    }
}
