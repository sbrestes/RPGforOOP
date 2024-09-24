public class LevelSkip implements Rewardable {
    @Override
    public String getTitle() {
        return "Skip a Level";
    }

    @Override
    public void addToCharacter(Character c) {
        Global.getInstance().levelUp();
    }
}
