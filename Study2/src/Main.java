public class Main {
    public static void main(String[] args) throws InterruptedException {
        Person p = new Person();
        Drink d = new Drink();
        Order o = new Order();
        boolean op = true;

        while(op) {
            op = o.Ordering();
        }
    }
}