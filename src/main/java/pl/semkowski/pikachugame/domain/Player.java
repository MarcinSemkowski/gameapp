package pl.semkowski.pikachugame.domain;

public class Player {

    private String name;
    private long money;
    private int pokemon;
    private String email;

    public Player(String name, long money, int pokemon,String email) {
        this.name = name;
        this.money = money;
        this.pokemon = pokemon;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getPokemon() {
        return pokemon;
    }

    public void setPokemon(int pokemon) {
        this.pokemon = pokemon;
    }
}
