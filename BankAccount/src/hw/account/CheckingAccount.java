package hw.account;

import java.util.Objects;

public class CheckingAccount extends Account {

    protected String cardNo;

    public CheckingAccount(String accountNo, String name, int balance
            ,String cardNo){
        super(accountNo, name, balance);
        this.cardNo = cardNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && o instanceof CheckingAccount) {
            CheckingAccount ca = (CheckingAccount) o;
            if(cardNo == ca.cardNo)
                result = true;
        }
        return result;
    }

    public int pay(String cardNo, int amount){
        if(this.cardNo.equals(cardNo)) {
            return withdraw(amount);
        } else {
            System.out.println("카드 번호가 다릅니다.");
            return 0;
        }
    }
}
