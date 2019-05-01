package pl.semkowski.pikachugame.GUIpokemon;

import org.atmosphere.inject.annotation.RequestScoped;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.domain.PokemonType;
import pl.semkowski.pikachugame.domain.pokemon.ElectricPokemon;
import pl.semkowski.pikachugame.domain.pokemon.IcePokemon;

import java.util.Random;

@Controller
@RequestMapping("/home")
public class HomeController {
   private static Pokemon player1 = new ElectricPokemon("Pikachu");

   private static Pokemon player2 = new IcePokemon("Sandschrew");

    private static final RandomEnum<PokemonType> r = new RandomEnum<>(PokemonType.class);
    @GetMapping("/room")
    public String home(Model model){
     model.addAttribute("name",player1.getName());
        return "main";
 }

// @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//     this.pikachu
// }


    public static Pokemon getPlayer1() {
        return player1;
    }

    public static Pokemon getPlayer2() {
        return player2;
    }

    public static IcePokemon getEnemy(){
        PokemonType enemyPokemonType = r.random();
        IcePokemon enemy = null;
        if(enemyPokemonType.getType()== "ICE"){
            enemy = new IcePokemon(enemyPokemonType.getName());
        }
        return enemy;
    }


    private static class RandomEnum<E extends Enum<E>> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public  E random() {
            return values[RND.nextInt(values.length)];
        }
    }



}
