package pl.semkowski.pikachugame.Database;

public enum Database_tables {

PLAYERS(),
    AUTHORITIES();








private final String PLAYERS_tablePlayers;
private  final String PLAYERS_userName;
private final String PLAYERS_enabled;
private final String  PLAYERS_email;
private final String PLAYERS_password;
private final String PLAYERS_pokemonId;


private final String AUTHORITIES_table_authorities;
private final String AUTHORITIES_userName;
private final String AUTHORITIES_authority;




Database_tables(){
        this.PLAYERS_userName = "username" ;
        this.PLAYERS_email = "email";
        this.PLAYERS_password = "password";
        this.PLAYERS_pokemonId = "pokemon_id";
        this.PLAYERS_enabled = "enabled";
        this.PLAYERS_tablePlayers = "users";
        this.AUTHORITIES_table_authorities = "authorities";
        this.AUTHORITIES_userName = "username";
        this.AUTHORITIES_authority = "authority";
    }


    public String getPLAYERS_tablePlayers() {
        return PLAYERS_tablePlayers;
    }

    public String getPLAYERS_userName() {
        return PLAYERS_userName;
    }

    public String getPLAYERS_enabled() {
        return PLAYERS_enabled;
    }

    public String getPLAYERS_email() {
        return PLAYERS_email;
    }

    public String getPLAYERS_password() {
        return PLAYERS_password;
    }

    public String getPLAYERS_pokemonId() {
        return PLAYERS_pokemonId;
    }

    public String getAUTHORITIES_userName() {
        return AUTHORITIES_userName;
    }

    public String getAUTHORITIES_authority() {
        return AUTHORITIES_authority;
    }

    public String getAUTHORITIES_table_authorities() {
        return AUTHORITIES_table_authorities;
    }
}
