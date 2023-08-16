import javax.swing.*;
import java.awt.*;

public class Game {

    public JFrame window;
    public Container con;
    public JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    public JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName, locationLabel, locationLabelName;
    public JButton startButton, choice1, choice2, choice3, choice4;
    public JTextArea mainTextArea;
    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    public Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    public TitleScreenHandler tsHandler;
    public ChoiceHandler choiceHandler = new ChoiceHandler(this);
    String location = "townGate";
    Guard guard = new Guard(this);
    Player player = new Player(this);
    Goblin goblin = new Goblin(this);
    //Mudanca de senarios
    public boolean tinyGoblinDefeat = false;

    public Game(){

        //Janela
        window = new JFrame();
        window.setSize(800,600); //Dimensoes da janela
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funcao de fechar a janela
        window.getContentPane().setBackground(Color.black); //Definindo fundo pra preto
        window.setLayout(null); //Desabilita o layout padrao
        window.setVisible(true); //Habilita aparecer a janela na tela quando iniciar
        con = window.getContentPane();

        //Titulo
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100,600,150); //Dimisoes limites do titulo
        titleNamePanel.setBackground(Color.black);

        titleNameLabel = new JLabel("JOURNEY"); //Definindo o texto
        titleNameLabel.setForeground(Color.white); //Definindo a cor do texto
        titleNameLabel.setFont(titleFont);

        titleNamePanel.add(titleNameLabel); //Adicionado ao Panel a Label
        con.add(titleNamePanel); //Colocando tudo no container

        //Botao Start
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        tsHandler = new TitleScreenHandler(this);
        startButton.addActionListener(tsHandler); //Reconhecer o click e realizar a acao
        startButton.setFocusPainted(false); //Sumir com a borda inferior do botao

        startButtonPanel.add(startButton);
        con.add(startButtonPanel);


    }

    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100,100,600,250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea= new JTextArea("This is the main text Area, look the font and lenght");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //Quebra de linha automatica
        mainTextPanel.add(mainTextArea);

        //Botao de Escolhas
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Escolha 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1"); //Chave pra diferenciar os botoes
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Escolha 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Escolha 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Escolha 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        //Informacoes do Jogador
        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel("HP: ");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);
    /*
        locationLabel = new JLabel("Current Location: ");
        locationLabel.setFont(normalFont);
        locationLabel.setForeground(Color.white);
        playerPanel.add(locationLabel);

        locationLabelName = new JLabel();
        locationLabelName.setFont(normalFont);
        locationLabelName.setForeground(Color.white);
        playerPanel.add(locationLabelName);
        */
        townGate();

    }

    public void playerSetup(){
        weaponLabelName.setText(player.weapon);
        hpLabelNumber.setText("" + player.Hp);
        //locationLabelName.setText(location);

    }

    public void townGate(){
        playerSetup();
        location = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing " +
                "in front of you. \n\nWhat do you do?");

        choice1.setText("Talk to the Guard");
        choice2.setText("Attack the Guard");
        choice3.setText("Intimidate the Guard");
        choice4.setText("Leave");
    }

    public void crossRoad(){
        playerSetup();
        location = "crossRoad";
        mainTextArea.setText("You turn back at a crossRoad. \nThe Tonw is at south  " +
               "\n\nWhat do you do?");

        choice1.setText("Go north");
        choice2.setText("Go south");
        choice3.setText("Go east");
        choice4.setText("go west");
    }

    public void riverSiteCampfire(){ //east
        playerSetup();
        location = "riverSiteCampfire";
        mainTextArea.setText("There is a river with a campfire. \nYou drink the water" +
                " and rest at the campfire \n\n You HP is full recovered");

        player.setHp(15);

        choice1.setText("Go back");
        choice2.setText("Upgrade Levels");
        choice3.setText("Change Equipaments");
        choice4.setText("See Stats");
    }

    public void goblinWest(){ //west
        playerSetup();
        if(!tinyGoblinDefeat) {
            location = "tinyGoblinSite";
            mainTextArea.setText("You walk a little bit and enconter a tiny goblin scream into you" +
                    "\nYou can see a sword blocked by the goblin \n\nTime to battle!");
            choice1.setText("Attack");
            choice2.setText("Use Item");
            choice3.setText("");
            choice4.setText("");
        }
    }

}

