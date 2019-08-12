package pl.semkowski.pikachugame.commands;


public class PlayerCommand {

    private Long id;

    private String userName;

    private String password;

    private String role;


    private long money;

    private int pokemon;

    private String email;

    private boolean enabled;





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

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

}
