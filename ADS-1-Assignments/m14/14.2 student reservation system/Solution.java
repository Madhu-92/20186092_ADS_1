import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class Students {
    
    private StudentInfo[] info;
    
    private int num;
    
    private int size;
    
    Students(final int data) {
        num = data;
        info = new StudentInfo[num];
        size = 0;
    }
    
    public void add(final StudentInfo stud) {
        if (size == info.length) {
            resize();
        }
        info[size++] = stud;
    }

    public void resize() {
        info = Arrays.copyOf(info, info.length * 2);
    }

    public StudentInfo[] getInfo() {
        return info;
    }
}


class CategoryCriteria {
    
    private CategoryCriteria() {
        //Blank constructor.
    }
    
    private Insertion mergee = new Insertion();
    
    private int applied;
    
    private int vacancies;
    
    private int ur;
    
    private int bc;
    
    private int sc;
    
    private int st;
    
    private int asize;
    
    private StudentInfo[] dupSorted;
    
    private int size;
    
    private StudentInfo[] catSorted;
    
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

    private boolean contains(final StudentInfo student) {
        for (int i = 0; i < asize; i++) {
            if (catSorted[i].getName().equals(student.getName())) {
                return true;
            }
        }
        return false;
    }
    
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



public final class Solution {
    
    private Solution() {
    }
    
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

class Insertion {
    
    Insertion() {
        //Blank constructor.
    }

    public void insertionSort(final StudentInfo[] a, final int lo,
                              final int hi, final Comparator comparator) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private  void exch(final StudentInfo[] a, final int i,
                       final int j) {
        StudentInfo swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    private boolean less(final StudentInfo a, final StudentInfo b,
                         final Comparator comp) {
        return comp.compare(a, b) < 0;
    }
    
    public void print(final StudentInfo[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getName() + ","
                               + items[i].getMarks() + ","
                               + items[i].getCategory());
        }
    }
}