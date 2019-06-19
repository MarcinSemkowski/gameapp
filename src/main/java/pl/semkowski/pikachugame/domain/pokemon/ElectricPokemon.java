package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Electric;

import java.util.concurrent.ThreadLocalRandom;

public class ElectricPokemon extends Pokemon implements Electric {

    private final String SKILL_1_NAME = " Uderzenie piorunem";
    private final String SKILL_1_DESCRIPTION =  this.getName() + "strzela wstrząsem elektryczności, aby zaatakować cel.\n" +
            "\n" +
            "-Koszt Energii: 50\n" +
            "\n" +
            "Obrażenia: 20\n" +
            "\n" +
            "\n" +
            "Pasywa: 30";
    private final String SKILL_2_NAME = "Ładowanie";
    private final String SKILL_2_DESCRIPTION = this.getName() +" Ładuję ukradzioną energię.\n" +
            "\n" +
            "\n" +
            "Koszt Enegii : 0\n" +
            "Obrażenia: 10 do 25 punktów losowo" + "\n" +
            "\n" +
            " Kradzież Energii: 10 do 25 punktów losowo \n"+
            " Pasywa: 30 ";

    private final String SPECIAL_SKILL_NAME = "Wyładowanie";
    private final String SKILL_SPECIAL_DESCRIPTION =  this.getName() + "Wyładowuję całą zgromadzoną energię (obrażenia nieuchronne).\n" +
            "\n" +
            "Obrażenia losowe w zależności od  ilości energii.\n" + "Koszt Energii : Cała Energia";

    private int skillOneDamage;
    private int skillTwoDamage;
    private int skillSpecialDamage;


    public ElectricPokemon(String name, String photo, String attackGif, String skillOneGif, String skillTwoGif, String skillSpecialGif,
                           String defenseGif, String damageGif, String reactionGif) {
        super(name, 110, 1, 20, 100, 10,
                photo, attackGif, skillOneGif, skillTwoGif,
                skillSpecialGif, defenseGif,
                damageGif, reactionGif,"ELECTRIC");
    }



    @Override
    protected void levelUP() {

    }


    @Override
    public boolean boltStrike(Pokemon enemy) {

        boolean result = this.setEnergy(50,true,true);
        if(!result){
            return false;
        }
          if(this.getPassive() == 100) {
              enemy.setHitPoints(enemy.getHitPoints() - 40);
             this.setPassive(0);

            return true;
          }
           else {

              enemy.setHitPoints(enemy.getHitPoints() - 20);

              this.setPassive(getPassive() + 30);

              return true;
          }
    }

    @Override
    public boolean charge(Pokemon enemy) {
        int theftEnergy ;
        if(this.getPassive() == 100){
            theftEnergy = 40;
            enemy.setEnergy(theftEnergy, true, true);
            this.setEnergy(theftEnergy, true, false);
            this.setPassive(0);
            this.setPassive(getPassive() + 50);
            this.setHitPoints(this.getHitPoints() - 20);
            this.skillTwoDamage = theftEnergy;
            if (enemy.isDefenseOn()) {
                enemy.setHitPoints(enemy.defense(theftEnergy));
                return true;
            }
            else{
                enemy.setHitPoints(theftEnergy);
                return true;
            }

        }
        else {
            theftEnergy = 20;
            enemy.setEnergy(theftEnergy, true, true);
            this.setEnergy(theftEnergy, true, false);
              this.setPassive(getPassive() + 30);
            this.skillTwoDamage = theftEnergy;
             this.setPassive(getPassive() + 30);
            return true;

        }


    }

    @Override
    public boolean discharge(Pokemon enemy) {

        boolean result =  this.setEnergy(100,true,true);
        if(!result){
            return false;
        }
        if (this.getEnergy() == 0) {
            return false;
        }
        int damage;
        if(this.getPassive() == 100) {
            damage = 70;
        }
        else{
            damage = 40;
        }
        this.setDefense(getDefense() + damage);
        enemy.setHitPoints(enemy.getHitPoints() - damage);

       return true;
    }

    @Override
    public boolean skillOne(Pokemon enemy) {
        return boltStrike(enemy) ;
    }



    @Override
    public boolean skillTwo(Pokemon enemy) {
        return charge(enemy);
    }

    @Override
    public boolean skillSpecial(Pokemon enemy) {
        return discharge(enemy);
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
        return this.getName() + "Używa Uderzenie piorunem na "+ enemyPokemon.getName();
    }

    @Override
    public String getSkillTwoDescription(Pokemon enemyPokemon) {
        return this.getName() + "Używa Ładowanie";
    }

    @Override
    public String getSkillSpecialDescription(Pokemon enemyPokemon) {
        return this.getName() + " Używa  Rozładowanie";
    }



}
