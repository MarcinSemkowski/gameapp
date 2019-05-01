package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Electric;

public class ElectricPokemon extends Pokemon implements Electric {

    private final String SKILL_1_NAME = "boltStrike";
    private final String SKILL_2_NAME = "charge";
    private final String SKILL_3_NAME = "electricTerrain";
    private final String SPECIAL_SKILL_NAME = " discharge";



    public ElectricPokemon(String name) {
        super(name,
                10,
                100,
                "../img/pikachu.jpg");
    }





    @Override
    protected void levelUP() {

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
    public int skillOne() {
      return    boltStrike(this.getLevel());
    }

    @Override
    public int skillTwo() {
     return   charge(this.getLevel());
    }

    @Override
    public int skillThree() {
     return   electricTerrain(this.getLevel());
    }

    @Override
    public int skillSpecial() {
      return discharge(this.getLevel());
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
    public String getSkillThreeName() {
        return SKILL_3_NAME;
    }

    @Override
    public String getSkillSpecialName() {
        return SPECIAL_SKILL_NAME;
    }


}
