public class Main {
    public static void main(String[] args) {
        Child c1 = new Child();
        Child c2 = new Child();

        c1.setName("어린이 1");
        c2.setName("어린이 2");
        c1.setBeads(15);
        c2.setBeads(9);

        c1.winBattle(c2,2);
        c1.loseBattle(c2, 7);
    }
}