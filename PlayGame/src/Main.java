public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        player.play(1);

        AdvancedLevel aLevel = new AdvancedLevel();
        player.upgradeLevel(aLevel);
        player.play(2);

        SuperClass sLevel = new SuperClass();
        player.upgradeLevel(sLevel);
        player.play(3);
    }
}