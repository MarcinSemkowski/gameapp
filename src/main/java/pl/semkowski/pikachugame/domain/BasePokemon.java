package pl.semkowski.pikachugame.domain;

public abstract class BasePokemon {
private String name;
private int  hitPoints = 100;
private int stamina;
private int level;
private int demage;
private int defense;
private boolean hunger;

protected abstract void eat(String food);
protected abstract int  sleep(int time);
protected abstract int  attack();
protected abstract void defense();



}
