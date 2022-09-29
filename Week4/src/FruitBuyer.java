public class FruitBuyer {
    private int money;
    private int numOfApple;
    
    public FruitBuyer(int money, int numOfApple){
        this.money = money;
        this.numOfApple = numOfApple;
    }
    
    public void buyApple(FruitSeller s, int money){
        this.money -= money;
        this.numOfApple += s.saleApple(money);
    }
    
    public void showResult(){
        System.out.println("구입개수: " + numOfApple + "개");
        System.out.println("소지금액: " + money + "원");
    }
}
