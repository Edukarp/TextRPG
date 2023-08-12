import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TitleScreenHandler implements ActionListener {

    private Game game;

    public TitleScreenHandler(Game game){
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        game.createGameScreen();

    }
}
