package com.company;
//Description: adding, reversing, checking, and deleting nodes in linked list

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;

        public Node (int value) {
            this.value = value;
        }
    }

    public static void print(LinkedList list) {
        Node node = list.head;
        System.out.print("Linked list: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void addLast (int value) {
        Node node = new Node(value);
        if (head == null) {         //if the first node is empty, then that means the list is empty
            head = tail = node;     //first node = last node = the node being added
        }
        else {
            tail.next = node;       //if the first node isnt empty, then add the node next to the tail
            tail = node;            //the node being added became the current tail
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {         //if the first node is empty, then that means the list is empty
            head = tail = node;     //first node = last node = the node being added
        }
        else {
            node.next = head;       //if the first node isnt empty, then move the head down the list
            head = node;            //the node being added became the current head
        }
    }
    public int indexOf(int value) {
        Node current = head;
        int length = length();
        for (int i = 0; i < length; i++) {
            if (current.value == value) {   //if the value matches, return i
                return i;
            }
            current = current.next;         //if the value doesnt matches, continue
        }
        return -1;                          //if there is no node value in the list
    }

    public void check() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            return;
        }
    }

    public void deleteFirst() {
        check();
        Node current = head.next;       //set the second node in the list to be the current node
        head.next = null;               //since the current node is currently the node after head, you can delete the current head.next
        head = current;                 //set the head to be the current node
    }

    public void deleteLast() {
        check();
        if (head != tail) {
            Node current = head;
            while (current.next != tail) {      //as long as the tail isnt the next node
                current = current.next;         //travel down the list
            }                                   //the while loop ends once current.next node reaches the tail
            tail = current;                     //set the current node to be the tail, moving it up by 1
            tail.next = null;                   //null the node next to it
        }
        else {
            tail = head = null;
        }
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if(value == current.value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int length() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void reverse() {
        Node node = head;
        Node previous = null;
        Node current = null;
        Node last = head;

        while (node != null) {
            current = node;
            node = node.next;

            current.next = previous;
            previous = current;
            head = current;
        }
        tail = last;            //make the head equals the tail
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(2);
        list.addLast(4);
        list.addLast(8);
        list.addFirst(-2);
        list.addFirst(-8);
        list.addLast(9);
        print(list);
        System.out.println();
        System.out.println("The index of 4 is: " + list.indexOf(4));
        System.out.println("This list contains 9: " + list.contains(9));
        System.out.println();

        int length = list.length();

        list.reverse();
        System.out.println("After reversing: ");
        print(list);
        System.out.println();

        System.out.println("After deletion:");
        for (int i = 0; i < length; i++) {
            list.deleteFirst();
            print(list);
        }
    }
}
