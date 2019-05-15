package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.domain.pokemon.ElectricPokemon;
import pl.semkowski.pikachugame.domain.pokemon.FlamePokemon;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArenaController {


    private boolean player1Won = false;

    private boolean isPlayerChoose1 = true;

    private List<Pokemon> pokemonList = new ArrayList<>();

    private Pokemon player1 = (Pokemon) init().get(0);

    private Pokemon player2 = (Pokemon) init().get(1);

    public Fight round = new Fight(player1, player2);


    @GetMapping("/round")
    public String arena(Model model) {


        model.addAttribute("player1", player1);

        model.addAttribute("player2", player2);
        return "arena";
    }


    @PostMapping("/fight")
    public String round(@RequestParam(value = "id") int id,
                        @RequestParam(value = "playerId") int playerId,
                        @RequestParam(value = "chooseId", defaultValue = "1") int chooseId
            , Model model) {


        String error = round.fight(id, playerId);
        if (!error.isEmpty()) {
            model.addAttribute("error", error);
        }


        if (player2.getHitPoints() == 0) {
            player1Won = true;
            model.addAttribute("player1Won", player1);
            model.addAttribute("playerWon", player1Won);
            return "victory";
        }
        if (player1.getHitPoints() == 0) {
            player1Won = false;
            model.addAttribute("player2Won", player2);
            model.addAttribute("playerWon", player1Won);
            return "victory";
        }


        model.addAttribute("content", "5; http://localhost:8080/arena?chooseId=" + chooseId);
        model.addAttribute("player1", player1);
        model.addAttribute("player2", player2);
        model.addAttribute("playerId", playerId);
        model.addAttribute("id", id);
        model.addAttribute("round", round);
        return "fight";


    }

    @RequestMapping(value = "arena", method = RequestMethod.GET)
    public String arena(@RequestParam("chooseId") int chooseId, Model model) {
        if (chooseId == 1) {
            isPlayerChoose1 = true;

        } else if (chooseId == 2) {
            isPlayerChoose1 = false;

        }

        String warning = "Wait your opponnent turn";
        model.addAttribute("player2", player2);

        model.addAttribute("player1", player1);

        model.addAttribute("isPlayerChoose_1", isPlayerChoose1);
        model.addAttribute("warning", warning);
        return "arena";
    }


    @EventListener(ContextRefreshedEvent.class)
    public List init() {
        Pokemon pikachu = new ElectricPokemon("Pikachu",
                "img/pikachu/photo.jpg",
                "img/pikachu/attack.gif", "img/pikachu/skillone.gif",
                "img/pikachu/skilltwo.gif",
                "img/pikachu/special.gif",
                "img/pikachu/def.gif", "img/pikachu/damage.gif",
                "img/pikachu/reaction.gif");

        Pokemon charmander = new FlamePokemon("Charmander"
                , "img/charmander/photo.png",
                "img/charmander/attack.gif", "img/charmander/skillone.gif",
                "img/charmander/skilltwo.gif",
                "img/charmander/special.gif",
                "img/charmander/defense.gif", "img/charmander/damage.gif",
                "img/charmander/reaction.gif");
        pokemonList.add(pikachu);
        pokemonList.add(charmander);
        return pokemonList;
    }


}
