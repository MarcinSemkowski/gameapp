package pl.semkowski.pikachugame.domain;

public abstract class Pokemon {
    private String name;
    private int hitPoints;
   // private int stamina;
    private int level;
    private int demage;
    private int energy;
    private int defense;
    private String photo;
   // private boolean hunger;
    private long experiance;

    public Pokemon(String name, int demage,int energy) {
        this.name = name;
        this.hitPoints = 100;
        this.level = 1;
        this.demage = demage;
        this.energy = energy;
    }

    protected int getDefense() {
        return defense;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getHitPoints() {
        return hitPoints;
    }

    protected void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    protected int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    protected int getDemage() {
        return demage;
    }

    protected void setDemage(int demage) {
        this.demage = demage;
    }

    protected int getEnergy() {
        return energy;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }


    // protected abstract void eat(String food);

   // protected abstract int sleep(int time);

    protected  int attack(int choice,int level){
        int damage=0;
        switch(choice){
            case 1:
                System.out.println("Attack with defense ,damage =5, energy -7");


                setEnergy(getEnergy() - 5);

                break;
            case 2:
                System.out.println("Pure attack , damage = 10 ,");

                setEnergy(getEnergy() - 5);
                damage = 10;
                break;
            default:

                break;
        }
        return damage;
    }

    protected  int defense(int damage){
        System.out.println("Used defense skills  ");
        this.energy += 10;
        return damage - getDefense();
    }

    protected  void levelUP(){
        setDemage(getDemage() + 5);
        setLevel(getLevel()+ 1);
        setDefense(getDefense()+ 5);
        setEnergy(getEnergy() + 5);
    }

    public void menu(int choice,int attackChoice,int enemyAttack){
        switch (choice){
            case 1:
                attack(attackChoice,this.level);
                break;
            case 2:
                defense(enemyAttack);
                break;

        }
    }
}
