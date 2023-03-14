package com.example;

import java.util.Random;

public class Cleric {

    String name;
    int HP = 0;
    int MP = 0;

    static final int maxHP = 50;
    static final int maxMP = 10;

    Cleric(String name) {
        this(name, maxHP, maxMP);
    }

    Cleric(String name, int HP) {
        this(name, HP, maxMP);
    }

    Cleric(String name, int HP, int MP) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
    }

    void selfAid() {
        this.MP -= 5;
        this.HP = Cleric.maxHP;
    }

    int pray(int sec) {
        int answer;
        int recovery = new Random().nextInt(3) + sec;
        // int recovery = (int) (Math.random() * 3) + sec;
        if (this.MP + recovery < Cleric.maxMP) {
            answer = recovery;
            this.MP += recovery;
        } else {
            answer = Cleric.maxMP - this.MP;
            this.MP = Cleric.maxMP;
        }
        return answer;
    }

}
