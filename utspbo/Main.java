import character.Character;
import enemy.Enemy;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;

        while (playing) {
            Character player = new Character("Rimuru", 100, 30, 10);
            Enemy enemy = new Enemy("Veldanava", 150, 25, 5);

            System.out.println("Selamat datang di Text RPG!");

            while (player.isAlive() && enemy.isAlive()) {
                System.out.println("\nHP " + player.name + ": " + player.hp + " | HP " + enemy.name + ": " + enemy.hp);
                System.out.println("Pilih keputusan:");
                System.out.println("1. Serang");
                System.out.println("2. Bertahan");
                System.out.println("3. Minum Ramuan (sisa: " + player.potions + ")");
                System.out.println("4. Kabur");
                System.out.print("> ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        player.attack(enemy);
                        break;
                    case 2:
                        player.defend();
                        break;
                    case 3:
                        player.minumRamuan();
                        break;
                    case 4:
                        System.out.println("Melarikan diri dari pertempuran...");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid.");
                }

                // Musuh menyerang balik jika masih hidup
                if (enemy.isAlive()) {
                    enemy.attack(player);
                }
            }

            if (!player.isAlive()) {
                System.out.println("\nGame Over! Bangkit kembali? (y/n)");
                String retry = scanner.next();
                if (retry.equalsIgnoreCase("n")) {
                    playing = false;
                }
            } else {
                System.out.println("\nSelamat! Kamu mengalahkan Veldanava!");
                playing = false;
            }
        }
        System.out.println("Terima kasih sudah menyelamatkan dunia!");
        scanner.close();
    }
}