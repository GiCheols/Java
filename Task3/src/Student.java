public class Student {
    private String studentNumber;
    private String studentName;
    private int studentGrade;
    private int subjectCount;


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setSubjectCount(int subjectCount) {
        this.subjectCount = subjectCount;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public int getSubjectCount() {
        return subjectCount;
    }
}
