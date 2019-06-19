package pl.semkowski.pikachugame.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseSource {

  private   static final String DB_NAME = "game_app";
  private static final String USER = "root";
    private static final String PASSWORD = "";

  private static final String CONNNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;


    public String connect(){
        try(Connection conn = DriverManager.getConnection(CONNNECTION_STRING,USER,PASSWORD)) {
            return "Connected";
        }catch(SQLException e){
            e.getMessage();
            return e.getMessage();
        }

    }


}
