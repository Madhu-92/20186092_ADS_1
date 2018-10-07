import java.util.Scanner;
class LinkedList {
  private class Node {
    private int value;
    private Node next;
    Node() {

    }
    Node(final int data) {
      this.value = data;
      this.next = next;
    }
  }
  private Node head;
  private Node tail;
  private int size;
  LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  public void insertAt(final int index, final int value) throws Exception {

    if (index < 0 || index > size) {
      throw new Exception("Can't insert at this position.");
    }
    head = insertAt(head, new Node(value), index, 0);
    size++;
  }
  private Node insertAt(final Node curr,
                        final Node newNode,
                        final int index, final int currIndex) {
    if (curr == null) {
      return newNode;
    } else if (currIndex == index) {
      newNode.next = curr;
      return newNode;
    }

    curr.next = insertAt(curr.next, newNode, index, currIndex + 1);
    return curr;

  }
  public void reverse() throws Exception {
    if (size == 0) {
      throw new Exception("No elements to reverse.");
    }
    reverse(head, null);

  }
  private Node reverse(final Node curr, final Node prev) {



    if (curr.next == null) {
      head = curr;
      head.next = prev;
      return null;
    }

    Node temp = curr.next;
    curr.next = prev;

    reverse(temp, curr);
    return head;
  }
  public void display() {
    Node curr = head;
    String result = "";
    while (curr != null) {
      if (curr.next == null) {
        result += curr.value;
      } else {
        result += curr.value + ", ";
      }
      curr = curr.next;
    }

    System.out.println(result);
  }
}
public final class Solution {
  private Solution() {

  }
  public static void main(final String[] args) {
    LinkedList object = new LinkedList();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
      String[] tokens = sc.nextLine().split(" ");
      try {
        switch (tokens[0]) {

        case "insertAt" :
          object.insertAt(Integer.parseInt(tokens[1]),
                          Integer.parseInt(tokens[2]));
          object.display();
          break;
        case "reverse":
          object.reverse();
          object.display();
          break;
        default:
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());

      }

    }
  }
}