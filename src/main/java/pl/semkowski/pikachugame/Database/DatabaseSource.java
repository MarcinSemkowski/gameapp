package pl.semkowski.pikachugame.Database;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.semkowski.pikachugame.Player.Player;

import java.sql.*;

public class DatabaseSource {

    private static final String DB_NAME = "game_app";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private static final String CONNNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;

    private static final String IS_PLAYER_EMAIL = "SELECT * FROM " + Database_tables.PLAYERS.getPLAYERS_tablePlayers()+
            " WHERE " + Database_tables.PLAYERS.getPLAYERS_email() + " = ? ";

    private static final String IS_PLAYER_NICK = "SELECT * FROM " + Database_tables.PLAYERS.getPLAYERS_tablePlayers() +
            " WHERE " + Database_tables.PLAYERS.getPLAYERS_userName() + " = ? ";

    private static final String ADD_NEW_PLAYER_TO_DATABASE = "INSERT INTO " +
            Database_tables.PLAYERS.getPLAYERS_tablePlayers() +
            "(" +
            Database_tables.PLAYERS.getPLAYERS_userName() + ", " +
            Database_tables.PLAYERS.getPLAYERS_password() + ", " +
            Database_tables.PLAYERS.getPLAYERS_enabled() + ", " +
            Database_tables.PLAYERS.getPLAYERS_pokemonId() + ", " +
            Database_tables.PLAYERS.getPLAYERS_email() +
            ") VALUES (?, ?, ?, ?, ?)";

    private static final  String INSERT_INTO_AUTHORITIES = "INSERT INTO " +
            Database_tables.PLAYERS.getAUTHORITIES_table_authorities() +
            "(" +
            Database_tables.PLAYERS.getAUTHORITIES_userName() + ", " +
            Database_tables.PLAYERS.getAUTHORITIES_authority() +
            ") VALUES (?, ?)";





 private PreparedStatement query;
 private ResultSet resultSet;
  private String email;




    public String connect(){
        try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD)) {
            return "Connected";
        }catch(SQLException e){
            e.getMessage();
            return e.getMessage();
        }

    }

    public boolean isEmailInDatabase(String email){
        this.email = email;
      try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD);
          PreparedStatement query = conn.prepareStatement(IS_PLAYER_EMAIL)) {

           query.setString(1, this.email);
           resultSet = query.executeQuery();
           if(resultSet.next()){
               return true;
           }
           else{
               return false;
           }

      }catch (SQLException e){
          e.getMessage();

      }
      return false;
    }

    public boolean isNickInDatabase(String nick){

        try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD);
            PreparedStatement query = conn.prepareStatement(IS_PLAYER_NICK)) {

            query.setString(1, nick);
            resultSet = query.executeQuery();
            if(resultSet.next()){
                return true;
            }
            else{
                return false;
            }

        }catch (SQLException e){
            e.getMessage();

        }
        return false;
    }






    public boolean addingNewPlayerToDatabase(Player player,String password){

        try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD);
                PreparedStatement queryPlayer = conn.prepareStatement(ADD_NEW_PLAYER_TO_DATABASE);
                PreparedStatement queryAuthorities = conn.prepareStatement(INSERT_INTO_AUTHORITIES)
               ) {
              BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                queryPlayer.setString(1, player.getUserName());
                queryPlayer.setString(2, passwordEncoder.encode(password) );
                queryPlayer.setBoolean(3,player.isEnabled());
                queryPlayer.setInt(4, 0);
                queryPlayer.setString(5,player.getEmail());

                queryPlayer.executeUpdate();
                queryAuthorities.setString(1,player.getUserName());
                queryAuthorities.setString(2,player.getRole());
                //todo : improve INSERT use(hibernate or something else )
                queryAuthorities.executeUpdate();
                System.out.println("New player added");
                return true;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }


}
