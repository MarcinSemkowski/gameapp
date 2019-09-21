package pl.semkowski.pikachugame.Player;

import org.apache.commons.codec.digest.DigestUtils;

public  class PasswordHash {

    public static String hash(String pass){
        return DigestUtils.sha256Hex(pass);
    }


}