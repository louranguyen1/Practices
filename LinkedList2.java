package com.company;
//Description: remove duplicates in a linked list

public class LinkedList2 {
    private Node head;
    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public void removeDuplicates() {
        Node current = head;
        Node previous = null;
        Node next = null;

        if (head == null) {
            System.out.println("Linked list is empty");
        }
        else {
            while (current != null) {                   //declare the values for each Node
                previous = current;
                next = current.next;
                while (next != null) {                  //if next is null then it's the end of linked list
                    if (current.value == next.value) {  //check for duplicates
                        previous.next = next.next;      //skip it by pointing to the next node
                    }
                    else {
                        previous = next;                //point to next node if the values arent the same
                    }
                    next = next.next;                   //go to the next node
                }
                current = current.next;
            }
        }
    }
    @Override
    public String toString() {
        Node current = head;
        StringBuffer toPrint = new StringBuffer();
        toPrint.append("[");
        while (current != null) {
            if (current.next != null) {
                toPrint.append(current.value + ", ");
            } else {
                toPrint.append(current.value);
            }
            current = current.next;
        }
        toPrint.append("]");
        return toPrint.toString();
    }
    public void addFirst(int value) {
        Node node = new Node(value);
        if (head == null) {         //if the first node is empty, then that means the list is empty
            head = node;
        }
        else {
            node.next = head;       //if the first node isnt empty, then move the head down the list
            head = node;            //the node being added became the current head
        }
    }

    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();

        list.addFirst(1);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        System.out.println(list);
        list.removeDuplicates();
        System.out.println(list);
    }
}

