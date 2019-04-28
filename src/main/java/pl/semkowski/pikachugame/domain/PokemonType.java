package pl.semkowski.pikachugame.domain;

public enum PokemonType {
    Smoochum("Smoochum",100,1,10,100,10,
            "<img class=\"img\" src=\"../img/enemy.png\" height=\"150\" width=\"150\">");
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
