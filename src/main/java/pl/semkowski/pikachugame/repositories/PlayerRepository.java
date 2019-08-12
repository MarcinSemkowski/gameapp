package pl.semkowski.pikachugame.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.semkowski.pikachugame.Player.Player;

public interface PlayerRepository extends CrudRepository<Player,Long> {



}
