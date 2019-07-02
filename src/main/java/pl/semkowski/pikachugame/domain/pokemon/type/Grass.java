package pl.semkowski.pikachugame.domain.pokemon.type;

import pl.semkowski.pikachugame.domain.Pokemon;

public interface Grass {
    boolean Absorb(Pokemon enemy);
    boolean BulletSeed(Pokemon enemy);
    boolean EnergyBall(Pokemon enemy);

}
