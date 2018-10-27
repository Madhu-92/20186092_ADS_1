import java.util.Scanner;

final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        LinearProbingHashST<Integer, String> lpObj =
            new LinearProbingHashST<Integer, String>();
        Scanner sc = new Scanner(System.in);
        int inputs = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < inputs; i++) {
            String[] tokens = sc.nextLine().split(",");
            String str = tokens[1] + "," + tokens[2];
            lpObj.put(Integer.parseInt(tokens[0]), str);
        }
        int getValues = Integer.parseInt(sc.nextLine());
        for (int j = 0; j < getValues; j++) {
            String[] tokens = sc.nextLine().split(" ");
            String str = lpObj.get(Integer.parseInt(tokens[1]));
            if (str != null) {
                String[] tokens2 = str.split(",");
                if (Integer.parseInt(tokens[2]) == 1) {
                    System.out.println(tokens2[0]);
                } else {
                    System.out.println(Double.parseDouble(tokens2[1]));
                }
            } else {
                System.out.println("Student doesn't exists...");
            }
        }
    }

}