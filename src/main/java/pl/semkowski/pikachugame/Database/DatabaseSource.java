package pl.semkowski.pikachugame.Database;

import pl.semkowski.pikachugame.domain.Player;

import java.sql.*;

public class DatabaseSource {

    private static final String DB_NAME = "game_app";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private static final String CONNNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;

    private static final String IS_PLAYER_EXIST = "SELECT * FROM " + Database_tables.PLAYERS.getTablePlayers() +
            " WHERE " + Database_tables.PLAYERS.getEmail() + " = ?";

    private static final String ADD_NEW_PLAYER_TO_DATABASE = "INSERT INTO "
            + Database_tables.PLAYERS.getTablePlayers() + "("
     + Database_tables.PLAYERS.getNick() + ","
            + Database_tables.PLAYERS.getEmail() + ","
            + Database_tables.PLAYERS.getPassword() + ","
            + Database_tables.PLAYERS.getPokemonId() + " ) " + "VALUES ( ?,?,?,? ";




 private PreparedStatement query;
 private ResultSet resultSet;




    public String connect(){
        try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD)) {
            return "Connected";
        }catch(SQLException e){
            e.getMessage();
            return e.getMessage();
        }

    }

    public boolean isPlayerInDatabase(String email){

      try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD)) {
           query = conn.prepareStatement(IS_PLAYER_EXIST);
           query.setString(1,email);
           resultSet = query.executeQuery();
           if(resultSet.next()){
               Player player = new Player(
                       resultSet.getString(Database_tables.PLAYERS.getNick()),
                       0,
                       2,
                       resultSet.getString(Database_tables.PLAYERS.getEmail()));
               System.out.println("Player exist ! = "+ player.getName() + " player Email = " + player.getEmail());
               return true;
           }
           else{
                Player player = new Player("Marcin",120,2,"test@gmail.com");

               return false;
           }

      }catch (SQLException e){
          e.getMessage();
      } finally {
          try {
              query.close();
          }catch (SQLException e){
              e.getMessage();
          }

      }


        return false;
    }


}
