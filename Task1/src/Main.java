import java.util.Scanner;

public class Main {
    private static TV tv;
    private static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("TV 이름을 정해주세요>> ");
        tv = new TV(s.next());
        tv.channelUp();
        tv.powerChange();
        tv.channelDown();
        tv.volumeUp();
        tv.volumeDown();

        tv.powerChange();
    }
}