/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TentaUppg;

/**
 *
 * Get Node Get (index) size metod alla dessa rekursivt
 */
public class SingleLinkedList<E> {

    private static class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;

    public SingleLinkedList() {
        head = null;
    }

    private void addFirst(E item) {
        head = new Node<E>(item, head);
    }

    private void addAfter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node.next != null; i++) {
            node = node.next;
        }
        return node;
    }

    public E get(int index) {
        Node<E> node = getNode(index);
        if (node != null) {
            return node.data;
        }
        return null;
    }

    public void add(int index, E item) {
        if (index <= 0 || head == null) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    private int size(Node<E> node) {
        if (node != null) {
            return 1 + size(node.next);
        }
        return 0;
    }

    public int size() {
        return size(head);
    }

    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(4, "Strang " + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Storlek rekursivt: " + list.size());

    }
}