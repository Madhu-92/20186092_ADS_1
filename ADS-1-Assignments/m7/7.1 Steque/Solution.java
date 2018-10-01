import java.util.Scanner;

public class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        Steque obj = new Steque();
        int cases = Integer.parseInt(s.nextLine());
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] tokens = line.split(" ");
            if (line.length() == 0) {
                obj.setSize(0);
                System.out.println();
            } else {
                switch (tokens[0]) {
                case "push":
                    obj.push(Integer.parseInt(tokens[1]));
                    obj.print();
                    break;
                case "enqueue":
                    obj.enqueue(Integer.parseInt(tokens[1]));
                    obj.print();
                    break;
                case "pop":
                    obj.pop();
                    obj.print();
                    break;
                default:
                }
            }
        }

    }
}

class Node {
    int data;
    Node nextAddress;
    Node(final int data) {
        this.data = data;
    }
    Node() {

    }
    public int getData() {
        return data;
    }
    public Node getnextAddress() {
        return nextAddress;
    }
    public void setnextAddress(Node nextAddress1) {
        this.nextAddress = nextAddress1;
    }
}

class Steque {
    int size = 0;
    Node head;
    Node tail;
    public void push(final int item) {
        if (size == 0) {
            head = new Node(item);
            head.nextAddress = null;
            tail = head;
            size++;
            return;
        }
        Node temp = new Node(item);
        temp.nextAddress = head;
        head = temp;
        size++;
    }
    public void enqueue(final int item) {
        if (size == 0) {
            head = new Node(item);
            tail = head;
            head.nextAddress = null;
            size++;
            return;
        }
        Node temp = new Node(item);
        temp.nextAddress = null;
        tail.nextAddress = temp;
        tail = temp;
        size++;
    }
    public void pop() {
        if (head == null) return;
        if (size == 1) {
            head = null;
            size = 0;
            return;
        }
        head = head.nextAddress;
        size--;
    }
    public void setSize(int value) {
        this.size = value;
    }
    public void print() {
        Node obj = head;
        if (head == null) {
            System.out.println("Steque is empty.");
            return;
        }
        while (obj.getnextAddress() != null) {
            System.out.print(obj.data + ", ");
            obj = obj.getnextAddress();
        } System.out.print(obj.data);
        System.out.println();
    }
}