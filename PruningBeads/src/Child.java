public class Child {
    private int beads;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkBeads() {
        if (this.beads < 0) {
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
            c.setBeads(c.beads -= num);
            if(c.checkBeads()){
                this.beads += num;
                System.out.println(this.getName() + "의 구슬의 개수: " + this.getBeads());
                System.out.println(c.getName() + "의 구슬의 개수: " + c.getBeads());
            }
            else {
                System.out.println("구슬의 개수는 음수가 될 수 없음");
            }
    }

    public void loseBattle(Child c, int num){
        c.setBeads(this.beads -= num);
        if(this.checkBeads()) {
            c.beads += num;
            System.out.println(this.getName() + "의 구슬의 개수: " + this.getBeads());
            System.out.println(c.getName() + "의 구슬의 개수: " + c.getBeads());
        }
        else{
            System.out.println("구슬의 개수는 음수가 될 수 없음");
        }
    }
}
