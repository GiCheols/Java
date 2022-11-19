import java.awt.*;

public class FontListener { // 어떤 폰트를 사용할 수 있는지 확인하기 위한 코드
    public static void main(String[] args) {
        String[] fontList;
        GraphicsEnvironment g;
        g = GraphicsEnvironment.getLocalGraphicsEnvironment();

        fontList = g.getAvailableFontFamilyNames();
        for(int i = 0; i < fontList.length; i++)
            System.out.println(fontList[i]);
    }
}
