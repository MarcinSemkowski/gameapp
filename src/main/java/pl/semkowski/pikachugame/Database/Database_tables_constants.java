package pl.semkowski.pikachugame.Database;

public enum Database_tables_constants {

PLAYERS("p_id","p_nick","p_email","p_password","pokemon_id"),

    POKEMONS("pokemon_level");



private  final String id;
private  final String nick;
private final String  email;
private final String password;
private final String pokemonId;

private final String level;


    Database_tables_constants(String id, String nick, String email, String password, String pokemonId) {
        this.id = id;
        this.nick = nick;
        this.email = email;
        this.password = password;
        this.pokemonId = pokemonId;
        this.level = "pokemon_level";
    }


    Database_tables_constants(String level) {
        this.level = level;
        this.id = "p_id";
        this.nick = "p_nick";
        this.email = "p_email";
        this.password = "p_password";
        this.pokemonId = "pokemon_id";
    }
}
