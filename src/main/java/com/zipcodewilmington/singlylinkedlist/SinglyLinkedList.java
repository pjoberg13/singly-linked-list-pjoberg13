package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Number>{

    public Node<T> head = null;
    public Node<T> tail = null;

    //addNode() will add a new node to the list
    public void addNode(T data) {
        //Create a new node
        Node<T> newNode = new Node<T>(data);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }

    //removeNode() will remove a node element from the list
    public void removeNode(int nodeIndex) {
        Node<T> current = head;
        int counter = 0;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        if(nodeIndex == 0) {
            head = head.next;
        }
        while(current != null) {
            if(counter == nodeIndex - 1) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    //insertAtStart() will add a new element at the head of the list
    public void insertAtStart(T data) {
        Node<T> newNode = new Node<T>(data);

        newNode.next = head;
        head = newNode;
    }

    public boolean contains(T data) {
        Node<T> current = head;

        while(current != null) {
            if(current.data.equals(data)) {
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public Integer findIndexOf(T data) {
        if(!contains(data)) {
            return -1;
        }

        Node<T> current = head;
        int counter = 0;

        while(current != null) {
            if(current.data.equals(data)) {
                return counter;
            } else {
                current = current.next;
                counter++;
            }
        }
        return -1;
    }

    public T get(int index) {
        Node<T> current = head;
        int counter = 0;

        while(current != null) {
            if(counter == index) {
                return current.data;
            }
            current = current.next;
            counter++;
        }
        return null;
    }

    public Node<T> getNode(int index) {
        Node<T> current = head;
        int counter = 0;

        while(current != null) {
            if(counter == index) {
                return current;
            }
            current = current.next;
            counter++;
        }
        return null;
    }

    public Integer getSize() {
        Node<T> current = head;
        int sizeCounter = 0;

        if(head == null) {
            System.out.println("List is empty");
            return -1;
        }

        while(current != null) {
            current = current.next;
            sizeCounter++;
        }
        return sizeCounter;
    }

    public SinglyLinkedList<T> copyList() {
        SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        Node<T> current = head;

        while(current != null) {
            newList.addNode(current.data);
            current = current.next;
        }
        return newList;
    }

    public void reverseList() {
        //SinglyLinkedList<T> newList = new SinglyLinkedList<T>();
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public SinglyLinkedList<T> subList(int startIndex, int endIndex) {
        SinglyLinkedList<T> subList = new SinglyLinkedList<T>();
        Node<T> current = getNode(startIndex);
        //int indexCounter = startIndex;

        while(current != getNode(endIndex)) {
            subList.addNode(current.data);
            current = current.next;
        }
        return subList;
    }

    //display() will display all the nodes present in the list
    public void display() {
        //Node current will point to head
        Node<T> current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static class Node<T> {

        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
