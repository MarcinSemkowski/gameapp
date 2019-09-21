package pl.semkowski.pikachugame.Player;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Column(name = "username")
    private String userName;
    @Column(name = "password")
     private String password;

     @Column(name = "role")
    private final String role = "ROLE_PLAYER";

    @Column(name = "money")
     private long money = 10;
     @Column(name = "pokemon_id")
    private int pokemon = 1;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled = true;


    public Player() {

    }

    public Player(String name, String email, String password) {
        this.userName = name;
        this.money = 0;
        this.pokemon = 1;
        this.email = email;
        this.enabled = true;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
