package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Ice;

public class IcePokemon extends Pokemon implements Ice {

    private final String SKILL_1_NAME = " auroraBeam";
    private final String SKILL_2_NAME = "avalanche";
    private final String SKILL_3_NAME = "blizzard";
    private final String SPECIAL_SKILL_NAME = " glaciate";



    public IcePokemon(String name) {
        super(name,
                10,
                100,
                "../img/sandshrew.png");
    }




    @Override
    public int auroraBeam() {
        System.out.println("Use auroraBeam !!!!!");

        return 0;
    }

    @Override
    public int avalanche() {
        System.out.println("Use avalanche !!!!!");

        return 0;
    }

    @Override
    public int blizzard() {
        System.out.println("Use blizzard !!!!!");

        return 0;
    }

    @Override
    public int glaciate() {
        System.out.println("Use glaciate !!!!!");
        return 0;
    }



    @Override
    public int skillOne() {

        return auroraBeam();
    }

    @Override
    public int skillTwo() {

      return  avalanche();
    }

    @Override
    public int skillThree() {

      return blizzard();
    }

    @Override
    public int skillSpecial() {

      return glaciate();
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
