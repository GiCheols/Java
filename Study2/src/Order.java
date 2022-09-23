import java.util.Scanner;

public class Order {
    Person p = new Person();
    Drink d = new Drink();
    private int number, count = 0;

    public void setNumber(int number){
        this.number = number;
    }

    int getNumber(){
        return this.number;
    }

    @Override
    public String toString() {
        return  count +
                "번 " + p.getPersonName() +
                "님, 주문하신 " + d.getDrinkName() +
                "나왔습니다!";
    }

    public boolean Ordering() throws InterruptedException {
        Scanner s = new Scanner(System.in);
        System.out.println("어서오세요! 카페입니다.");
        System.out.println("----------");
        System.out.println("1. 주문하기");
        System.out.println("2. 종료하기");
        System.out.println("----------");
        System.out.print("어떻게 하시겠어요? ");
        number = s.nextInt();
        count++;
        if(number == 1){
            System.out.print("주문자 성함을 말씀해주세요>> ");
            p.setPersonName(s.next());
            System.out.print("주문하실 메뉴를 말씀해주세요>> ");
            d.setDrink(s.next());
            for(int i = 3; i>0;i--){
                System.out.println(i + "...");
                Thread.sleep(1000);
            }
            System.out.println(toString());
        }
        else if(number == 2) {
            System.out.println("이용해주셔서 감사합니다~");
            return false;
        }
        return true;
    }
}
