package ex.lotto;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    private int[] lottoNumber;
    private boolean isValid;

    public Lotto(int[] lottoNumber) {
        Scanner s = new Scanner(System.in);
        this.lottoNumber = lottoNumber;
        System.out.println("6개의 숫자를 스페이스바로 구분하여 입력");
        for (int i = 0; i < lottoNumber.length; i++) {
            lottoNumber[i] = s.nextInt();
        }
    }

    public Lotto() {
        this.lottoNumber = new int[6];
        generate();
    }

    public boolean verify(int[] lottoNumber) {
        for (int i = 0; i < lottoNumber.length; i++) {
            for (int j = i + 1; j < lottoNumber.length; j++) {
                if (lottoNumber[i] == lottoNumber[j] ||
                        lottoNumber[i] < 1 || lottoNumber[i] > 46) {
                    return false;
                }
            }
        }
        return true;
    }

    public void generate() {
        Random r = new Random();
        for (int i = 0; i < lottoNumber.length; i++) {
            lottoNumber[i] = r.nextInt(45) + 1;
        }
    }

    public void show() {
        isValid = verify(lottoNumber);
        if (isValid) {
            for (int i = 0; i < getNumbers().length; i++) {
                System.out.print(lottoNumber[i] + " ");
            }
            System.out.println();
            return;
        }
        System.out.println("유효하지 않은 로또 복권입니다.");
    }

    public int[] getNumbers() {
        isValid = verify(lottoNumber);
        if (isValid) {
            return lottoNumber;
        }
        return null;
    }
}
