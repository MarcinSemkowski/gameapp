package pl.semkowski.pikachugame.domain.pokemon.type;

import pl.semkowski.pikachugame.domain.Pokemon;

public interface Electric {

    boolean boltStrike(Pokemon enemy);

    boolean charge(Pokemon enemy);

    boolean discharge(Pokemon enemy);

}
