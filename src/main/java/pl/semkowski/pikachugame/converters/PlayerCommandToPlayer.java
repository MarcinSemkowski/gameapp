package pl.semkowski.pikachugame.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.semkowski.pikachugame.Player.Player;
import pl.semkowski.pikachugame.commands.PlayerCommand;


import java.lang.annotation.Annotation;
@Component
public class PlayerCommandToPlayer implements Converter<PlayerCommand,Player> {


    @Override
    public synchronized Player convert(PlayerCommand source) {
         if(source == null){
           return null;
         }

        final Player player = new Player();
         player.setId(source.getId());
         player.setUserName(source.getUserName());
         player.setPokemon(source.getPokemon());
         player.setEmail(source.getEmail());
         player.setMoney(source.getMoney());

        return player;
    }
}
