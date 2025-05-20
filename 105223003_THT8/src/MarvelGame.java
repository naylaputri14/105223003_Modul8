import java.util.Scanner;

public class MarvelGame {
    static Scanner input = new Scanner(System.in);
    static String[] usernames = new String[10];
    static String[] passwords = new String[10];
    static int userCount = 0;

    static String currentUser = " ";
    static int health = 100;
    static int level = 1;
    static String[] inventory = new String[3];
    static int position = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Login\n2. Register\n3. Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1 && login()) {
                startGame();
            } else if (choice == 2) {
                register();
            } else if (choice == 3) {
                System.out.println("GOODBYE!!!");
                break;
            }
        }
    }

    static void register() {
        if (userCount >= usernames.length) {
            System.out.println("User limit has reached!");
            return;
        }

        System.out.print("Enter username: ");
        usernames[userCount] = input.nextLine();
        System.out.print("Enter password: ");
        passwords[userCount] = input.nextLine();
        userCount++;
        System.out.println("Registered successfully!");
    }

    static boolean login() {
        System.out.print("Enter username: ");
        String uname = input.nextLine();
        System.out.print("Enter password: ");
        String pwd = input.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (stringEquals(usernames[i], uname) && stringEquals(passwords[i], pwd)) {
                currentUser = uname;
                System.out.println("Login successfully! Welcome, " + uname + "! :)");
                return true;
            }
        }
        System.out.println("Login failed! :(");
        return false;
    }

    static boolean stringEquals(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    static void startGame() {
        health = 100;
        level = 1;
        position = 0;
        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = "-";
        }

        while (true) {
            System.out.println("\nUser: " + currentUser + " | Health: " + health + " | Level: " + level);
            System.out.println("1. Move Forward\n2. Move Backward\n3. Check Inventory\n4. Exit Game");
            System.out.print("Choose: ");
            int act = input.nextInt();
            input.nextLine();

            if (act == 1) {
                position++;
                encounter(position);
            } else if (act == 2) {
                position--;
                encounter(position);
            } else if (act == 3) {
                showInventory();
            } else if (act == 4) {
                System.out.println("Exiting game... Bye-Bye...");
                break;
            }
        }
    }

    static void encounter(int pos) {
        System.out.println("You moved to position " + pos);
        if (pos == 1) {
            System.out.println("You found an Arc Reactor, Yeay!");
            inventory[0] = "Arc Reactor";
        } else if (pos == 2) {
            System.out.println("OH NO! You encountered Ultron!");
            battle(30);
        } else if (pos == 3) {
            System.out.println("You found a Vibranium Shield, Yeay!");
            inventory[1] = "Vibranium Shield";
        } else if (pos == 4) {
            System.out.println("OH NO! You encountered Kang the Conqueror!");
            battle(50);
        } else {
            System.out.println("Tap... Tap...");
        }
    }

    static void battle(int enemyPower) {
        System.out.println("Battle started! Your Enemy power: " + enemyPower);
        while (enemyPower > 0 && health > 0) {
            System.out.println("1. Attack\n2. Run");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                enemyPower -= 10;
                System.out.println("You hit the enemy. Enemy HP now: " + enemyPower);
                if (enemyPower > 0) {
                    health -= 10;
                    System.out.println("Enemy hit you. Your health now: " + health);
                } else {
                    System.out.println("WOW! You defeated the enemy! Yeay!");
                    level++;
                }
            } else {
                System.out.println("You ran away...");
                break;
            }
        }
        
        if (health <= 0) {
            System.out.println("Oh No... You died...");
        }
    }

    static void showInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < inventory.length; i++) {
            System.out.println((i + 1) + ". " + inventory[i]);
        }
    }
}