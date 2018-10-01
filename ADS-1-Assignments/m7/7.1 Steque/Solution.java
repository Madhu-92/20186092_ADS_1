import java.util.Scanner;

public final class Solution {
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
