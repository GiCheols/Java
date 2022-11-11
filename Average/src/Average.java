import java.util.ArrayList;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int n, score, max = 0;
        double average, sum = 0;
        Scanner s = new Scanner(System.in);

        n = s.nextInt();
        ArrayList<Integer> scores = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            score = s.nextInt();
            scores.add(score);
            if(score > max)
                max = score;
        }

        for (int newScore : scores)
            sum += newScore / (double)max * 100;

        average = sum / n;
        System.out.println(average);
    }
}
