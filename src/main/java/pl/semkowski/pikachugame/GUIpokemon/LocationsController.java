package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.domain.pokemon.IcePokemon;

import java.util.Random;

@Controller
@RequestMapping("/locations")
public class LocationsController {

    @GetMapping("/arena")
    public String arena(){
        return "arena";
    }

    @EventListener(ApplicationReadyEvent.class)
    public void create(){
        Pokemon samplePokemon = new IcePokemon("gsdg");



    }

}
