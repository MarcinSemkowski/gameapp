package pl.semkowski.pikachugame.GUIpokemon;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.semkowski.pikachugame.Database.DatabaseSource;
import pl.semkowski.pikachugame.Player.Player;

@Controller
public class PlayersController {

    DatabaseSource databaseSource = new DatabaseSource();



//todo: Feature: (Lost your password?)


   @GetMapping("/login")
   public String login(){
       return "login";
   }


    @PostMapping("sign_up")
    public String SignUp(@RequestParam(value = "nick") String nick
            , @RequestParam(value = "email") String email
            , @RequestParam(value = "password") String password,
                         Model model) {
            if(databaseSource.isEmailInDatabase(email)){
               String error = "Już jest gracz o takim emailu !!!";
               model.addAttribute("error",error);
               return "Index";
            }else if(databaseSource.isNickInDatabase(nick)){
                String error = "Już jest gracz o takim nicku !!!";
                model.addAttribute("error",error);
                return "Index";
            }else if((databaseSource.isEmailInDatabase(email)) && (databaseSource.isNickInDatabase(nick)) ){
                String error = "Już jest gracz o takim nicku i emailu  !!!";
                model.addAttribute("error",error);
                return "Index";
            }





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
