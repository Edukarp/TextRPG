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
                    case "c3": break;
                    case "c4": break;
                }
                break;
            case "talkGuard":
                switch (yourChoice){
                    case "c1": game.tonwGate(); break;
                }
                break;
            case "attackGuard":
                    switch (yourChoice){
                        case "c1": game.guard.attack();
                        case "c2": break;
                        case "c3": game.guard.tryRun();
                    }

        }
    }
}
