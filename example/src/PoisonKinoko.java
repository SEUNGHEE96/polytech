package com.example;

public class PoisonKinoko extends Kinoko {
    private int cnt;

    public PoisonKinoko(char suffix) {
        super(suffix);
        cnt = 5;
    }

    @Override
    public void attack(Hero hero) {
        super.attack(hero);
        if (cnt > 0) {
            System.out.println("추가로, 독 포자를 살포했다!");
            hero.setHP((int) (hero.getHP() * 0.8));
            System.out.println(hero.getHP() * 0.2 + "포인트의 데미지");
            cnt--;
        }
    }

    public static void main(String[] args) {
        PoisonKinoko poisonKinoko = new PoisonKinoko('A');
        Hero hero = new Hero();
        poisonKinoko.attack(hero);
    }

}
