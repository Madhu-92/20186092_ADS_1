import java.util.Scanner;
class MedianFinding {
    
    private MinPQ<Double> minObj;
    private MaxPQ<Double> maxObj;
    
    MedianFinding() {
        minObj = new MinPQ<Double>();
        maxObj = new MaxPQ<Double>();
    }
    
    public void minInsert(final Double item) {
        minObj.insert(item);
    }
    
    public void maxInsert(final Double item) {
        maxObj.insert(item);
    }
    
    public Double getMin() {
        return minObj.min();
    }
    
    public Double getMax() {
        return maxObj.max();
    }
    
    public Double delMin() {
        return minObj.delMin();
    }
    
    public Double delMax() {
        return maxObj.delMax();
    }
    
    public int getMaxSize() {
        return maxObj.size();
    }

    public int getMinSize() {
        return minObj.size();
    }
}

final class Solution {
    private Solution() {
        //Blank constructor.
    }
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