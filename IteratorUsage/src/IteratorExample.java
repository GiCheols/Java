import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add("Forth");

        Iterator<String> it = list.iterator();

        System.out.println("삭제 전");
        while (it.hasNext()){
            String current = it.next();
            System.out.println(current);

            if(current.compareTo("Third") == 0)
                it.remove();
        }

        // 처음부터 다시 반복하기 위해 반복자 다시 호출
        it = list.iterator();

        System.out.println("삭제 후");
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
