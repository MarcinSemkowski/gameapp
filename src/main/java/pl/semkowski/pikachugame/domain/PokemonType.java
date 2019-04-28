package pl.semkowski.pikachugame.domain;

public enum PokemonType {
    Smoochum("Smoochum",
            100,
            1,
            10,
            100,
            10,
            "../img/enemy.png"
            ,"ICE"),
    Sandshrew("Sandshrew"
            ,100
            ,1,
            10,
            100,
            10,
            "../img/sandshrew.png"
            ,"ICE");

    private String name;
    private int hitPoints;
    // private int stamina;
    private int level;
    private int demage;
    private int energy;
    private int defense;
    private String photo;
    private String type;

    PokemonType(String name, int hitPoints, int level, int demage, int energy, int defense, String photo,String type ) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.level = level;
        this.demage = demage;
        this.energy = energy;
        this.defense = defense;
        this.photo = photo;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getLevel() {
        return level;
    }

    public int getDemage() {
        return demage;
    }

    public int getEnergy() {
        return energy;
    }

    public int getDefense() {
        return defense;
    }

    public String getPhoto() {
        return photo;
    }
}
