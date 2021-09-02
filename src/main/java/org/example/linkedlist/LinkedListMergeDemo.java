package org.example.linkedlist;

public class LinkedListMergeDemo {
    public static void main(String[] args) {

        // mergeTwoList();
    }

    public static Node<Integer> mergeTwoList(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(), p = dummy;

        while (l1 != null && l2 != null) {
            if (l1.getValue() < l2.getValue()) {
                p.setNext(l1);
                l1 = l1.getNext();
            } else {
                p.setNext(l2);
                l2 = l2.getNext();
            }
            p = p.getNext();
        }

        if (l1 != null) {
            p.setNext(l1);
        }
        if (l2 != null) {
            p.setNext(l2);
        }
        return dummy.getNext();
    }
}
