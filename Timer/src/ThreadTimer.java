import java.util.Scanner;

public class ThreadTimer implements Runnable{
    private int second;
    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        second = s.nextInt();
        System.out.print("타이머 시작 \n" + second + "초\r");
        while(second > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            second -= 1;
            System.out.print(second + "초\r");
        }

        System.out.println("종료!");
    }

    public static void main(String[] args) {
        ThreadTimer timer = new ThreadTimer();

        timer.run();
    }
}
