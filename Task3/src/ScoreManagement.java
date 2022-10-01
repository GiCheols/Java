import java.util.Scanner;

public class ScoreManagement {
    private Student student = new Student();

    private Subject[] subjects;
    private GradeCard gradeCard = new GradeCard();
    private Scanner s = new Scanner(System.in);

    public double setGradeCard(Subject[] subjects){
        double sum = 0;
        for(int i = 0; i < subjects.length; i++){
            sum += subjects[i].getSubjectScore();
        }

        return sum / subjects.length;
    }

    public void printScoreTable(){
        System.out.println("--- 학생 프로필 ---");
        System.out.println("이름: " + student.getStudentName());
        System.out.println("학번: " + student.getStudentNumber());
        System.out.println("학년: " + student.getStudentGrade());
        System.out.println("평균 점수: " + gradeCard.getScoreAverage());
    }

    public void setScoreManagement(){
        System.out.print("학생의 이름을 입력해주세요 >>");
        student.setStudentName(s.next());
        System.out.print("학번을 입력해주세요 >>");
        student.setStudentNumber(s.next());
        System.out.print("학년을 입력해주세요 >>");
        student.setStudentGrade(s.nextInt());
        System.out.print("몇 개의 과목을 수강하셨나요? >>");
        student.setSubjectCount(s.nextInt());

        subjects = new Subject[student.getSubjectCount()];

        for(int i = 0; i<subjects.length ;i++){
            System.out.println((i+1) + "번째 과목 입력");
            System.out.print("과목명 >> ");
            subjects[i] = new Subject();
            subjects[i].setSubjectName(s.next());
            System.out.print("점수 >> ");
            subjects[i].setSubjectScore(s.nextInt());
        }

        gradeCard.setScoreAverage(setGradeCard(subjects));

        printScoreTable();
    }
}
