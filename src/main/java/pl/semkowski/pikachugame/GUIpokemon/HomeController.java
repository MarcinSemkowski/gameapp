package pl.semkowski.pikachugame.GUIpokemon;

import org.atmosphere.inject.annotation.RequestScoped;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.domain.pokemon.ElectricPokemon;

@Controller
@RequestMapping("/home")
public class HomeController {
   private ElectricPokemon pikachu;

    @GetMapping("/room")
    public String home(Model model){
     model.addAttribute("name",pikachu.getName());
        return "main";
 }

 @EventListener(ApplicationReadyEvent.class)
    public void init(){
     this.pikachu = new ElectricPokemon("Pikachu");
 }

}
