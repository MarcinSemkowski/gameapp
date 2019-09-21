package pl.semkowski.pikachugame.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.semkowski.pikachugame.Player.PasswordHash;
import pl.semkowski.pikachugame.Player.Player;
import pl.semkowski.pikachugame.repositories.PlayerRepository;

import javax.transaction.Transactional;
@Component
public class PlayerBootstrap  {

   private  final  PlayerRepository playerRepository;


    public PlayerBootstrap(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


}
