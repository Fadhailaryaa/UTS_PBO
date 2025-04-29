package character;

public class Character {
    public String name;
    public int hp;
    public int attackPower;
    public int defensePower;
    public int potions = 3; // maksimal 3 ramuan

    public Character(String name, int hp, int attackPower, int defensePower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void attack(Character enemy) {
        int damage = this.attackPower - enemy.defensePower;
        if (damage < 0) damage = 0;
        System.out.println(this.name + " menyerang " + enemy.name + "! Damage: " + damage);
        enemy.receiveDamage(damage);
    }

    public void defend() {
        System.out.println(this.name + " bertahan! Mengurangi damage musuh.");
    }

    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) this.hp = 0;
    }

    // Overloading: minumRamuan()
    public void minumRamuan() {
        minumRamuan(20); // default +20 HP
    }

    public void minumRamuan(int healAmount) {
        if (potions > 0) {
            this.hp += healAmount;
            potions--;
            System.out.println(this.name + " meminum ramuan! HP bertambah " + healAmount + " poin.");
        } else {
            System.out.println("Tidak ada ramuan tersisa!");
        }
    }

    public boolean isAlive() {
        return this.hp>0;
    }
}