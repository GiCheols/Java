public class AdvancedLevel extends PlayerLevel{
    public void run(){
        System.out.println("빨리 달립니다.");
    }

    public void jump(){
        System.out.println("높이 jump 합니다.");
    }

    public void turn(){
        System.out.println("turn 할 수 없습니다.");
    }

    public void showLevelMessage(){
        System.out.println("----- 중급자 레벨이 되었습니다. -----");
    }
    @Override
    public void go(int count) {
        super.go(count);
    }
}
