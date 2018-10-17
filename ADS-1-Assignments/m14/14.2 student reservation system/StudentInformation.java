import java.util.Comparator;
/**
 * student information class.
 */
class StudentInfo {
    /**
     * name variable.
     */
    private String name;
    /**
     * dateofbirth.
     */
    private int[] dob;
    /**
     * sub1 variable.
     */
    private int sub1;
    /**
     * sub2 variable.
     */
    private int sub2;
    /**
     * sub3 variable.
     */
    private int sub3;
    /**
     * total marks.
     */
    private int totmarks;
    /**
     * category.
     */
    private String category;
    /**
     * number of days.
     */
    private static final int DAYS = 30;
    /**
     * Constructs the object.
     *
     * @param      n           name.
     * @param      b           dob.
     * @param      s1          The s 1
     * @param      s2          The s 2
     * @param      s3          The s 3
     * @param      totalmarks  The totalmarks
     * @param      cat         The cat
     */
    StudentInfo(final String n, final String b, final int s1,
                final int s2, final int s3, final int totalmarks,
                final String cat) {
        name = n;
        String[] dupdob = b.split("-");
        dob = new int[dupdob.length];
        for (int i = 0; i < dupdob.length; i++) {
            dob[i] = Integer.parseInt(dupdob[i]);
        }
        sub1 = s1;
        sub2 = s2;
        sub3 = s3;
        totmarks = totalmarks;
        category = cat;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public int getMarks() {
        return totmarks;
    }
    /**
     * Gets the category.
     *
     * @return     The category.
     */
    public String getCategory() {
        return category;
    }
    /**
     * comparator.
     */
    static Comparator<StudentInfo> comp = new Comparator<StudentInfo>() {
        public int compare(final StudentInfo s1, final StudentInfo s2) {
            if (s2.totmarks - s1.totmarks != 0) {
                return s2.totmarks - s1.totmarks;
            } else if (s2.sub3 - s1.sub3 != 0) {
                return s2.sub3 - s1.sub3;
            } else if (s2.sub2 - s1.sub2 != 0) {
                return s2.sub2 - s1.sub2;
            } else {
                if (s2.dob[2] - s1.dob[2] != 0) {
                    return s2.dob[2] - s1.dob[2];
                } else {
                    int count = 2 * 2 * (2 + 1);
                    return (((count - s1.dob[1]) * DAYS)
                            - ((count - s2.dob[1]) * DAYS));
                }
            }
        }
    };

}
