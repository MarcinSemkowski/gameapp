package pl.semkowski.pikachugame.domain;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Pokemon {
    private String name;
    private int hitPoints;
    private int level;
    private int damage;
    private int energy;
    private int defense;
    private String photo;
    private String attackGif;
    private String skillOneGif;
    private String skillTwoGif;

    private String skillSpecialGif;
    private String defenseGif;
    private String DamageGif;
    private String reactionGif;
    private int passive;
    private  String type;
    private boolean isDefenseOn;
    private Random rand = new Random();



    public Pokemon(String name, int hitPoints, int level, int damage, int energy, int defense, String photo,
                   String attackGif, String skillOneGif, String skillTwoGif,
                   String skillSpecialGif, String defenseGif,
                   String damageGif, String reactionGif, String type) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.level = level;
        this.damage = damage;
        this.energy = energy;
        this.defense = defense;
        this.photo = photo;
        this.attackGif = attackGif;
        this.skillOneGif = skillOneGif;
        this.skillTwoGif = skillTwoGif;
        this.skillSpecialGif = skillSpecialGif;
        this.defenseGif = defenseGif;
        DamageGif = damageGif;
        this.reactionGif = reactionGif;
        this.type = type;
        this.passive = 0;


    }




    public String getAttackGif() {
        return attackGif;
    }

    public String getSkillOneGif() {
        return skillOneGif;
    }

    public String getSkillTwoGif() {
        return skillTwoGif;
    }



    public String getSkillSpecialGif() {
        return skillSpecialGif;
    }

    public String getDefenseGif() {
        return defenseGif;
    }

    public String getDamageGif() {
        return DamageGif;
    }

    public String getReactionGif() {
        return reactionGif;
    }

    public int getPassive() {
        return passive;
    }

    public String getType() {
        return type;
    }

    protected void setType(String type) {
        this.type = type;
    }

    protected void setPassive(int passive) {

            if (this.passive >0 && getPassive() - passive < 0) {
                this.passive = 0;
            } else if (this.passive + passive > 100) {
                this.passive = 100;
            } else {
                this.passive = passive;
            }
            if(this.passive <= 0){
                this.passive = 0;
            }

    }

    public  boolean isDefenseOn() {
        return isDefenseOn;
    }

    public void setDefenseOn(boolean defenseOn) {
        isDefenseOn = defenseOn;
    }


    public String getPhoto() {
        return photo;
    }

    public int getDefense() {
        return defense;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if(hitPoints < 0)
        this.hitPoints = 0;
        else
          this.hitPoints = hitPoints;
    }

    protected int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    public int getDamage() {
        return damage;
    }

    protected void setDamage(int damage) {
        this.damage = damage;
    }

    public int getEnergy() {
        return energy;
    }

   public boolean setEnergy(int energy,boolean toExistingValue,boolean subtract) {
         if(toExistingValue) {
             if (subtract) {
                 if (getEnergy() - energy < 0) {
                     return false;
                 } else {
                     this.energy = this.energy - energy;
                     return true;
                 }
             }
             else{

                     this.energy = this.energy + energy;
                     return true;

             }
             }

         else{
            this.energy = energy;
            return true;
         }
    }


    // protected abstract void eat(String food);

   // protected abstract int sleep(int time);



    public boolean attack(Pokemon enemy){
        if(enemy.isDefenseOn) {
            enemy.setHitPoints(enemy.getHitPoints() - enemy.defense(this.damage));
            return true;
        }
        else{
            enemy.setHitPoints(enemy.getHitPoints() - this.damage);
           return true;
        }

    }

    public int defense(int damage){

        int block = getDefense() - damage;
        if(block < 0){
            block = 0;
        }
         System.out.println("Block =  " + block);
        return block;
    }
    public void defense(){
        System.out.println("Used defense skills  ");
        this.energy += 20;
        this.isDefenseOn = true;
    }

    protected  void levelUP(){
        setDamage(getDamage() + 5);
        setLevel(getLevel()+ 1);
        setDefense(getDefense()+ 5);

    }


    public int countDamage(){
       int damage =0;
        if(getPassive() == 100) {
            if (this.getEnergy() < 10) {
                damage = ThreadLocalRandom.current().nextInt(15, 25 );
            } else if (this.getEnergy() < 30) {
                damage = ThreadLocalRandom.current().nextInt(25, 30);
            } else if (this.getEnergy() < 50) {
                damage = ThreadLocalRandom.current().nextInt(30, 35);
            } else if (this.getEnergy() < 70) {
                damage = ThreadLocalRandom.current().nextInt(35, 40);
            } else if (this.getEnergy() < 90) {
                damage = ThreadLocalRandom.current().nextInt(40, 45);
            } else if (this.getEnergy() >= 100) {
                damage = ThreadLocalRandom.current().nextInt(50,55 );
            } else if (this.getEnergy() >= 200) {
                damage = ThreadLocalRandom.current().nextInt(60, 65);
            }
        }
        else{
            if (this.getEnergy() < 10) {
                damage = ThreadLocalRandom.current().nextInt(2 , 10);
            } else if (this.getEnergy() < 30) {
                damage = ThreadLocalRandom.current().nextInt(10 , 13);
            } else if (this.getEnergy() < 50) {
                damage = ThreadLocalRandom.current().nextInt(13, 18 );
            } else if (this.getEnergy() < 70) {
                damage = ThreadLocalRandom.current().nextInt(18, 26);
            } else if (this.getEnergy() < 90) {
                damage = ThreadLocalRandom.current().nextInt(26 , 35);
            } else if (this.getEnergy() > 100) {
                damage = ThreadLocalRandom.current().nextInt(35, 40);
            } else if (this.getEnergy() > 200) {
                damage = ThreadLocalRandom.current().nextInt(45, 50);
            }
        }




      return damage;
    }








    public abstract boolean skillOne(Pokemon enemy);

    public abstract boolean skillTwo(Pokemon enemy);

    public abstract boolean skillSpecial(Pokemon enemy);
    public abstract String getSkillOneName();
    public abstract String getSkillTwoName();
    public abstract String getSkillSpecialName();
    public abstract String getSkillOneDescription();
    public abstract String getSkillTwoDescription();
    public abstract String getSkillSpecialDescription();
    public abstract String getSkillOneDescription(Pokemon enemyPokemon);
    public abstract String getSkillTwoDescription(Pokemon enemyPokemon);
    public abstract String getSkillSpecialDescription(Pokemon enemyPokemon);

    }

