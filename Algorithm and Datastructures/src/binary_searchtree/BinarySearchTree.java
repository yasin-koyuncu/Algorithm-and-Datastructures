/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_searchtree;

import java.time.Clock;

/**
 *
 * @author yasin93
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private static class Node<E> {

        private E data;
        private Node<E> left, right;

        private Node(E d) {
            data = d;
            left = right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
    private Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(": " + node.toString());
            inOrder(node.right, sb);
        }
    }

    public void preOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            sb.append(":" + node.toString());
            preOrder(node.left, sb);
            preOrder(node.right, sb);
        }
    }

    public void postOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            postOrder(node.left, sb);
            postOrder(node.right, sb);
            sb.append(":" + node.toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        } else if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            } else {
                return add(data, node.left);
            }
        } else if (node.right == null) {
            node.right = new Node<E>(data);
            return true;
        } else {
            return add(data, node.right);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        } else {
            return add(data, root);
        }
    }

    private E find(E target, Node<E> node) {
        if (node == null) {
            return null;
        }
        if (target.compareTo(node.data) == 0) {
            return node.data;
        }
        if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }
        return find(target, node.right);
    }

    public E find(E target) {
        return find(target, root);
    }

    public E findIter(E target) {
        Node<E> node = root;

        while (node != null) {
            if (target.compareTo(node.data) == 0) {
                return node.data;
            } else if (target.compareTo(node.data) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
    private E deletedData;

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node) {
        if (node == null) {//target finns ej i trädet 
            deletedData = null;
            return null;
        } else if (target.compareTo(node.data) < 0) {//target finns i vänstra trädet
            node.left = delete(target, node.left); //om det finns
            return node;
        } else if (target.compareTo(node.data) > 0) {//target i högra trädet
            node.right = delete(target, node.right);
            return node;
        } else {//target finns i node
            deletedData = node.data; //lagrar data att returnera
//nu ska vi bygga om trädet
            if (node.left == null) //noden som ska bort saknar vänster träd
            {
                return node.right;
            } else if (node.right
                    == null)//noden som ska bort saknar högerträd
            {
                return node.left;
            } else {
                Node<E> nodeToMove = node.right, parentNodeToMove = node;
                if (nodeToMove.left == null) {//högra barnet har inget vänsterbarn
                    nodeToMove.left = node.left;
                    return nodeToMove;
                }
                while (nodeToMove.left != null) {
                    parentNodeToMove = nodeToMove;
                    nodeToMove = nodeToMove.left;
                }

                parentNodeToMove.left = nodeToMove.right;
                node.data = nodeToMove.data;
                return node;
            }
        }
    }

    public int numberOfNodes() {
        return numberOfNodes(root);
    }

    private int numberOfNodes(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + numberOfNodes(node.left) + numberOfNodes(node.right);

    }

    private int countLeaves(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaves(node.left) + countLeaves(node.right);
        }

    }

    public int countLeaves() {
        return countLeaves(root);
    }

    public E findMaxIter() {
        Node<E> max = root;
        if (max != null) {
            while (max.right != null) {
                max = max.right;
            }
        }
        return max.data;
    }

    public E findMaxRec() {
        return findMaxRec(root);
    }

    private E findMaxRec(Node<E> max) {
        if (max.right == null) {
            return max.data;
        } else {
            return findMaxRec(max.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        bst.add(40);
        bst.add(20);
        bst.add(60);
        bst.add(10);
        bst.add(30);
        bst.add(50);
        bst.add(70);
        System.out.println(bst.toString());

        System.out.printf("\n\n Antal noder:%d\n Antal Löv: %d \n", bst.numberOfNodes(), bst.countLeaves());

        System.out.println(bst.findIter(50));

        System.out.println("Max värde iterativt: " + bst.findMaxIter());

        System.out.println("Max värde rekursivt: " + bst.findMaxRec());
       
                
    }
}
