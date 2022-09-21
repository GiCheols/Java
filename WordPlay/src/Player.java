import java.util.Scanner;

public class Player {
    String player, pw;
    int lastIndex;
    char firstChar, lastChar;
    Scanner s = new Scanner(System.in);

    String getWordFromUser(){
        pw = s.next();
        return pw;
    }
    boolean checkSuccess(String lc){
        lastIndex = lc.length() - 1;
        lastChar = lc.charAt(lastIndex);
        firstChar = pw.charAt(0);
        if(firstChar == lastChar)
            return true;
        else
            return false;
    }
}
