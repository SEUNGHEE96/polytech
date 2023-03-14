package com.example;

public class Wizard {
    private int hp;
    private int mp;
    private String name;
    private Wand wand;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        // HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다. (에러 아님)
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp;
        }
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        // 마법사의 MP는 0 이상이어야 한다.
        if (mp < 0) {
            throw new IllegalArgumentException("정수값을 입력하세요.");
        }
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wand getWand() {
        return wand;
    }

    public void setWand(Wand wand) {
        // 마법사의 지팡이는 null 일 수 없다.
        if (wand == null) {
            throw new IllegalArgumentException("유효한 지팡이를 입력하세요.");
        }
        this.wand = wand;
    }

    public void heal(Hero hero) {
        int basePoint = 10;
        int recovPoint = (int) (basePoint * this.wand.getPower());
        hero.setHP(hero.getHP() + recovPoint);
    }

}
