package pl.semkowski.pikachugame.converters;

import org.aspectj.apache.bcel.util.Play;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.semkowski.pikachugame.Player.Player;
import pl.semkowski.pikachugame.commands.PlayerCommand;
@Component
public class PlayerToPlayerCommand implements Converter<Player, PlayerCommand> {


    @Override
    public PlayerCommand convert(Player source) {
        if(source == null){
            return null;
        }

        final PlayerCommand playerCommand = new PlayerCommand();
        playerCommand.setId(source.getId());
        playerCommand.setUserName(source.getUserName());
        playerCommand.setPokemon(source.getPokemon());
        playerCommand.setEmail(source.getEmail());
        playerCommand.setMoney(source.getMoney());

        return playerCommand;
    }
}
