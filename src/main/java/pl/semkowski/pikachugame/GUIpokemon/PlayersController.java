package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayersController {

//todo: Ad Spring Security
@PostMapping("/sign_up")
   public String SignUp(){

    return null;
}


@PostMapping("/sign_in")
    public String SignIn(){
    return null;
}


}
