package hw.account;

public class BonusPointAccount extends Account {
    private int bonusPoint;

    public BonusPointAccount(String accountNo, String name
            , int balance, int bonusPoint){
        super(accountNo, name, balance);
        this.bonusPoint = bonusPoint;
    }

    public void setBonusPoint(int bonusPoint){
        this.bonusPoint = bonusPoint;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    @Override
    public String toString() {
        return super.toString() + " 포인트는 " + getBonusPoint() + "입니다";
    }

    public void deposit(int amount){
        super.deposit(amount);
        setBonusPoint((int)(amount * 0.1));
    }

    public void check(){
        System.out.println(toString());
    }
}
