package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Flame;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FlamePokemon extends Pokemon implements Flame {

    private final String SKILL_1_NAME = " Ogniste Uderzenie";
    private final String SKILL_1_DESCRIPTION = this.getName() + " uderza ognistą pięścią.\n" +
            "\n" +
            "Koszt Energii: 20\n" +
            "\n" +
            "atak podstawowy (na stałe): +10\n" +
            "\n" +
            "\n" +
            "Pasywa: + 20\n" +
            "\n" +
            "\n" +
            "Obrażenia: od ataku podstawowego  + 15 obrażeń nieuchronnych\n" +
            "\n" +
            "\n";
    private final String SKILL_2_NAME = "Oparzenie";
    private final String SKILL_2_DESCRIPTION = " Cel zostaje zrównany z ziemią przez ognistą eksplozję.\n" +
            "\n" +
            "Obrażenia: losowo od ataku podstawowego do ataku podstawowego + 20\n" +
            "\n" +
            "Pasywa + 20\n" +
            "\n";

    private final String SPECIAL_SKILL_NAME = "Miotacz ognia";
    private final String SKILL_SPECIAL_DESCRIPTION = "Cel jest spalony intensywnym podmuchem ognia (obrażenia nieuchronne). " + "\n" +

            "Obrażenia losowe w zależności od  ilości energii.\n" + "Koszt Energii : Cała Energia" ;
    private Random rand = new Random();
    private int skillOneDamage;
    private int skillTwoDamage;
    private int skillSpecialDamage;



    public FlamePokemon(String name, String photo, String attackGif, String skillOneGif, String skillTwoGif,
                        String skillSpecialGif, String defenseGif, String damageGif,
                        String reactionGif) {
        super(name, 110, 1, 20, 100, 10,
                photo, attackGif, skillOneGif, skillTwoGif,
                skillSpecialGif, defenseGif,
                damageGif, reactionGif, "FLAME");
    }

    @Override
    public boolean blastBurn(Pokemon enemy) {
        boolean result = false;
        boolean isEnergySet = this.setEnergy(30,
                true, true);
        if (!isEnergySet) {
            result = false;
        } else {

            if (getPassive() == 100) {
                this.skillTwoDamage =  ThreadLocalRandom.current().nextInt(this.getDamage(), this.getDamage() + 60 + 1);
                enemy.setHitPoints(enemy.getHitPoints() - 30 -
                       this.skillTwoDamage);
                setPassive(0);
                result = true;
            } else {
                if (enemy.isDefenseOn()) {
                    this.skillTwoDamage =  ThreadLocalRandom.current().nextInt(this.getDamage(), this.getDamage() + 20 + 1);
                    enemy.setHitPoints(enemy.getHitPoints() - enemy.defense(15 -
                     this.skillTwoDamage));
                    result = true;
                    setPassive(getPassive() + 20);
                    enemy.setDefenseOn(false);
                } else {
                    enemy.setHitPoints(enemy.getHitPoints() - 15 -
                            rand.nextInt((30 - 5) + 1) + 5);
                    result = true;
                    setPassive(getPassive() +20);

                }
            }
        }


        return result;
    }

    @Override
    public boolean firePunch(Pokemon enemy) {
        // hp na Energy  10 hp na 10 dmg  +20 pasive  15  dmg enemy
        boolean isEnergySet = this.setEnergy(20, true, true);
        if (isEnergySet) {
            if (this.getPassive() == 100) {
                this.setDamage(this.getDamage() + 40);
                this.setPassive(getPassive() + 30);
                this.skillOneDamage =  this.getDamage();
                enemy.setHitPoints(enemy.getHitPoints() - 40);
                enemy.setHitPoints(enemy.getHitPoints() - 30);
                this.setPassive(0);
                return true;
            }else {

                this.setDamage(this.getDamage() + 15);
                this.setPassive(getPassive() + 20);
                if (enemy.isDefenseOn()) {
                    this.skillOneDamage = this.getDamage();
                    enemy.setHitPoints(enemy.getHitPoints() - enemy.defense(this.rand.nextInt(20)));
                    enemy.setHitPoints(enemy.getHitPoints() - 15);
                    enemy.setDefenseOn(false);
                    return true;
                } else {
                    enemy.setHitPoints(enemy.getHitPoints() - 15);
                    enemy.setHitPoints(enemy.getHitPoints() -this.rand.nextInt(20 ));
                    return true;
                }
            }
        } else {
            return false;
        }

    }

    @Override
    public boolean Flamethrower(Pokemon enemy) {
        if (this.getEnergy() == 0) {
            return false;
        }
        int damage;
        if(this.getPassive() == 100) {
            damage = 70;
        }
        else{
           damage = 50;
        }

        this.setDefense(this.getDefense() + damage);
        enemy.setHitPoints(enemy.getHitPoints() - damage);
        this.setEnergy(0,false,false);

        return true;
    }


    @Override
    public boolean skillOne(Pokemon enemy) {

        return firePunch(enemy);
    }


    @Override
    public boolean skillTwo(Pokemon enemy) {
        return blastBurn(enemy);
    }


    @Override
    public boolean skillSpecial(Pokemon enemy) {

        return Flamethrower(enemy);
    }

    @Override
    public String getSkillOneName() {
        return SKILL_1_NAME;
    }

    @Override
    public String getSkillTwoName() {
        return SKILL_2_NAME;
    }

    @Override
    public String getSkillSpecialName() {
        return SPECIAL_SKILL_NAME;
    }

    @Override
    public String getSkillOneDescription() {
        return SKILL_1_DESCRIPTION;
    }

    @Override
    public String getSkillTwoDescription() {
        return SKILL_2_DESCRIPTION;
    }

    @Override
    public String getSkillSpecialDescription() {
        return SKILL_SPECIAL_DESCRIPTION;
    }

    @Override
    public String getSkillOneDescription(Pokemon enemyPokemon) {
        return this.getName() + " Uderza ognistą pięścią " + enemyPokemon.getName();
    }

    @Override
    public String getSkillTwoDescription(Pokemon enemyPokemon) {
        return  this.getName() + " Używa Oparzenie na " + enemyPokemon.getName() ;
    }

    @Override
    public String getSkillSpecialDescription(Pokemon enemyPokemon) {
        return this.getName() + " Używa Miotacz ognia na " + enemyPokemon.getName()
                ;
    }


}
