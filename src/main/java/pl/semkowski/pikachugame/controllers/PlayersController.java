package pl.semkowski.pikachugame.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.semkowski.pikachugame.commands.PlayerCommand;
import pl.semkowski.pikachugame.services.PlayerService;


@Controller
public class PlayersController {

      PlayerService playerService;

    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/login")
   public String login(){
       return "login";
   }


    @RequestMapping("/")
    public String SignUp(Model model){
        model.addAttribute("player",new PlayerCommand());
        return "index";
    }
       @RequestMapping("/add")
      public String savePlayer(@ModelAttribute PlayerCommand playerCommand){
         PlayerCommand savePlayer = playerService.savePlayerCommand(playerCommand);
         return "redirect:/sign_in";
      }

      @RequestMapping("/sign_in")
    public String SignIn() {

       return "sign_in";

    }


    @RequestMapping ("/home")
    public String main( ) {


        return "Player/main";
    }



}
