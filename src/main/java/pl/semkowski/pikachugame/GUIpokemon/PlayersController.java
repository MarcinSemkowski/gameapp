package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.semkowski.pikachugame.Database.DatabaseSource;
import pl.semkowski.pikachugame.domain.Player;

@Controller
public class PlayersController {

    DatabaseSource databaseSource = new DatabaseSource();


//todo: Ad Spring Security
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

        BCryptPasswordEncoder hashPass = new BCryptPasswordEncoder();

        Player player = new Player(nick,100,1,email);

         databaseSource.addingNewPlayerToDatabase(player,hashPass.encode(password));


        return null;
    }
    @GetMapping("/sign_in")
    public String SignIn() {
        return null;
    }


    @GetMapping("/home")
    public String main() {

        return "main";
    }


}
