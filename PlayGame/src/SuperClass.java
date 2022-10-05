public class SuperClass extends PlayerLevel {
    public void run(){
        System.out.println("매우 빠르게 달립니다.");
    }

    public void jump(){
        System.out.println("아주 높이 jump 합니다.");
    }

    public void turn(){
        System.out.println("turn 합니다.");
    }

    public void showLevelMessage(){
        System.out.println("----- 고급자 레벨이 되었습니다. -----");
    }
    @Override
    public void go(int count) {
        super.go(count);
    }
}
