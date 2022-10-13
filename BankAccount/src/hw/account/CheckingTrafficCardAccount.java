package hw.account;

public class CheckingTrafficCardAccount extends CheckingAccount{
    boolean hasTrafficCard;

     public CheckingTrafficCardAccount(String accountNo, String name
             , int balance, String cardNo, boolean hasTrafficCard){
         super(accountNo, name, balance, cardNo);
         this.hasTrafficCard = hasTrafficCard;
     }

    public boolean getHasTrafficCard() {
        return hasTrafficCard;
    }

    public int payTrafficCard(String cdNo, int amount){
        if(!getHasTrafficCard()){
            System.out.println("등록되지 않은 교통카드 입니다.");
            return 0;
        }
        return pay(cdNo, amount);
    }
}
