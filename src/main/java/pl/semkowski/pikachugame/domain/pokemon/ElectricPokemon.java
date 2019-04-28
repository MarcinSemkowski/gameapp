package pl.semkowski.pikachugame.domain.pokemon;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Electric;

public class ElectricPokemon extends Pokemon implements Electric {

    public ElectricPokemon(String name) {
        super(name,
                10,
                100,
                "../img/pikachu.jpg");
    }





    @Override
    protected void levelUP() {
        setDemage(getDemage() + 5);
        setLevel(getLevel()+ 1);
        setDefense(getDefense()+ 5);
        setEnergy(getEnergy() + 5);
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

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void menu(int choice, int attackChoice, int enemyAttack) {
        super.menu(choice, attackChoice, enemyAttack);
        switch (choice){
            case 3:
                boltStrike(getLevel());
                break;
            case 4:
                charge(getLevel());
                break;
            case 5:
                electricTerrain(getLevel());
                break;
            case 6:
                discharge(getLevel());
                break;
        }
    }
}
