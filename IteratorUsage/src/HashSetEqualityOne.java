import java.util.HashSet;
import java.util.Iterator;

class SimpleNumber {
    int num;

    SimpleNumber(int n){
        num = n;
    }

    public String toString() {
        return String.valueOf(num);
    }
}

public class HashSetEqualityOne {
    public static void main(String[] args){
        HashSet<SimpleNumber> hSet = new HashSet<SimpleNumber>();

        hSet.add(new SimpleNumber(10));
        hSet.add(new SimpleNumber(20));
        hSet.add(new SimpleNumber(20));
        // 20 10 20 => String 이 아닌 SimpleNumber 타입
        // 중복된 값이 같은지 구분 할 수 없음.
        // ctrl + o -> equals() 메서드와 hashCode() 메서드 재정의 필요함

        System.out.println("데이터 수: " + hSet.size());

        Iterator<SimpleNumber> it = hSet.iterator();

        while(it.hasNext())
            System.out.println(it.next());
    }
}

/* 따라서 class에
public int hashCode(){	// int형 값을 반환해 그룹핑 가능
	return num % 3;
}

public boolean equals(Object obj) {
	if(obj != null && obj instanceof SimpleNumber) {
		SimpleNumber comp = (SimpleNumber)obj;
		if(comp.num == num)
			return true;
	}
	return false;
}
추가하게 되면 동일정보임(equals)과 같은 데이터처럼 인식(hashCode) 가능
*/