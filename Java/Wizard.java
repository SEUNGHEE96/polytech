package com.example;

public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;
    
    void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.power);
        hero.setHP(hero.getHP() + recovPoint);
    }
    
}
