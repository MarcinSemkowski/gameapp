package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Electric;

public class ElectricPokemon extends Pokemon implements Electric {


    public ElectricPokemon(String name, int level, int demage, int energy) {
        super(name, level, demage);
        this.energy = energy;
    }

    private int energy;


    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    protected int attack() {
        return 0;
    }

    @Override
    protected void defense() {

    }

    @Override
    public int boltStrike(int level) {
        return 0;
    }

    @Override
    public int charge(int level) {
        return 0;
    }

    @Override
    public int electricTerrain(int level) {
        return 0;
    }

    @Override
    public int discharge(int level) {
        return 0;
    }
}
