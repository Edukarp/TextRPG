public class Player {

    private Game game;

    public int Hp = 15;
    public int nivelGeral = 1;
    public String weapon = "Kinfe";
    public int damage = 1;
    public String armor = "Leather Armor";


    public Player(Game game){this.game = game;}

    public void setHp(int hp) {
        Hp = hp;
    }

    public void setNivelGeral(int nivelGeral) {
        this.nivelGeral = nivelGeral;
    }

    public void setWeaponAndDamage(String weapon, int damage, int nivelGeral) {
        this.damage = damage+nivelGeral;
        this.weapon = weapon;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }
}
