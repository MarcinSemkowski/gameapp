package pl.semkowski.pikachugame.domain;

public abstract class Pokemon {
    private String name;
    private int hitPoints;
   // private int stamina;
    private int level;
    private int demage;
   // private int defense;
   // private boolean hunger;

    public Pokemon(String name, int level, int demage) {
        this.name = name;
        this.hitPoints = 100;
        this.level = level;
        this.demage = demage;
    }


    // protected abstract void eat(String food);

   // protected abstract int sleep(int time);

    protected abstract int attack();

    protected abstract void defense();


}
