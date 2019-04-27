package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Electric;

public class ElectricPokemon extends Pokemon implements Electric {




    public ElectricPokemon(String name) {
        super(name,  10,100);


    }


    @Override
    protected int attack(int choice) {
        int damage=0;
        switch(choice){
             case 1:
                 System.out.println("Attack with defense ,damage =5, energy -7");


                setEnergy(getEnergy() - 5);

                break;
            case 2:
                System.out.println("Pure attack , damage = 10 ,");

                setEnergy(getEnergy() - 5);
               damage = 10;
                break;
                default:

                    break;
         }
     return damage;
    }

    @Override
    protected int defense(int damage) {
        System.out.println("Used defense skills  ");

       return damage - getDefense();
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
}
