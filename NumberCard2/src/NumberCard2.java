import java.util.HashMap;
import java.util.Scanner;

public class NumberCard2 {
    public static void main(String[] args) {
        int n, m;
        HashMap<Integer, Integer> numberCard = new HashMap<>();
        Scanner s = new Scanner(System.in);

        /*      < HashMap 에 key 값 put >
        기존 key 가 없다면: put
        기존 key 가 있다면: 기존 value 값은 삭제되고 새로운 value put
        Sol: value == key 의 개수!
        */
        n = s.nextInt();
        for(int i = 0; i < n; i++){
            int k = s.nextInt();
            if(numberCard.get(k) == null)
                numberCard.put(k, 1);
            else
                numberCard.put(k, numberCard.get(k) + 1);
        }

        m = s.nextInt();
        for(int i = 0; i < m; i++){
            int T = s.nextInt();
            if(numberCard.get(T) == null)
                System.out.print(0 + " ");
            else
                System.out.print(numberCard.get(T) + " ");
        }
    }
}
