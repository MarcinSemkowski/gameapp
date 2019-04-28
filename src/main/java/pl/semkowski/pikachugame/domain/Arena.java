package pl.semkowski.pikachugame.domain;

import pl.semkowski.pikachugame.domain.pokemon.IcePokemon;

import java.util.Random;

public class Arena {
    private Pokemon samplePokemon;

    private static final RandomEnum<PokemonType> r = new RandomEnum<>(PokemonType.class);

    public void round() {
        while (samplePokemon.getHitPoints() <= 0 || r.random().getHitPoints() <= 0) {

        }
    }

    public Pokemon getEnemy(){
           PokemonType enemyPokemonType = r.random();
        Pokemon enemy = null;
           if(enemyPokemonType.getType()== "ICE"){
               enemy = new  IcePokemon(enemyPokemonType.getName());
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