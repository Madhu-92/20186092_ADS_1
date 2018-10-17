import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
/**
 * Class for students.
 */
class Students {
    /**
     * student info object array.
     */
    private StudentInfo[] info;
    /**
     * num variable.
     */
    private int num;
    /**
     * size variable.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      data  The data
     */
    Students(final int data) {
        num = data;
        info = new StudentInfo[num];
        size = 0;
    }
    /**
     * Time complexity is O(1)
     * add's the element at last position of array.
     *
     * @param      stud  The stud
     */
    public void add(final StudentInfo stud) {
        if (size == info.length) {
            resize();
        }
        info[size++] = stud;
    }
    /**
     * Resizes the array.
     */
    public void resize() {
        info = Arrays.copyOf(info, info.length * 2);
    }
    /**
     * Gets the information.
     *
     * @return     The information.
     */
    public StudentInfo[] getInfo() {
        return info;
    }
}

/**
 * Class for category criteria.
 */
class CategoryCriteria {
    /**
     * Constructs the object.
     */
    private CategoryCriteria() {
        //Blank constructor.
    }
    /**
     * Insertion class object.
     */
    private Insertion mergee = new Insertion();
    /**
     * No of students applied.
     */
    private int applied;
    /**
     * No of vacancies.
     */
    private int vacancies;
    /**
     * No of ur vacancies.
     */
    private int ur;
    /**
     * No of bc vacancies.
     */
    private int bc;
    /**
     * No of sc vacancies.
     */
    private int sc;
    /**
     * No of st vacancies.
     */
    private int st;
    /**
     * Size of the array.
     */
    private int asize;
    /**
     * Duplicated array for sorted objects.
     */
    private StudentInfo[] dupSorted;
    /**
     * Size of array.
     */
    private int size;
    /**
     * Array to store objects according to category.
     */
    private StudentInfo[] catSorted;
    /**
     * Constructs the object.
     *
     * @param      app     The application
     * @param      vac     The vac
     * @param      urev    The urev
     * @param      bv      BC vacancies
     * @param      sv      SC vacancies
     * @param      stv     The stv
     * @param      sorted  The sorted
     */
    CategoryCriteria(final int app, final int vac, final int urev,
                     final int bv, final int sv, final int stv,
                     final StudentInfo[] sorted) {
        applied = app;
        vacancies = vac;
        ur = urev;
        bc = bv;
        sc = sv;
        st = stv;
        dupSorted = sorted;
        asize = 0;
        size = sorted.length;
        catSorted = new StudentInfo[vacancies];

    }
    /**
     * Checks whether the Object contained in Array.
     * Time complexity is O(N)
     * it checks the element from start to array to end.
     *
     * @param      student  The student
     *
     * @return     returns true else false
     */
    private boolean contains(final StudentInfo student) {
        for (int i = 0; i < asize; i++) {
            if (catSorted[i].getName().equals(student.getName())) {
                return true;
            }
        }
        return false;
    }
    /**
     * Categorising According to Criteria.
     * Time complexity is O(N)
     * it will allot the seats in the resesrved category
     * using seat vacancies.
     */
    public void catCriteria() {
        for (int i = 0; i < ur; i++) {
            catSorted[asize++] = dupSorted[i];
        }

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (dupSorted[i].getCategory().equals("BC") && bc > 0) {
                    catSorted[asize++] = dupSorted[i];
                    bc--;
                } else if (dupSorted[i].getCategory().equals("SC")
                           && sc > 0) {
                    catSorted[asize++] = dupSorted[i];
                    sc--;
                } else if (dupSorted[i].getCategory().equals("ST")
                           && st > 0) {
                    catSorted[asize++] = dupSorted[i];
                    st--;
                }
            }
        }

        for (int i = 0; i < dupSorted.length; i++) {
            if (!contains(dupSorted[i])) {
                if (bc-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                } else if (sc-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                } else if (st-- > 0) {
                    catSorted[asize++] = dupSorted[i];
                }
            }
        }
        mergee.insertionSort(
            catSorted, 0, catSorted.length - 1, StudentInfo.comp);
        mergee.print(catSorted);
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
    }
    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int studcount = Integer.parseInt(sc.nextLine());
        Insertion sort = new Insertion();
        int vacancies = Integer.parseInt(sc.nextLine());
        int unrevacancies = Integer.parseInt(sc.nextLine());
        int bcvacancies = Integer.parseInt(sc.nextLine());
        int scvacancies = Integer.parseInt(sc.nextLine());
        int stvacancies = Integer.parseInt(sc.nextLine());
        Students stobj = new Students(studcount);
        String[] sinfo = null;
        for (int i = 0; i < studcount; i++) {
            sinfo = sc.nextLine().split(",");
            stobj.add(new StudentInfo(sinfo[0], sinfo[1],
                                      Integer.parseInt(sinfo[2]),
                                      Integer.parseInt(sinfo[2 + 1]),
                                      Integer.parseInt(sinfo[2 + 2]),
                                      Integer.parseInt(sinfo[2 + 2 + 1]),
                                      (sinfo[2 + 2 + 2])));
        }
        StudentInfo[] stinfo = stobj.getInfo();
        sort.insertionSort(stinfo, 0, stinfo.length - 1, StudentInfo.comp);
        sort.print(stinfo);
        System.out.println();
        CategoryCriteria ccobj = new CategoryCriteria(
            studcount, vacancies, unrevacancies, bcvacancies,
            scvacancies, stvacancies, stinfo);
        ccobj.catCriteria();
    }
}
/**
 * Class for insertion.
 */
class Insertion {
    /**
     * Constructor.
     */
    Insertion() {
        //Blank constructor.
    }
    /**
     * Worst Case Complexity is O(N^2).
     * It Iterates through out the array two times due to nested for loop.
     *
     * @param      a           { parameter_description }
     * @param      lo          The lower
     * @param      hi          The higher
     * @param      comparator  The comparator
     */
    public void insertionSort(final StudentInfo[] a, final int lo,
                              final int hi, final Comparator comparator) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * Swapping Elements in the Array.
     *
     * @param      a     Student Item
     * @param      i     index i
     * @param      j     index j
     */
    private  void exch(final StudentInfo[] a, final int i,
                       final int j) {
        StudentInfo swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * Less method.
     *
     * @param      a     Student Item 1
     * @param      b     Student Item 2
     * @param      comp  The component
     *
     * @return     Returns boolean
     */
    private boolean less(final StudentInfo a, final StudentInfo b,
                         final Comparator comp) {
        return comp.compare(a, b) < 0;
    }
    /**
     * to print the Output
     * Time complexity is O(N)
     * prints all the values in array.
     *
     * @param      items  The items
     */
    public void print(final StudentInfo[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getName() + ","
                               + items[i].getMarks() + ","
                               + items[i].getCategory());
        }
    }
}