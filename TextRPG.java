import java.util.Scanner;
import java.util.Random;

class Player {
    private String name;
    private int health;
    private int experience;
    
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void gainExperience(int exp) {
        this.experience += exp;
    }

    public int getExperience() {
        return this.experience;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }
}

class Monster {
    private String name;
    private int health;
    private int damage;

    public Monster(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int attack() {
        return damage;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }
}

public class TextRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Text-Based RPG Game!");
        System.out.print("Enter your character's name: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        System.out.println("Welcome, " + player.getName() + "! Let's start the adventure.");

        int round = 1;
        while (player.isAlive()) {
            System.out.println("\n--- Round " + round + " ---");
            Monster enemy = generateRandomMonster();
            System.out.println("A wild " + enemy.getName() + " appeared!");

            while (enemy.isAlive() && player.isAlive()) {
                System.out.println("\n" + player.getName() + "'s Health: " + player.getHealth());
                System.out.println(enemy.getName() + "'s Health: " + enemy.getHealth());
                System.out.println("Choose your action: (1) Attack | (2) Run");
                int action = scanner.nextInt();

                if (action == 1) {
                    int playerDamage = generateRandomDamage(10, 20);
                    enemy.takeDamage(playerDamage);
                    System.out.println("You dealt " + playerDamage + " damage to the " + enemy.getName() + "!");

                    if (enemy.isAlive()) {
                        int enemyDamage = enemy.attack();
                        player.takeDamage(enemyDamage);
                        System.out.println("The " + enemy.getName() + " attacked you for " + enemyDamage + " damage!");
                    }
                } else if (action == 2) {
                    System.out.println("You ran away from the battle!");
                    break;
                } else {
                    System.out.println("Invalid action! Try again.");
                }
            }

            if (!player.isAlive()) {
                System.out.println("Game Over! You were defeated.");
                break;
            }

            if (!enemy.isAlive()) {
                System.out.println("You defeated the " + enemy.getName() + "!");
                int expEarned = generateRandomExp(20, 40);
                player.gainExperience(expEarned);
                System.out.println("You earned " + expEarned + " experience points.");

                if (player.getExperience() >= 100) {
                    System.out.println("Congratulations! You leveled up!");
                    player.gainExperience(-100);
                    player.takeDamage(-20); // Healing the player upon leveling up
                }
            }

            round++;
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static Monster generateRandomMonster() {
        Random rand = new Random();
        String[] monsterNames = {"Goblin", "Skeleton", "Orc", "Dragon", "Troll"};
        String randomName = monsterNames[rand.nextInt(monsterNames.length)];
        int randomHealth = rand.nextInt(80) + 50; // Health between 50-130
        int randomDamage = rand.nextInt(15) + 10; // Damage between 10-25
        return new Monster(randomName, randomHealth, randomDamage);
    }

    private static int generateRandomDamage(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    private static int generateRandomExp(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }
}
