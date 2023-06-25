package com.example;

public class Wand {
    private String name;
    private double power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // 마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("3글자 이상 입력해주세요.");
        }
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        // 지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
        if (power < 0.5 || power > 100) {
            throw new IllegalArgumentException("마력의 범위가 옳지 않습니다.");
        }
        this.power = power;
    }

}
