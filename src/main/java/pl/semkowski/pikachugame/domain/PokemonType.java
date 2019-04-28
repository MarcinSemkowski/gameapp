package pl.semkowski.pikachugame.domain;

public enum PokemonType {
    Jynx("Jynx",100,1,10,100,10,"photo");
    private String name;
    private int hitPoints;
    // private int stamina;
    private int level;
    private int demage;
    private int energy;
    private int defense;
    private String photo;

    PokemonType(String name, int hitPoints, int level, int demage, int energy, int defense, String photo) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.level = level;
        this.demage = demage;
        this.energy = energy;
        this.defense = defense;
        this.photo = photo;
    }


}
