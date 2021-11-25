package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coffeeMachineIngredients = {400, 540, 120, 9, 550};
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.next();
            if (action.equals("buy")) {
                coffeeBuying(coffeeMachineIngredients);
            } else if (action.equals("fill")) {
                fillMachine(coffeeMachineIngredients);
            } else if (action.equals("take")) {
                giveMoney(coffeeMachineIngredients);
            } else if (action.equals("remaining")) {
                remaining(coffeeMachineIngredients);
            } else if (action.equals("exit")) {
                break;
            }
        } while (true);
    }
    
    public static void remaining(int[] coffeeMachineIngredients) {
        System.out.println("The caffe machine has: ");
        System.out.println(coffeeMachineIngredients[0] + " ml of water");
        System.out.println(coffeeMachineIngredients[1] + " ml of milk");
        System.out.println(coffeeMachineIngredients[2] + " g of coffee beans");
        System.out.println(coffeeMachineIngredients[3] + " disposable cups");
        System.out.println("$" + coffeeMachineIngredients[4] + " of money");
        System.out.println();
    }
    
    public static void coffeeBuying(int[] coffeeMachineIngredients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" +
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = scanner.next();
        if (choice.equals("1")) {
            espresso(coffeeMachineIngredients);
        } else if (choice.equals("2")) {
            latte(coffeeMachineIngredients);
        } else if (choice.equals("3")) {
            cappucino(coffeeMachineIngredients);
        } else if (choice.equals("back")) {

        }
    }

    public static int[] espresso(int[] coffeeMachineIngredients) {
        int[] ingredients = {250, 0, 16, 1, 4};
        makeCoffee(coffeeMachineIngredients, ingredients);
        return coffeeMachineIngredients;
    }

    public static int[] latte(int[] coffeeMachineIngredients) {
        int[] ingredients = {350, 75, 20, 1, 7};
        makeCoffee(coffeeMachineIngredients, ingredients);
        return coffeeMachineIngredients;
    }

    public static int[] cappucino(int[] coffeeMachineIngredients) {
        int[] ingredients = {200, 100, 12, 1, 6};
        makeCoffee(coffeeMachineIngredients, ingredients);
        return coffeeMachineIngredients;
    }

    public static int[] fillMachine(int[] coffeeMachineIngredients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:  ");
        coffeeMachineIngredients[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:  ");
        coffeeMachineIngredients[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:  ");
        coffeeMachineIngredients[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        coffeeMachineIngredients[3] += scanner.nextInt();
        return coffeeMachineIngredients;
    }

    public static int[] giveMoney(int[] coffeeMachineIngredients) {
        int earnings = coffeeMachineIngredients[4];
        coffeeMachineIngredients[4] = 0;
        System.out.println("I gave you $" + earnings);
        System.out.println();
        return coffeeMachineIngredients;
    }

    public static int[] makeCoffee(int[] coffeeMachineIngredients, int[] ingredients) {
        boolean noResources = false;
        int resource = 0;
        for (int i = 0; i < coffeeMachineIngredients.length; i++) {
            if (coffeeMachineIngredients[i] < ingredients[i]) {
                noResources = true;
                resource = i;
                break;
            }
        }
        if (noResources) {
            switch (resource) {
                case 0:
                    System.out.println("Sorry, not enough water!");
                    break;
                case 1:
                    System.out.println("Sorry, not enough milk!");
                    break;
                case 2:
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                case 3:
                    System.out.println("Sorry, not enough disposable cups!");
                    break;
            }
        } else {
            System.out.println("I have enough resources, making you a coffee!");
        }
        if (!noResources) {
            coffeeMachineIngredients[0] -= ingredients[0];
            coffeeMachineIngredients[1] -= ingredients[1];
            coffeeMachineIngredients[2] -= ingredients[2];
            coffeeMachineIngredients[3] -= ingredients[3];
            coffeeMachineIngredients[4] += ingredients[4];
        }
        return coffeeMachineIngredients;
    }
}