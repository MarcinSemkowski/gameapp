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

    public Pokemon(String name, int demage,int energy,String photo) {
        this.name = name;
        this.hitPoints = 100;
        this.level = 1;
        this.demage = demage;
        this.energy = energy;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    protected int getDefense() {
        return defense;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if(hitPoints < 0)
        this.hitPoints = 0;
        else
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

    public int getEnergy() {
        return energy;
    }

    protected void setEnergy(int energy) {
        this.energy = energy;
    }


    // protected abstract void eat(String food);

   // protected abstract int sleep(int time);

    public int attack(){
        System.out.println("Attack !!!!!");

        return demage;
    }

    public int defense(int damage){
        int block = damage - getDefense();
         System.out.println("Block =  " + block);
        return damage - getDefense();
    }
    public void defense(){
        System.out.println("Used defense skills  ");
        this.energy += 10;
    }

    protected  void levelUP(){
        setDemage(getDemage() + 5);
        setLevel(getLevel()+ 1);
        setDefense(getDefense()+ 5);
        setEnergy(getEnergy() + 5);
    }


    public abstract int skillOne();
    public abstract int skillTwo();
    public abstract int skillThree();
    public abstract int skillSpecial();
    public abstract String getSkillOneName();
    public abstract String getSkillTwoName();
    public abstract String getSkillThreeName();
    public abstract String getSkillSpecialName();



    }

