package ex.hw;

import ex.LottoCard;

public class LottoSim {
    public static void main(String[] args) {
        LottoCard[] c = new LottoCard[2];

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
