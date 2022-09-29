public class Child {
    private int beads;

    public boolean checkBeads(int beads) {
        if (beads < 0) {
            System.out.println("구슬의 개수는 음수일 수 없음");
            return false;
        }
        else
            return true;
    }

    public void setBeads(int beads) {
            this.beads = beads;
    }

    public int getBeads() {
        return beads;
    }

    public void winBattle(Child c, int num){
        c.beads -= num;
        beads += num;
    }

    public void loseBattle(Child c, int num){
        c.beads -= num;
        beads -= num;
    }
}
