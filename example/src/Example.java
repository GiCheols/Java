import java.util.Scanner;
public class Example {
    private int personNum;
    private Class[] phone;

    Scanner s = new Scanner(System.in);

    public void init() {
        System.out.print("인원 수 >> ");
        personNum = s.nextInt();
        phone = new Class[personNum];
        for(int i = 0; i < phone.length; i++){
            System.out.print("이름과 전화번호(이름과 전화번호는 빈 칸 없이 입력)>> ");
            String name = s.next();
            String tel = s.next();
            phone[i] = new Class(name, tel);
        }
        System.out.println("저장되었습니다...");
    }

    public void run() {
        while(true){
            System.out.print("검색할 이름>> ");
            String a = s.next();
            for(int i = 0; i < personNum; i++){
                if(a.equals(phone[i].getName())) {
                    System.out.println(phone[i].getName() + "의 번호는 " + phone[i].getTel() + "입니다.");
                    break;
                } else if (a.equals("그만")) {
                    return;
                } else {
                    System.out.println(a + "의 이름은 없습니다.");
                    break;
                }
            }
        }
    }
}