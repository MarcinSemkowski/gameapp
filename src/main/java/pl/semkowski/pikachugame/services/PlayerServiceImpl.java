package pl.semkowski.pikachugame.services;

import org.springframework.stereotype.Service;
import pl.semkowski.pikachugame.Player.Player;
import pl.semkowski.pikachugame.commands.PlayerCommand;
import pl.semkowski.pikachugame.converters.PlayerCommandToPlayer;
import pl.semkowski.pikachugame.converters.PlayerToPlayerCommand;
import pl.semkowski.pikachugame.repositories.PlayerRepository;
@Service
public class PlayerServiceImpl implements PlayerService {

  private final  PlayerRepository playerRepository;
  private final   PlayerCommandToPlayer playerCommandToPlayer;
  private final   PlayerToPlayerCommand playerToPlayerCommand;


    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerCommandToPlayer playerCommandToPlayer, PlayerToPlayerCommand playerToPlayerCommand) {
        this.playerRepository = playerRepository;
        this.playerCommandToPlayer = playerCommandToPlayer;
        this.playerToPlayerCommand = playerToPlayerCommand;
    }

    @Override
    public PlayerCommand savePlayerCommand(PlayerCommand playerCommand) {
        Player demoPlayer = playerCommandToPlayer.convert(playerCommand);
        Player savedPlayer =  playerRepository.save(demoPlayer);
        return playerToPlayerCommand.convert(savedPlayer);
    }
}
