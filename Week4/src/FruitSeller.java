public class FruitSeller {

    static final int APPLE_COST = 1000;
    private int numOfApple = 20;
    private int money = 0;

    public FruitSeller(int numOfApple, int money){
        this.numOfApple = numOfApple;
        this.money = money;
    }

    public int saleApple(int money){
        int num = money / APPLE_COST;
        numOfApple -= num;
        this.money += money;
        return num;
    }

    public void showResult(){
        System.out.println("남은 사과: " + numOfApple + "개");
        System.out.println("판매 수익: " + money + "원");
    }
}
