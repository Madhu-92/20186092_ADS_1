import java.util.Scanner;
import java.util.LinkedList;
import java.util.*;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    AddLargeNumbers() {
        /**
         * Empty
         */
    }
    /**
     * number to digits method.
     *
     * @param      number  The number
     *
     * @return     returns the object
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList<Integer> obj = new LinkedList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            obj.addLast(Character.getNumericValue(number.charAt(i)));
        }
        return obj;
    }

    /**
     * digitTonumber method.
     *
     * @param      list  The list
     *
     * @return     returns a string
     */
    public static String digitsToNumber(final LinkedList list) {
        String str = "";
        Iterator iterator = list.listIterator();
        while (iterator.hasNext()) {
            str += iterator.next();
        }
        return str;
    }

    /**
     * Adds large numbers.
     *
     * @param      l1    The l 1
     * @param      l2    The l 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(
                 final LinkedList l1, final LinkedList l2) {
        return null;
    }
}

/**
 * Class for solution.
 */
public class Solution {
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            default:
            break;

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.
            //                   addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
            
        }
    }

}
