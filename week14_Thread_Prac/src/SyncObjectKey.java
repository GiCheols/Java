class IHaveTwoNum{
    private int num1 = 0;
    private int num2 = 0;

    private Object key1 = new Object();
    private Object key2 = new Object();

    void addOneNum1(){
        synchronized (key1){
            num1 += 1;
        }
    }

    void addTwoNum1(){
        synchronized (key1){
            num1 += 2;
        }
    }

    void addOneNum2(){
        synchronized (key2){
            num2 += 1;
        }
    }

    void addTwoNum2(){
        synchronized (key2){
            num2 += 2;
        }
    }
}

public class SyncObjectKey {
}
