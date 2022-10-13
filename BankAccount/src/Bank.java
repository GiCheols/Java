import hw.account.*;

public class Bank {
    public static void main(String[] args) {
        Account[] aArr = new Account[5];
        aArr[0] = new Account("01", "남기철", 200000);
        aArr[1] = new CheckingAccount("02", "홍길동"
                , 50000, "1234-5678-9012-3456");
        aArr[2] = new CheckingTrafficCardAccount("03", "일지매"
                , 100000, "0987-6543-2109-8765", true);
        aArr[3] = new CreditLineAccount("04", "이지매"
                , 40000, 40000);
        aArr[4] = new BonusPointAccount("05", "삼지매"
                , 50000, 0);

        for (Account pa : aArr) {
            if(pa instanceof CheckingAccount){
                CheckingAccount cac = (CheckingAccount)pa;
                cac.pay(cac.getCardNo(), 40000);
                cac.check();
            } else if(pa instanceof CheckingTrafficCardAccount){
                CheckingTrafficCardAccount ctc = (CheckingTrafficCardAccount)pa;
                ctc.payTrafficCard(ctc.getCardNo(), 1250);
                ctc.check();
            } else if (pa instanceof CreditLineAccount) {
                CreditLineAccount clc = (CreditLineAccount)pa;
                clc.withdraw(50000);
                clc.check();
            } else if(pa instanceof BonusPointAccount){
                BonusPointAccount bpa = (BonusPointAccount) pa;
                bpa.deposit(10000);
                bpa.check();
            } else {
                pa.deposit(10000);
                pa.withdraw(5000);
                pa.check();
            }
        }
    }
}