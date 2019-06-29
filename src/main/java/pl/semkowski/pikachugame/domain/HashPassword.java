package pl.semkowski.pikachugame.domain;

import org.apache.commons.codec.digest.DigestUtils;

public class HashPassword {

   public static String hash(String password){




       return DigestUtils.sha256Hex(password);
   }

}
