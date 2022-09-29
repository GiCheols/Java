public class Main {
    public static void main(String[] args) {
        FruitSeller seller = new FruitSeller(20, 0);
        FruitBuyer buyer = new FruitBuyer(10000, 0);

        int n = seller.saleApple(2000);
        buyer.buyApple(seller, 1000);

        seller.showResult();
        buyer.showResult();
    }
}