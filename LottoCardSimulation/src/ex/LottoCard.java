package ex;

import ex.lotto.Lotto;

import java.util.Scanner;

public class LottoCard {
    private Lotto[] mLotto;
    private int mEffNum;
    Scanner s = new Scanner(System.in);

    public LottoCard(){ // 복권 한 장
        this.mLotto = new Lotto[5];
        System.out.print("자동으로 발급받을 복권의 개수>> ");
        this.mEffNum = s.nextInt();
    }

    public void setMLotto() {
        if(this.mEffNum > 0 && this.mEffNum <= 5) {
            for (int i = 0; i < this.mEffNum; i++) {
                this.mLotto[i] = new Lotto();
            }

            for(int i = this.mEffNum; i < 5; i++){
                int[] arr = new int[6];
                this.mLotto[i] = new Lotto(arr);
            }
        }
    }

    public void returnNum(){
        System.out.println();
        for(int i = 0; i < this.mLotto.length; i++)
            this.mLotto[i].show();
    }
}
