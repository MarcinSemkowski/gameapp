package pl.semkowski.pikachugame.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.semkowski.pikachugame.commands.PlayerCommand;


@Controller
public class PlayersController {





   @GetMapping("/login")
   public String login(){
       return "login";
   }


    @RequestMapping("/")
    public String SignUp(Model model){
        model.addAttribute("player",new PlayerCommand());
        return "index";
    }









    public String SignIn() {

       return "sign_in";

    }


    @GetMapping("/home")
    public String main( ) {


        return "Player/main";
    }



}
