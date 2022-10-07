package ex.hw;
import ex.LottoCard;

import java.util.Scanner;

public class LottoSim {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("로또 복권의 매수 입력");
        LottoCard[] c = new LottoCard[s.nextInt()];

        for(int i = 0; i < c.length; i++){
            System.out.println((i + 1) + "번째 로또 입력");
            c[i] = new LottoCard();
            c[i].setMLotto();
        }

        for(int i = 0; i < c.length;i++){
            c[i].returnNum();
        }
    }
}
