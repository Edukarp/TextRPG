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

    public void attack(){
        if(game.location == "townGate"){
            guardHP = 20;
            guardDamage = 3;
            guardArmor = 5;

            if(game.playerDamage < guardArmor) {
                game.location = "talkGuard";
                game.mainTextArea.setText("Guard: Don't be fool. \nStat back! \nYou lose 1 HP");
                game.playerHP -= 1;
                game.choice1.setText(">");
                game.choice2.setText("");
                game.choice3.setText("");
                game.choice4.setText("");
            }
            else{
                game.location = "attackGuard";
                game.mainTextArea.setText("Guard: You will not get away with this!! \nYou dealt " + game.playerDamage
                + " damage and received " + guardDamage + " damage.\n\nWhat do you do?");
                game.playerHP -= 3;
                guardHP -= game.playerDamage - (guardArmor - 3);
                game.choice1.setText("Attack");
                game.choice2.setText("Use Item");
                game.choice3.setText("Try Run");
                game.choice4.setText("");
            }
        }
        else if(game.location == "attackGuard"){

        }
    }

    public void tryRun(){

    }



}