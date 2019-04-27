package pl.semkowski.pikachugame.domain;

public abstract class Pokemon {
    private String name;
    private int hitPoints;
   // private int stamina;
    private int level;
    private int demage;
    private int energy;
    private int defense;
   // private boolean hunger;

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

    protected abstract int attack(int choice);

    protected abstract int defense(int damage);

    protected abstract void levelUP();
}
