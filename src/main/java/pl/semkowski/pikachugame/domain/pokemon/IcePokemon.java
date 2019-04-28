package pl.semkowski.pikachugame.domain.pokemon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Ice;

public class IcePokemon extends Pokemon implements Ice {


    public IcePokemon(String name) {
        super(name,
                10,
                100,
                "<img class=\"img\" src=\"../img/enemy.png\" height=\"150\" width=\"150\">");
    }

    @Override
    protected String getName() {
        return super.getName();
    }

    @Override
    protected int attack(int choice, int level) {
        return super.attack(choice,level);

    }

    @Override
    public void auroraBeam() {

    }

    @Override
    public void avalanche() {

    }

    @Override
    public void blizzard() {

    }

    @Override
    public void glaciate() {

    }

    @Override
    public void menu(int choice, int attackChoice, int enemyAttack) {
        super.menu(choice, attackChoice, enemyAttack);
        switch (choice){
            case 3:
               auroraBeam();
                break;
            case 4:
                avalanche();
                break;
            case 5:
                blizzard();
                break;
            case 6:
                glaciate();
                break;
        }
    }
}
