package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.semkowski.pikachugame.Database.DatabaseSource;

@Controller
public class PlayersController {

    DatabaseSource databaseSource = new DatabaseSource();


//todo: Ad Spring Security
//todo: Feature: (Lost your password?)

    @PostMapping("sign_up")
    public String SignUp(@RequestParam(value = "nick") String nick
            , @RequestParam(value = "email") String email
            , @RequestParam(value = "password") String password,
                         Model model) {
            if(databaseSource.isPlayerInDatabase(nick)){
               String error = "Już jest gracz o takim nicku !!!";
               model.addAttribute("error",error);
               return "Index";
            }


        return null;
    }


    @GetMapping("/sign_in")
    public String SignIn() {
        return null;
    }


}
