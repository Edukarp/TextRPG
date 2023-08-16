public class Goblin {
    private Game game;
    public int goblinHp;
    public int goblinArmor;
    public int goblinDamage;

    public Goblin(Game game){this.game = game;}

    public void setGoblinHp(int goblinHp) {
        this.goblinHp = goblinHp;
    }

    public void setGoblinArmor(int goblinArmor) {
        this.goblinArmor = goblinArmor;
    }

    public void setGoblinDamage(int goblinDamage) {
        this.goblinDamage = goblinDamage;
    }

    public void attack() {
        if (game.location == "tinyGoblinSite") {
            game.location = "attackTinyGoblin";
            setGoblinHp(5);
            setGoblinArmor(0);
            setGoblinDamage(1);
        } else if (game.location == "attackTinyGoblin") {
            if(goblinHp > 0){
                game.mainTextArea.setText("Tiny Goblin: You hit the goblin, he cries and hit you back. \nYou dealt " + game.player.damage
                        + " damage and received " + goblinDamage + " damage.\n\nWhat do you do?");
                game.player.setHp(game.player.Hp - goblinDamage);
                setGoblinHp(goblinHp - game.player.damage);
                game.choice1.setText("Attack");
                game.choice2.setText("Use Item");
                game.choice3.setText("");
                game.choice4.setText("");

            }
            else{
                game.location = "defeatedTinyGoblin";
                game.tinyGoblinDefeat = true;
                game.mainTextArea.setText("You defeated the Tiny Goblin, shame on you! \nAnd... looking for the blocked" +
                        " sword, you fond a Shortsword and gain X exp. \n\nYou can see a Goblin Camp forward, and decide" +
                        " go back before attack that.");
                game.player.setWeaponAndDamage("Shortsword", 3, game.player.nivelGeral);
                game.choice1.setText("Go back");
                game.choice2.setText("");
                game.choice3.setText("");
                game.choice4.setText("");

            }

        }
    }
}
