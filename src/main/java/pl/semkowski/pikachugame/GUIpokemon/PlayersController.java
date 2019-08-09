package pl.semkowski.pikachugame.GUIpokemon;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class PlayersController {





   @GetMapping("/login")
   public String login(){
       return "login";
   }


    @PostMapping("sign_up")
    public String SignUp(){
        return "";
    }








    @GetMapping("/sign_in")
    public String SignIn() {
        return "sign_in";
    }


    @GetMapping("/home")
    public String main( ) {


        return "Player/main";
    }



}
