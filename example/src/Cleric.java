package com.example;

public class Cleric {

    String name;
    int HP = 0;
    int MP = 0;

    static final int MAX_HP = 50;
    static final int MAX_MP = 10;

    Cleric(String name) {
        this(name, MAX_HP, MAX_MP);
    }

    Cleric(String name, int HP) {
        this(name, HP, MAX_MP);
    }

    Cleric(String name, int HP, int MP) {
        this.name = name;
        this.HP = HP;
        this.MP = MP;
    }

    void selfAid() {
        MP -= 5;
        HP = Cleric.MAX_HP;
    }

    int pray(int sec) {
        int answer;
        int recovery = (int) (Math.random() * 3) + sec;
        if (MP + recovery < Cleric.MAX_MP) {
            answer = recovery;
            MP += recovery;
        } else {
            answer = Cleric.MAX_MP - MP;
            MP = Cleric.MAX_MP;
        }
        return answer;
    }

}
