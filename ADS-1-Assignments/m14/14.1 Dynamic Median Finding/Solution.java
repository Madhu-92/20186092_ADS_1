import java.util.Scanner;
/**
 * Class for median finding.
 */
class MedianFinding {
    /**
     * creating an object for MinPQ class.
     */
    private MinPQ<Double> minObj;
    /**
     * creating an object for MaxPQ class.
     */
    private MaxPQ<Double> maxObj;
    /**
     * Constructs the object.
     */
    MedianFinding() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    /**
     * this method inserts element into minheap.
     *
     * @param      item  The item
     */
    public void minInsert(final Double item) {
        minObj.insert(item);
    }
    /**
     * this method inserts element into maxheap.
     *
     * @param      item  The item
     */
    public void maxInsert(final Double item) {
        maxObj.insert(item);
    }
    /**
     * Gets the minimum element from minheap.
     *
     * @return     The minimum element from minheap.
     */
    public Double getMin() {
        return minObj.min();
    }
    /**
     * Gets the maximum element from maxheap.
     *
     * @return     The maximum element from maxheap.
     */
    public Double getMax() {
        return maxObj.max();
    }
    /**
     * this method deletes the min element from minheap
     *
     * @return     returns the deleted element from minheap
     */
    public Double delMin() {
        return minObj.delMin();
    }
    /**
     * this method deletes the max element from maxheap
     *
     * @return     returns the deleted element from maxheap
     */
    public Double delMax() {
        return maxObj.delMax();
    }
    /**
     * Gets the size of maxheap.
     *
     * @return     the size of maxheap.
     */
    public int getMaxSize() {
        return maxObj.size();
    }
    /**
     * the size of minheap
     *
     * @return     the size of minheap.
     */
    public int getMinSize() {
        return minObj.size();
    }
}
/**
 * solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Blank constructor.
    }
    /**
     * main method is used to perform the operations
     * Time complexity for this method is O(N).
     * N is the number of inputs.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        MedianFinding medianObj = new MedianFinding();
        int lines = Integer.parseInt(sc.nextLine());
        Double value = Double.parseDouble(sc.nextLine());
        Double median = value;
        medianObj.minInsert(value);
        System.out.println(median);
        for (int i = 1; i < lines; i++) {
            value = Double.parseDouble(sc.nextLine());
            if (value >= median) {
                medianObj.minInsert(value);
            } else {
                medianObj.maxInsert(value);
            }
            if (medianObj.getMinSize() - medianObj.getMaxSize() > 1) {
                medianObj.maxInsert(medianObj.delMin());
            }
            if (medianObj.getMaxSize() - medianObj.getMinSize() > 1) {
                medianObj.minInsert(medianObj.delMax());
            }
            if (Math.abs(medianObj.getMaxSize() - medianObj.getMinSize()) == 1) {
                if (medianObj.getMinSize() > medianObj.getMaxSize()) {
                    median = medianObj.getMin();
                    System.out.println(median);
                } else {
                    median = medianObj.getMax();
                    System.out.println(median);
                }
            }
            if (medianObj.getMinSize() == medianObj.getMaxSize()) {
                median = (medianObj.getMin() + medianObj.getMax()) / 2.0;
                System.out.println(median);
            }
        }
    }
}