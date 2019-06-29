package pl.semkowski.pikachugame.Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DatabaseSourceTest {

    private DatabaseSource databaseSource;

    @Before
    public void init(){

         databaseSource = new DatabaseSource();
    }


    @Test
    public void connect() {

       //when
        String con = "Connected";
        //then
        Assert.assertEquals(con,databaseSource.connect());
    }


    @Test
    public void isPlayerInDatabase_shouldReturnTrue(){
       //when
        String email = "test@gmail.com";
        //then
        Assert.assertTrue(databaseSource.isEmailInDatabase(email));
    }
    @Test
    public void addingNewPlayer_shouldReturnTrue(){
        //then
        Assert.assertTrue(databaseSource.addingNewPlayerToDatabase());
    }
}