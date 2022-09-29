public class Main {
    public static void main(String[] args) {
        Phone phone1 = new Phone("갤럭시", "010-1234-1234");
        Phone phone2 = new Phone("아이폰", "010-4567-4567");

        Person p1 = new Person("경민", phone1);
        Person p2 = new Person("기철", phone2);

        p1.playGame();
        p2.playGame();

        p1.sendMessage(p2);
        p2.sendMessage(p1);
    }
}