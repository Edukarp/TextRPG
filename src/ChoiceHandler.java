import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {

    private Game game;

    public ChoiceHandler(Game game){
        this.game = game;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String yourChoice = e.getActionCommand();

        switch (game.location){
            case "townGate":
                switch (yourChoice){
                    case "c1": game.guard.talk(); break;
                    case "c2": game.guard.attack(); break;
                    case "c3": break; //Intimidate
                    case "c4": game.crossRoad(); break;
                }
                break;
            case "talkGuard":
                switch (yourChoice){
                    case "c1": game.townGate(); break;
                }
                break;
            case "attackGuard":
                switch (yourChoice){
                    case "c1": game.guard.attack(); break;
                    case "c2": break; //use item
                    case "c3": game.guard.tryRun(); break;
                }
                break;
            case "deadGateGuard":
                switch (yourChoice){
                    case "c1": game.townGate(); break; //mudar pra dentro da cidade
                }
                break;
            case "crossRoad":
                switch (yourChoice){
                    case "c1": break; //north
                    case "c2": game.townGate(); //south
                    case "c3": game.riverSiteCampfire(); break; //east
                    case "c4": game.goblinWest(); break; //west
                }
                break;
            case "riverSiteCampfire":
                switch (yourChoice){
                    case "c1": game.crossRoad(); break; //go back
                    case "c2": break; //level up
                    case "c3": break; //Change Equip
                    case "c4": break; //See stats
                }
                break;
            case "tinyGoblinSite":
                switch (yourChoice){
                    case "c1": game.goblin.attack();
                    case "c2": break;
                }
                break;
            case "attackTinyGoblin":
                switch (yourChoice){
                    case "c1": game.goblin.attack();
                    case "c2": break;
                }
        }
    }
}
