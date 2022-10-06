import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("전화 상담원 할당 방식을 선택하세요");
        System.out.println("R : 한명씩 차례대로");
        System.out.println("L : 대기가 적은 상담원 우선");
        System.out.println("P : 우선순위가 높은 고객우선 숙련도 높은 상담원");

        // Scheduler 객체 생성
        Scheduler scheduler = new RoundRobin();
        while(true) {
            int ch = System.in.read();
            char c = (char)ch;
            System.in.read();   // 개행문자 빼주기
            switch (c) {
                // R, r 입력 시 RoundRobin 할당
                case 'r':
                case 'R':
                    scheduler = new RoundRobin();
                    scheduler.getNextCall();
                    scheduler.sendCallToAgent();
                    break;
                // L, l 입력 시 LeastJob 할당
                case 'l':
                case 'L':
                    scheduler = new LeastJob();
                    scheduler.getNextCall();
                    scheduler.sendCallToAgent();
                    break;
                // P, p 입력 시 PriorityAllocation 할당
                case 'p':
                case 'P':
                    scheduler = new PriorityAllocation();
                    scheduler.getNextCall();
                    scheduler.sendCallToAgent();
                    break;
                // else "지원되지 않는 기능입니다" 출력
                default:
                    System.out.println("지원되지 않는 기능입니다.");
                    break;
            }

        }
    }
}