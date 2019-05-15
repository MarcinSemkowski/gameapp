package pl.semkowski.pikachugame.domain.pokemon;

import pl.semkowski.pikachugame.domain.Pokemon;
import pl.semkowski.pikachugame.type.Ice;

public class IcePokemon extends Pokemon implements Ice {

    private final String SKILL_1_NAME = "  Lodowaty Szok";
    private final String SKILL_1_DESCRIPTION = "W drugiej turze użytkownik uderza cel " +
            "elektrycznie naładowanym lodem.";
    private final String SKILL_2_NAME = "Lodowata wiązka";
    private final String SKILL_2_DESCRIPTION = "Cel trafia lodowatą zimną wiązką energii.";
    private final String SPECIAL_SKILL_NAME = " Oddech Mrozu";
    private final String SKILL_SPECIAL_DESCRIPTION = "Użytkownik wydmuchuje zimny oddech na" +
            " cel. Ten atak zawsze powoduje trafienie krytyczne.";

    public IcePokemon(String name,String photo, String attackGif, String skillOneGif, String skillTwoGif, String skillSpecialGif,
                      String defenseGif, String damageGif, String reactionGif) {
        super(name, 180, 1, 10, 100, 20, photo,
                attackGif, skillOneGif, skillTwoGif, skillSpecialGif,
                defenseGif, damageGif, reactionGif,"ICE");
    }



    @Override
    public int freezeShock() {
        System.out.println("Use auroraBeam !!!!!");

        return 0;
    }

    @Override
    public int iceBeam() {
        System.out.println("Use avalanche !!!!!");

        return 0;
    }



    @Override
    public int frostBreath() {
        System.out.println("Use glaciate !!!!!");
        return 0;
    }






    @Override
    public boolean skillOne(Pokemon enemy) {
        return false;
    }


    @Override
    public boolean skillTwo(Pokemon enemy) {
        return false;
    }

    @Override
    public boolean skillSpecial(Pokemon enemy) {
        return false;
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

