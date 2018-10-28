import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //blank constructor.
    }
    /**
     * main method to perform operations.
     * Time complexity of this method
     * O(M(logN*+logN*+logN*))
     * M is the number of inputs
     * 1st logN* is for put method
     * 2nd logN* is for get method
     * 3rd logN* is for delete method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        LinearProbingHashST<String, Integer> lpobj
         = new LinearProbingHashST<>();
        for (int i = 0; i <= num; i++) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
                case "put": lpobj.put(tokens[1], Integer.parseInt(tokens[2]));
                break;
                case "display":
                    if (lpobj.size() == 0) {
                    System.out.println("{}");
                } else {
                    String str = "";
                    for (String str1: lpobj.keys()) {
                        str += str1 + ":" + lpobj.get(str1) + ", ";
                    }
                    System.out.println("{" + str.substring(
                        0, str.length() - 2) + "}");
                }
                break;
                case "delete":
                lpobj.delete(tokens[1]);
                break;
                case "get":
                System.out.println(lpobj.get(tokens[1]));
                break;
                default:
                break;
            }
        }
    }
}