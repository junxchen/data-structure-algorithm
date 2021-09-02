package org.example.linkedlist;

public class LinkedListDeleteCountDownDemo {
    public static void main(String[] args) {
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

        Node<Integer> node = deleteCountDownList1(sentry.getNext(), 3);
        System.out.println(node);
    }

    public static Node<Integer> deleteCountDownList1(Node<Integer> node, int n) {
        // 快指针到n，当快指针结束的时候，慢指针到的地方就是要删掉的节点
        if (node == null) {
            return null;
        }

        Node<Integer> tempNode = new Node<>();
        tempNode.setNext(node);
        Node<Integer> fast = node;

        Node<Integer> lazy = tempNode;
        int i = 1;
        while (i < n) {
            if (fast == null) {
                return node;
            }
            fast = fast.getNext();
            i++;
        }

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            lazy = lazy.getNext();
        }
        lazy.setNext(lazy.getNext().getNext());
        return tempNode.getNext();
    }
}
