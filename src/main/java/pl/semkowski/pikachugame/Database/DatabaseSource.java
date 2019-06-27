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
     + " " + Database_tables.PLAYERS.getNick() + ","
      + " " +   Database_tables.PLAYERS.getEmail() + ","
            + " " +  Database_tables.PLAYERS.getPassword() + ","
            + " " +  Database_tables.PLAYERS.getPokemonId() + ") " + "VALUES (?, ?, ?, ?)";




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

    public boolean isPlayerInDatabase(String data){
        this.email = data;
      try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD);
          PreparedStatement query = conn.prepareStatement(IS_PLAYER_EXIST)) {

           query.setString(1,email);
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


    public boolean addingNewPlayerToDatabase(){

        try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD);
                PreparedStatement query = conn.prepareStatement(ADD_NEW_PLAYER_TO_DATABASE)) {
            if(isPlayerInDatabase(this.email)){
                return false;
            } else{
                Player player = new Player("Marcin",120,2,"test@gmail.com");
                query.setString(1, player.getName());
                query.setString(2,player.getEmail());
                query.setString(3,"xcvbnm");
                query.setInt(4, 4);
                query.executeUpdate();
                System.out.println("New player added");
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }


}
