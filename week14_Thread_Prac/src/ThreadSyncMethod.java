class Calculator{
    private int opCnt = 0;
    synchronized int add(int n1, int n2){
        opCnt++;
        return n1 + n2;
    }

    synchronized int sub(int n1, int n2){
        opCnt++;
        return n1 - n2;
    }

    void showOpCnt(){
        System.out.println("총 연산 횟수: " + opCnt);
    }
}

class AddThread extends Thread{
    private Calculator cal;

    AddThread(Calculator cal){
        this.cal = cal;
    }

    @Override
    public void run() {
        System.out.println("1 + 2= " + cal.add(1, 2));
        System.out.println("2 + 4= " + cal.add(2, 4));
    }
}

class MinThread extends Thread{
    private Calculator cal;

    MinThread(Calculator cal){
        this.cal = cal;
    }

    @Override
    public void run() {
        System.out.println("2 - 1= " + cal.sub(2, 1));
        System.out.println("4 - 2= " + cal.sub(4, 2));
    }
}
public class ThreadSyncMethod {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        AddThread at = new AddThread(cal);
        MinThread mt = new MinThread(cal);

        // thread 를 Runnable 상태로 만들어 줌
        at.start();
        mt.start();

        try{
            at.join();
            mt.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        cal.showOpCnt();
    }
}
