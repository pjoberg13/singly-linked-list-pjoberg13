package com.zipcodewilmington.singlylinkedlist;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void testListCreation() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);

        myList.display();
    }

    @Test
    public void testInsertAtStart() {
        SinglyLinkedList<Number> myList = new SinglyLinkedList<Number>();
        myList.addNode(2);
        myList.addNode(3f);
        myList.addNode(5);
        myList.addNode(7d);

        myList.insertAtStart(1);

        myList.display();
    }

    @Test
    public void testContains() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        Assert.assertTrue(myList.contains(7));
        Assert.assertFalse(myList.contains(21));
    }

    @Test
    public void testFindIndexOf() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        int expected = 1;
        int actual = myList.findIndexOf(3);
        assertEquals(expected, actual);

        int expectedFalse = -1;
        int actualFalse = myList.findIndexOf(500);
        assertEquals(expectedFalse, actualFalse);
    }

    @Test
    public void testGetSize1() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        int expected = 4;
        int actual = myList.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSize2() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();
        for(int i = 0; i < 100; i++) {
            myList.addNode(i);
        }

        int expected = 100;
        int actual = myList.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        int expected = 3;
        int actual = myList.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testGet2() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        int expected = 7;
        int actual = myList.get(3);
        assertEquals(expected, actual);

        int expectedFalse = 5;
        int actualFalse = myList.get(2);
        assertEquals(expectedFalse, actualFalse);
    }

    @Test
    public void testCopy() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        SinglyLinkedList<Integer> myNewList = myList.copyList();
        int expected = myList.getSize();
        int actual = myNewList.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testCopy1() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);

        SinglyLinkedList<Integer> myNewList = myList.copyList();
        int expected = myList.get(2);
        int actual = myNewList.get(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testNodeRemoval() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);
        assertEquals(4, (int) myList.getSize());

        myList.removeNode(1);

        int expected = 3;
        int actual = myList.getSize();
        assertEquals(expected, actual);
    }

    @Test
    public void testListReversal() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);
        myList.reverseList();

        int expected = 5;
        int actual = myList.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubList() {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<Integer>();

        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(5);
        myList.addNode(7);
        myList.addNode(11);
        myList.addNode(13);
        myList.addNode(17);

        SinglyLinkedList<Integer> subList = myList.subList(2, 6);

        int expected = 5;
        int actual = subList.get(0);
        int expected1 = 11;
        int actual1 = subList.get(2);
        assertEquals(expected, actual);
        assertEquals(expected1, actual1);
    }
}
