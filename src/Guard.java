public class Guard {

    private Game game;
    public int guardHP;
    public int guardDamage;
    public int guardArmor;

    public Guard(Game game){
        this.game = game;
    }

    public void talk(){
        if(game.location == "townGate"){
            game.location = "talkGuard";
            game.mainTextArea.setText("Guard: Hello Stranger. I have never seen your face before. \nI'm sorry" +
                    " but we cannot let a stranger enter our town.");
            game.choice1.setText(">");
            game.choice2.setText("");
            game.choice3.setText("");
            game.choice4.setText("");
        }

    }

    public void setGuardHP(int guardHP) {
        this.guardHP = guardHP;
    }

    public void setGuardDamage(int guardDamage) {
        this.guardDamage = guardDamage;
    }

    public void setGuardArmor(int guardArmor) {
        this.guardArmor = guardArmor;
    }

    public void attack(){
        if(game.location == "townGate"){
            setGuardHP(20);
            setGuardDamage(3);
            setGuardArmor(5);

            if(game.player.damage < guardArmor) {
                game.location = "talkGuard";
                game.mainTextArea.setText("Guard: Don't be fool. \nStay back! \n\nYou lose 1 HP");
                game.player.setHp(game.player.Hp -= 1);
                game.choice1.setText(">");
                game.choice2.setText("");
                game.choice3.setText("");
                game.choice4.setText("");
            }
            else{
                game.location = "attackGuard";
                game.mainTextArea.setText("Guard: You will not get away with this!! \nYou dealt " + (guardArmor + game.player.damage)
                + " damage and received " + guardDamage + " damage.\n\nWhat do you do?");
                game.player.setHp(game.player.Hp - guardDamage);
                setGuardHP(guardHP - (guardArmor - game.player.damage));
                game.choice1.setText("Attack");
                game.choice2.setText("Use Item");
                game.choice3.setText("Try Run");
                game.choice4.setText("");
            }
        }
        else if(game.location == "attackGuard"){
            if(guardHP > 0) {
                game.location = "attackGuard";
                game.mainTextArea.setText("Guard: You will not get away with this!! \nYou dealt " + (guardArmor + game.player.damage)
                        + " damage and received " + guardDamage + " damage.\n\nWhat do you do?");
                setGuardHP(guardHP - (guardArmor - game.player.damage));
                game.player.setHp(game.player.Hp - guardDamage);
                game.choice1.setText("Attack");
                game.choice2.setText("Use Item");
                game.choice3.setText("Try Run");
                game.choice4.setText("");
            }
            else{
                game.location = "deadGateGuard";
                game.mainTextArea.setText("You kill the gate Guard, better run in before someone see you." +
                        " \nYou gain X exp and get a warrior sword and a health potion." +
                        " \nYou used the health potion now you hp is full restore.");
                game.weaponLabelName.setText("Warrior Sword");
                game.player.setHp(15);
                game.choice1.setText("Enter the city");
                game.choice2.setText("");
                game.choice3.setText("");
                game.choice4.setText("");
            }
        }
    }

    public void tryRun(){

    }



}
