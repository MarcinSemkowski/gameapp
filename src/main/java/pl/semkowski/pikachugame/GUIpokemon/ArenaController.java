package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.semkowski.pikachugame.domain.Pokemon;

@Controller
public class ArenaController {

    private boolean defensePlayer1 = false;
    private boolean defensePlayer2 = false;
    private boolean player1Won = false;
    private boolean isPlayerChoose1 = true;


    private static Pokemon player1 = HomeController.getPlayer1();

   private static Pokemon player2 = HomeController.getPlayer2();

    public static Pokemon getPlayer1() {
        return player1;
    }

    public static Pokemon getPlayer2() {
        return player2;
    }

    @GetMapping("/arena")
    public String arena (Model model) {


        model.addAttribute("player1",player1);

       model.addAttribute("player2",player2);
        return "arena";
    }

    @PostMapping("/arena")
    public String round(@RequestParam(value = "id") int id,
                        @RequestParam(value = "playerId") int playerId,
                        @RequestParam(value = "chooseId",defaultValue = "1") int chooseId
            ,Model model){




         if(player2.getHitPoints() == 0){
            player1Won = true;
             model.addAttribute("player1Won", player1);
             model.addAttribute("playerWon",player1Won);
             return "victory";
         }
         else if(player1.getHitPoints() == 0){
             player1Won = false;
             model.addAttribute("player2Won", player2);
             model.addAttribute("playerWon",player1Won);
             return "victory";
         }
         else {
             fight(id, playerId);

                 String warning = "Wait your opponnent turn";


             if(chooseId == 1){
                 isPlayerChoose1 = true;

             }
             else if(chooseId == 2){
                 isPlayerChoose1 = false;

             }


             model.addAttribute("player2", player2);

             model.addAttribute("player1", player1);

             model.addAttribute("isPlayerChoose_1" ,isPlayerChoose1);
             model.addAttribute("warning",warning);
             String song ="soundsample/battle.mp3";
             model.addAttribute("song",song);
             return "arena";
         }
    }








    public void fight(int id,int playerId){






         if(playerId == 1) {
             switch (id) {
                 case 1:
                     if(defensePlayer2){
                     player2.setHitPoints(player2.getHitPoints() - player2.defense(player1.attack()));
                     defensePlayer2 = false;
                     }
                     else{
                        player2.setHitPoints(player2.getHitPoints() - player1.attack());
                     }
                     break;
                 case 2:
                     this.defensePlayer1 = true;
                     player1.defense();
                     break;
                 case 3:
                     if(defensePlayer2){
                         player2.setHitPoints(player2.getHitPoints() - player2.defense(player1.skillOne()));
                         defensePlayer2 = false;
                     }
                     else{
                         player2.setHitPoints(player2.getHitPoints() - player1.skillOne());
                     }
                     break;
                 case 4:
                     if(defensePlayer2){
                         player2.setHitPoints(player2.getHitPoints() - player2.defense(player1.skillTwo()));
                         defensePlayer2 = false;
                     }
                     else{
                         player2.setHitPoints(player2.getHitPoints() - player1.skillTwo());
                     }
                     break;
                 case 5:
                     if(defensePlayer2){
                         player2.setHitPoints(player2.getHitPoints() - player2.defense(player1.skillThree()));
                         defensePlayer2 = false;
                     }
                     else{
                         player2.setHitPoints(player2.getHitPoints() - player1.skillThree());
                     }
                    break;
                 case 6:
                     if(defensePlayer2){
                         player2.setHitPoints(player2.getHitPoints() - player2.defense(player1.skillSpecial()));
                         defensePlayer2 = false;
                     }
                     else{
                         player2.setHitPoints(player2.getHitPoints() - player1.skillSpecial());
                     }
                     break;
             }
         }
         else if(playerId == 2){
            switch(id){
                case 1:
                    if(defensePlayer1){
                        player1.setHitPoints(player1.getHitPoints() - player1.defense(player2.attack()));
                        defensePlayer2 = false;
                    }
                    else{
                        player1.setHitPoints(player1.getHitPoints() - player2.attack());
                    }
                    break;
                case 2:
                    this.defensePlayer2 = true;
                    player2.defense();
                    break;
                case 3:
                    if(defensePlayer1){
                        player1.setHitPoints(player1.getHitPoints() - player1.defense(player2.skillOne()));
                        defensePlayer1 = false;
                    }
                    else{
                        player1.setHitPoints(player1.getHitPoints() - player2.skillOne());
                    }
                    break;
                case 4:
                    if(defensePlayer1){
                        player1.setHitPoints(player1.getHitPoints() - player1.defense(player2.skillTwo()));
                        defensePlayer1 = false;
                    }
                    else{
                        player1.setHitPoints(player1.getHitPoints() - player2.skillTwo());
                    }
                    break;
                case 5:
                    if(defensePlayer1){
                        player1.setHitPoints(player1.getHitPoints() - player1.defense(player2.skillThree()));
                        defensePlayer1 = false;
                    }
                    else{
                        player1.setHitPoints(player1.getHitPoints() - player2.skillThree());
                    }
                    break;
                case 6:
                    if(defensePlayer1){
                        player1.setHitPoints(player1.getHitPoints() - player1.defense(player2.skillSpecial()));
                        defensePlayer1 = false;
                    }
                    else{
                        player1.setHitPoints(player1.getHitPoints() - player2.skillSpecial());
                    }
                    break;
            }
         }
    }



//    @EventListener(ApplicationReadyEvent.class)
//    public void create(){
//        Pokemon samplePokemon = new IcePokemon("gsdg");
//
//
//
//    }

}
