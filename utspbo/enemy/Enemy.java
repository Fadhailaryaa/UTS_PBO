package enemy;

import character.Character;

public class Enemy extends Character {

    public Enemy(String name, int hp, int attackPower, int defensePower) {
        super(name, hp, attackPower, defensePower);
    }

    @Override
    public void attack(Character player) {
        int damage = this.attackPower - player.defensePower;
        if (damage < 0) damage = 0;
        System.out.println(this.name + " menyerang balik! Damage: " + damage);
        player.receiveDamage(damage);
    }
}