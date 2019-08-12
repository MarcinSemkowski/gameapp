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
    private String role;

    @Column(name = "money")
     private long money;
     @Column(name = "pokemon_id")
    private int pokemon;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;


    public Player() {

    }

    public Player(String name, long money, int pokemon, String email, String password) {
        this.userName = name;
        this.money = money;
        this.pokemon = pokemon;
        this.email = email;
        this.enabled = true;
        this.password = password;
        role = "ROLE_PLAYER";
    }

    public long getId() {
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
}
