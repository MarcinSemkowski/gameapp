package pl.semkowski.pikachugame.Database;

public enum Database_tables {

PLAYERS("p_id","p_nick","p_email","p_password","pokemon_id");




private final String tablePlayers;
private  final String id;
private  final String nick;
private final String  email;
private final String password;
private final String pokemonId;

private final String level;



Database_tables(String id, String nick, String email, String password, String pokemonId) {
        this.id = id;
        this.nick = nick;
        this.email = email;
        this.password = password;
        this.pokemonId = pokemonId;
        this.level = "pokemon_level";
        this.tablePlayers = "players";

    }



    public String getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public String getLevel() {
        return level;
    }

    public String getTablePlayers() {
        return tablePlayers;
    }
}
