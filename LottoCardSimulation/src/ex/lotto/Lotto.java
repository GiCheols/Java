package ex.lotto;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
    private int[] lottoNumber;
    private boolean isValid;
    Scanner s = new Scanner(System.in);


    public Lotto(int[] lottoNumber){
        this.lottoNumber = lottoNumber;
        System.out.println("6개의 숫자를 스페이스바로 구분하여 입력");
        for(int i = 0; i < lottoNumber.length; i++){
            lottoNumber[i] = s.nextInt();
        }
    }

    public Lotto(){
        this.lottoNumber = new int[6];
        generate();
    }

    public boolean verify(int[] lottoNumber) {
        for (int i = 0; i < this.lottoNumber.length; i++) {
            for (int j = i + 1; j < this.lottoNumber.length; j++) {
                if (this.lottoNumber[i] == this.lottoNumber[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void generate() {
        Random r = new Random();
        int iRandom;
        for(int i = 0; i < lottoNumber.length; i++){
            this.lottoNumber[i] = r.nextInt(45) + 1;
        }
    }

    public void show() {
        if(verify(this.lottoNumber)) {
            for (int i = 0; i < this.getNumbers().length; i++) {
                System.out.print(this.lottoNumber[i] + " ");
            }
        }
        else {
            System.out.print("유효하지 않은 로또 복권입니다.");
        }
        System.out.println();

    }

    public int[] getNumbers(){
        if(this.verify(this.lottoNumber)){
            return this.lottoNumber;
        }
        else{
            return null;
        }
    }
}
