import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int getInteger(){
        Scanner s = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int next = s.nextInt();
        return next;
    }

    public static void main(String[] args) {
        int result = 0;
        while(true){
            try {
                result = getInteger();
                System.out.println("입력한 정수는 " + result);
            } catch (InputMismatchException ie) {
                result = 0;
                System.out.println("잘못 입력하셨습니다.");
            }
            if (result == 0)
                continue;
            break;
        }
    }
}