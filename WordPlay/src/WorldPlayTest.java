/**
 * 자바 스터디 첫 과제
 * 끝말잇기 프로그램
 * 남기철
 *
 */

import java.util.Scanner;
public class WorldPlayTest {
    int n;
    String name;
    String word = "아버지";
    public void run() {
        Scanner s = new Scanner(System.in);
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇 명입니까>> ");
        n = s.nextInt();
        Player[] p = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.print("참가자의 이름을 입력하세요>> ");
            name = s.next();
            p[i] = new Player();
            p[i].player = name;
        }
        System.out.println("시작하는 단어는 아버지입니다.");
        for(;;){
            int i = 0, j = 0;
            j = i % n;
            name = p[j].player;
            System.out.print(name + ">>");
            p[j].pw = p[j].getWordFromUser();
            System.out.println(p[j].pw + " " + word);
            if(p[j].checkSuccess(word) == true) {
                word = p[j].pw;
                i++;
            }
            else{
                System.out.println(name + "이(가) 졌습니다.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Player p = new Player();
        WorldPlayTest w = new WorldPlayTest();
        w.run();
    }
}
