package org.example.linkedlist;

import lombok.Data;

@Data
public class Node<T> {
    private T value;

    private Node<T> next;
}
