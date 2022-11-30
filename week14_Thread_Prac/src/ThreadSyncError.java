class Increment{
    private int num = 0;

    synchronized void inc() { num++; }
    int getNum(){ return num; }
}

class IncThread extends Thread{
    private Increment cnt;

    IncThread(Increment inc){
        this.cnt = inc;
    }

    public void run(){
        for (int i = 0; i < 10000; i++)
            for (int j = 0; j < 100; j++)
                cnt.inc();
    }
}

public class ThreadSyncError {
    public static void main(String[] args) {
        Increment i = new Increment();

        // i 라는 객체를 공유해서 사용
        IncThread it1 = new IncThread(i);
        IncThread it2 = new IncThread(i);
        IncThread it3 = new IncThread(i);

        it1.start();
        it2.start();
        it3.start();

        try {
            // 해당하는 스레드가 모두 끝날 때까지 대기하겠다!
            it1.join();
            it2.join();
            it3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(i.getNum());
        // 3백만이 됐다 안됐다 되기도 함
        // 데이터 불일치가 발생했음!!
    }
}