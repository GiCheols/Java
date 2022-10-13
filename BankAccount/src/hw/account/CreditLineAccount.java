package hw.account;

public class CreditLineAccount extends Account {
    private int creditLine;

    public CreditLineAccount(String accountNo, String name
            , int balance, int creditLine){
        super(accountNo, name, balance);
        this.creditLine = creditLine;
    }

    public int withdraw(int amount){
        if(super.withdraw(getBalance() + creditLine) < amount)
            return 0;
        return amount;
    }
}
