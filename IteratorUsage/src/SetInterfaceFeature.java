import java.util.HashSet;
import java.util.Iterator;

public class SetInterfaceFeature {
    public static void main(String[] args) {
        HashSet<String> hSet = new HashSet<String>();

        hSet.add("First");
        hSet.add("Second");
        hSet.add("Third");
        hSet.add("First");	//중복된 값을 추가할 경우 false 반환

        System.out.println("데이터 수: " + hSet.size());	// 3
        // Second, Third, First 순: 저장순서를 유지하지 않기 때문에 벌어진 일

        Iterator<String> itr = hSet.iterator();

        while(itr.hasNext())
            System.out.println(itr.next());
    }
}
/*
순서대로 저장되지 않기 때문에 HashSet 으로부터 값을 가져오기 위해서는 get()함수 사용 불가
모두 갖고 오기 위해 반복자 사용 하고 있음 -> 어떤 컬렉션으로부터 동일하게 값을 가져올 수 있음
*/
