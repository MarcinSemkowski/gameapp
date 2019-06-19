package pl.semkowski.pikachugame.Database;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseSourceTest {

    @Test
    public void connect() {
     //given
       DatabaseSource databaseSource = new DatabaseSource();
       //when
        String con = "Connected";
        //then
        Assert.assertEquals(con,databaseSource.connect());
    }
}