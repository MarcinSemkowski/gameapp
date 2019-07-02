package pl.semkowski.pikachugame.Player;


public class Player {

    private long id;
    private String userName;
    private long money;
    private int pokemon;
    private String email;
    private boolean enabled;
    private String role;


    public Player(String name, long money, int pokemon, String email) {
        this.userName = name;
        this.money = money;
        this.pokemon = pokemon;
        this.email = email;
        this.enabled = true;
        this.role = "ROLE_PLAYER";

    }

    public long getId() {
        return id;
    }
    public boolean isEnabled() {
        return enabled;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


    public String getRole() {
        return role;
    }
}
