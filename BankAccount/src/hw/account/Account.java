package hw.account;

public class Account {
    private String accountNo;
    private String name;
    private int balance;

    public Account(String accountNo, String name, int balance){
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    String getName(){
        return name;
    }

    String getAccountNo(){
        return accountNo;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    int getBalance() {
        return balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public int withdraw(int amount){
        if(amount <= getBalance()) {
            balance -= amount;
            return amount;
        } return 0;
    }

    @Override
    public String toString() {
        return getName() + "님의 계좌 " + getAccountNo() +
                "의 잔액은 " + getBalance() + "입니다.";
    }

    public void check(){
        System.out.println(toString());
    }
}
