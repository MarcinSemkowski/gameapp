package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.domain.pokemon.type.Grass;

import java.util.Random;

public class GrassPokemon extends Pokemon implements Grass {

    //todo: NAMES AND DESCRIPTION


    private final String SKILL_1_NAME = " Pochłanianie";
    private final String SKILL_1_DESCRIPTION = this.getName() + " uderza ognistą pięścią.\n" +
            "\n" +
            "Koszt Energii: 30\n" +
            "\n" +
            "Obrona (na stałe): +10\n" +
            "\n" + " HP:  + 30 " +
            "\n" +
            "Pasywa: + 20\n";
    private final String SKILL_2_NAME = "Nasiono";
    private final String SKILL_2_DESCRIPTION =  this.getName() + " Wystrzeliwuje nasiono w stronę przeciwnika. \n" +
            "\n" +
            "Obrażenia: 20\n" +
            "\n" +
            "Pasywa + 50\n" +
            "\n";

    private final String SPECIAL_SKILL_NAME = "Miotacz ognia";
    private final String SKILL_SPECIAL_DESCRIPTION = "Cel jest spalony intensywnym podmuchem ognia (obrażenia nieuchronne). " + "\n" +

            "Obrażenia losowe w zależności od  ilości energii.\n" + "Koszt Energii : Cała Energia" ;
    private Random rand = new Random();
    private int skillOneDamage;
    private int skillTwoDamage;
    private int skillSpecialDamage;



    public GrassPokemon(String name, int hitPoints, int level, int damage, int energy, int defense, String photo, String attackGif, String skillOneGif, String skillTwoGif, String skillSpecialGif, String defenseGif, String damageGif, String reactionGif, String type) {
        super(name, hitPoints, level, damage, energy, defense, photo, attackGif, skillOneGif, skillTwoGif, skillSpecialGif, defenseGif, damageGif, reactionGif, type);
    }





    @Override
    public boolean Absorb(Pokemon enemy) {

        boolean isEnergySet = this.setEnergy(30,true,true);

        if(isEnergySet) {
            if (this.getPassive() == 100) {
                this.setHitPoints(getHitPoints() + 60);
                this.setDefense(getDefense() + 20);
                int damage = (40 / 100) * enemy.getDamage();
                enemy.setHitPoints(enemy.getHitPoints() - damage);
                this.setPassive(0);
                return true;
            }
            this.setHitPoints(getHitPoints() + 30);
            this.setDefense(getDefense() + 15);
            this.setPassive(getPassive() + 20);

          return true;
        }
        else{
            return false;
        }



    }

    @Override
    public boolean BulletSeed(Pokemon enemy) {
        boolean isEnergySet = this.setEnergy(40,true,true);
        if(isEnergySet){
            if(this.getPassive() == 100){
               this.setHitPoints(getHitPoints() + enemy.getDamage());
               this.setDamage(getDamage() + enemy.getDefense());
              enemy.setHitPoints(enemy.getHitPoints() - 20);
                this.setPassive(getPassive() + 50);
            }
            else{
                if (enemy.isDefenseOn()) {
                    enemy.setHitPoints(enemy.defense(40));
                    this.setPassive(getPassive() + 50);
                    return true;
                }
                else{
                    enemy.setHitPoints(40);
                    this.setPassive(getPassive() + 50);
                    return true;
                }
            }
        }

            return false;
        }

    @Override
    public boolean EnergyBall(Pokemon enemy) {
       int damage = countDamage();
        this.setDamage(this.getDamage() + damage);
        this.setEnergy(60,true,true);
         enemy.setHitPoints(enemy.getHitPoints() - damage);

        return true;
    }


    @Override
    public boolean skillOne(Pokemon enemy) {
        return Absorb(enemy);
    }

    @Override
    public boolean skillTwo(Pokemon enemy) {
        return BulletSeed(enemy);
    }

    @Override
    public boolean skillSpecial(Pokemon enemy) {
        return EnergyBall(enemy);
    }

    @Override
    public String getSkillOneName() {
        return null;
    }

    @Override
    public String getSkillTwoName() {
        return null;
    }

    @Override
    public String getSkillSpecialName() {
        return null;
    }

    @Override
    public String getSkillOneDescription() {
        return null;
    }

    @Override
    public String getSkillTwoDescription() {
        return null;
    }

    @Override
    public String getSkillSpecialDescription() {
        return null;
    }

    @Override
    public String getSkillOneDescription(Pokemon enemyPokemon) {
        return null;
    }

    @Override
    public String getSkillTwoDescription(Pokemon enemyPokemon) {
        return null;
    }

    @Override
    public String getSkillSpecialDescription(Pokemon enemyPokemon) {
        return null;
    }



}
