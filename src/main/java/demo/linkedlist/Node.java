package demo.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private String value;

    private Node next;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }

}
