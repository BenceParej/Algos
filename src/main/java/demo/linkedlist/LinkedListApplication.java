package demo.linkedlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkedListApplication {

    public static void main(String[] args) {

        Node aNode = new Node("A");
        Node bNode = new Node("B");
        Node cNode = new Node("C");
        Node dNode = new Node("D");
        Node eNode = new Node("E");
        Node fNode = new Node("F");


        Node XNode = new Node("X");
        Node YNode = new Node("Y");
        Node ZNode = new Node("Z");

        aNode.setNext(bNode);
        bNode.setNext(cNode);
        cNode.setNext(dNode);
        dNode.setNext(eNode);
        eNode.setNext(fNode);

        XNode.setNext(YNode);
        YNode.setNext(ZNode);

        //linkedListTraversal(aNode);

        //linkedListTraversalRecursive(aNode);

        //reverseLinkedList(aNode);

        //zipLinkedLists(aNode, XNode);

        printMiddleElement(XNode);
    }

    public static void linkedListTraversal(Node head) {
        Node current = head;

        while (current != null) {
            System.out.println(current.getValue());

            current = current.getNext();
        }
    }

    public static void linkedListTraversalRecursive(Node head) {
        Node current = head;
        recursiveTraversal(current);
    }

    private static void recursiveTraversal(Node current) {
        if (current == null) {
            return;
        }
        System.out.println(current.getValue());
        recursiveTraversal(current.getNext());
    }

    public static void reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        linkedListTraversal(prev);
    }


    public static void zipLinkedLists(Node list1, Node list2) {
        if (list1 == null) {
            linkedListTraversal(list2);
            return;
        }
        if (list2 == null) {
            linkedListTraversal(list1);
            return;
        }

        Node current1 = list1;
        Node current2 = list2;
        Node head = new Node("AAAA"); // Dummy node to simplify zipping
        Node tail = head;
        int index = 0;

        while (current1 != null && current2 != null) {
            if (index % 2 == 0) {
                tail.setNext(current1);
                current1 = current1.getNext();
            } else {
                tail.setNext(current2);
                current2 = current2.getNext();
            }
            tail = tail.getNext();
            index++;
        }

        if (current1 != null) {
            tail.setNext(current1);
        }

        if (current2 != null) {
            tail.setNext(current2);
        }

        linkedListTraversal(head.getNext());

    }


    public static void printMiddleElement(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.getNext() != null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        System.out.println(slowPointer.getValue());
    }

}
