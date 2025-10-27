package org.javacourse;

import java.util.Iterator;
import java.util.Objects;

public class CustomLinkedList<Element> implements Iterable<Element> {


    private Node<Element> head;
    private Node<Element> tail;

    private int size;

    private static class Node<Element> {
        Element data;
        Node<Element> next;
        Node<Element> prev;

        public Node(Element data, Node<Element> next, Node<Element> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<Element> iterator() {
        return new Iterator<>() {
            private Node<Element> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Element next() {
                Node<Element> temp = current;
                current = current.next;
                return temp.data;
            }
        };
    }

    public void add(Element element) {
        Node<Element> node;
        if (head == null) {
            node = new Node<>(element, null, null);
            head = node;
        } else {
            node = new Node<>(element, null, tail);
            tail.next = node;
        }
        size++;
        tail = node;
    }

    public void addFirst(Element element) {
        Node<Element> newFirst = new Node<>(element, head, null);
        Node<Element> oldFirst = head;
        oldFirst.prev = newFirst;
        head = newFirst;
        size++;
    }

    public void remove(int index) {
        Node<Element> deleteNode = getNode(index);
        Node<Element> elementBefore = Objects.requireNonNull(deleteNode).prev;
        Node<Element> elementAfter = deleteNode.next;
        elementBefore.next = elementAfter;
        elementAfter.prev = elementBefore;
        size--;
    }

    public Element get(int index) {
        return Objects.requireNonNull(getNode(index)).data;
    }

    public int getLength() {
        return size;
    }

    public Element getFirst() {
        if (head == null) {
            return null;
        } else {
            return head.data;
        }
    }

    public Element getLast() {
        if (tail == null) {
            return null;
        } else {
            return tail.data;
        }
    }

    private Node<Element> getNode(int index) {
        Node<Element> result = head;
        if (index > size) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

}
