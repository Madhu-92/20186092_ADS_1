import java.util.Comparator;

class StudentInfo {

    private String name;
    private int[] dob;
    private int sub1;
    private int sub2;
    private int sub3;
    private int totmarks;
    private String category;
    private static final int DAYS = 30;

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

    public String getName() {
        return name;
    }

    public int getMarks() {
        return totmarks;
    }

    public String getCategory() {
        return category;
    }

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