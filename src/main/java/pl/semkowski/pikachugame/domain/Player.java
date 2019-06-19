package pl.semkowski.pikachugame.domain;

public class Player {

    private String name;
    private long money;
    private Pokemon pokemon;

    public Player(String name, long money, Pokemon pokemon) {
        this.name = name;
        this.money = money;
        this.pokemon = pokemon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}
