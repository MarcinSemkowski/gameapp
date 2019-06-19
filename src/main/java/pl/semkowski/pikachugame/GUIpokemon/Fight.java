package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.semkowski.pikachugame.domain.Pokemon;

public class Fight {
    private Pokemon player1;
    private Pokemon player2;


    public Fight(Pokemon player1, Pokemon player2) {
        this.player1 = player1;
        this.player2 = player2;
    }



    public String fight(int id, int playerId) {

          String message = "";
        if (playerId == 1) {
            switch (id) {
                case 1:
                    player1.attack(player2);

                    break;
                case 2:
                      player1.defense();

                      break;
                case 3:
                        if(player1.skillOne(player2)){
                            player1.skillOne(player2);
                        }else{
                            message = "You dont have energy !!! Your turn  lost";
                        }

                    break;
                case 4:
                    if(player1.skillTwo(player2)){
                        player1.skillTwo(player2);
                    }else{
                        message = "You dont have energy !!! Your turn  lost";
                    }
                    break;

                case 5:
                    if(player1.skillSpecial(player2)){
                        player1.skillSpecial(player2);
                    }else{
                        message = "You dont have energy !!! Your turn  lost";
                    }
                    break;
            }
        } else if (playerId == 2) {
            switch (id) {
                case 1:
                   player2.attack(player1);
                    break;
                case 2:
                     player2.defense();
                     break;
                case 3:
                     boolean isSkillUse = player2.skillOne(player1);

                    if(!isSkillUse){
                        message = "You dont have energy !!! Your turn  lost";
                    }

                    break;
                case 4:
                    if(player2.skillTwo(player1)){
                        player2.skillTwo(player1);
                    }else{
                        message = "You dont have energy !!! Your turn  lost";
                    }
                    break;
                case 5:
                    if(player2.skillSpecial(player1)){
                        player2.skillSpecial(player1);
                    }else{
                        message = "You dont have energy !!! Your turn  lost";
                    }
            }
        }
       return message;
    }




    private void skillTwoMessage( Pokemon friendly, Pokemon enemy){

    }
    private void skillSpecialMesage(Pokemon friendly, Pokemon enemy){

    }





}
