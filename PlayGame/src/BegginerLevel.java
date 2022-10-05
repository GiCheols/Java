public class BegginerLevel extends PlayerLevel {
    public void run(){
        System.out.println("천천히 달립니다.");
    }

    public void jump(){
        System.out.println("Jump 할 수 없습니다.");
    }

    public void showLevelMessage(){
        System.out.println("----- 초급자 레벨이 되었습니다. -----");
    }

    public void turn(){
        System.out.println("turn 할 수 없습니다.");
    }

    @Override
    public void go(int count) {
        super.go(count);
    }
}
