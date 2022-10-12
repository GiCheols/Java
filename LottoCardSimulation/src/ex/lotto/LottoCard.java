package ex.lotto;
import ex.lotto.Lotto;
import java.util.Scanner;

public class LottoCard {
    private Lotto[] mLotto;
    private int mEffNum;
    Scanner s = new Scanner(System.in);

    public LottoCard(){ // 복권 한 장
        mLotto = new Lotto[5];
        System.out.print("자동으로 발급받을 복권의 개수>> ");
        mEffNum = s.nextInt();
    }

    public void setMLotto() {
        if(mEffNum > 0 && mEffNum <= 5) {
            for (int i = 0; i < mEffNum; i++) {
                mLotto[i] = new Lotto();
            }

            for(int i = mEffNum; i < 5; i++){
                int[] arr = new int[6];
                mLotto[i] = new Lotto(arr);
            }
        }
    }

    public void returnNum(){
        System.out.println();
        for(int i = 0; i < mLotto.length; i++)
            mLotto[i].show();
    }
}
