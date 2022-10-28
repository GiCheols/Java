package hw.account;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    private String accountNo;
    private String name;
    private int balance;

    public Account(String accountNo, String name, int balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    String getName() {
        return name;
    }

    String getAccountNo() {
        return accountNo;
    }

    int getBalance() {
        return balance;
    }

    public void deposit(int amount) throws MalformedData {
        if(amount < 0) throw new MalformedData();
        balance += amount;
    }

    public int withdraw(int amount) throws MalformedData {
        if (amount < 0) throw new MalformedData();
        if (amount > balance) throw new MalformedData();
        balance -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return getName() + "님의 계좌 " + getAccountNo() +
                "의 잔액은 " + getBalance() + "입니다.";
    }

    public void check () {
        System.out.println(toString());
    }
}