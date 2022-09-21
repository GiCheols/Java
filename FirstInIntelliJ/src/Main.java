import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String var = null;
        String var2 = null;
        System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
        System.out.print("철수 >> ");
        Scanner s = new Scanner(System.in);
        var = s.nextLine();
        System.out.print("영희 >> ");
        var2 = s.nextLine();

        if (var.equals("가위")) {
            if (var2.equals("보"))
                System.out.println("철수가 이겼습니다");
            else if (var2.equals("바위"))
                System.out.println("철수가 졌습니다");
            else if (var2.equals("가위"))
                System.out.println("비겼습니다");
        } else if (var.equals("바위")) {
            if (var2.equals("보"))
                System.out.println("철수가 졌습니다");
            else if (var2.equals("바위"))
                System.out.println("비겼습니다");
            else if (var2.equals("가위"))
                System.out.println("철수가 이겼습니다");
        } else if (var.equals("보")) {
            if (var2.equals("보"))
                System.out.println("비겼습니다");
            else if (var2.equals("바위"))
                System.out.println("철수가 이겼습니다");
            else if (var2.equals("가위"))
                System.out.println("철수가 졌습니다");
        }
    }
}