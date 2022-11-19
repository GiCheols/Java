import java.util.Scanner;

public class BackJoon10870 {
    public static int fibo(int n){
        if(n <= 1)
            return n;
        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(fibo(s.nextInt()));
    }
}
