package org.example.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 单链表
 */
public class LinkedListLoopDemo {

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

        // 闭环
        fiveNode.setNext(secondNode);

        boolean isLoop = hasLoopV1(sentry.getNext());
        System.out.println(isLoop);
        boolean hasLoopV2 = hasLoopV2(sentry.getNext());
        System.out.println(hasLoopV2);
    }

    public static boolean hasLoopV1(Node<Integer> node) {
        if (node == null) {
            return false;
        }
        // 慢指针
        Node<Integer> p = node.getNext();
        // 快指针
        Node<Integer> q = node.getNext();

        while (q != null && q.getNext() != null) {
            p = p.getNext();
            q = q.getNext().getNext();

            if (p == null) {
                return false;
            } else if (p == q) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLoopV2(Node<Integer> node) {
        Node<Integer> p = node;
        List<Integer> tempList = new ArrayList<>();
        while (p != null) {
            if (tempList.contains(p.getValue())) {
                return true;
            }
            tempList.add(p.getValue());
            p = p.getNext();
        }
        return false;
    }
}
