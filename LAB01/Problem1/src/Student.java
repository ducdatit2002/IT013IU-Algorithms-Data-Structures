public class Student {
    private String fname;
    private String lname;
    private int grade;

    public Student(String fname, String lname, int grade) {
        this.fname = fname;
        this.lname = lname;
        this.grade = grade;
    }

    public String getFullName() {
        return fname + " " + lname;
    }

    public int getGrade() {
        return grade;
    }

    public String getStudentType() {
        if (grade > 89) {
            return "Excellent";
        } else if (grade >= 60 && grade <= 89) {
            return "OK";
        } else {
            return "Failure";
        }
    }

    public String toString() {
        return getFullName() + "\t" + grade;
    }
}