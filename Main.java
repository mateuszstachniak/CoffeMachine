package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] coffeeMachineIngredients = {400, 540, 120, 9, 550};
        CoffeeMachineStatus(coffeeMachineIngredients);
        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.next();
        if (action.equals("buy")) {
            coffeeBuying(coffeeMachineIngredients);
        } else if (action.equals("fill")) {
            fillMachine(coffeeMachineIngredients);
        } else if (action.equals("take")) {
            giveMoney(coffeeMachineIngredients);
        }
        CoffeeMachineStatus(coffeeMachineIngredients);
    }
    
    public static void CoffeeMachineStatus(int[] coffeeMachineIngredients) {
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
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            espresso(coffeeMachineIngredients);
        } else if (choice == 2) {
            latte(coffeeMachineIngredients);
        } else if (choice == 3) {
            cappucino(coffeeMachineIngredients);
        }
    }
    
    public static int[] espresso(int[] coffeeMachineIngredients) {
        coffeeMachineIngredients[0] -= 250;
        coffeeMachineIngredients[2] -= 16;
        coffeeMachineIngredients[3]--;
        coffeeMachineIngredients[4] += 4;
        return coffeeMachineIngredients;
    }

    public static int[] latte(int[] coffeeMachineIngredients) {
        coffeeMachineIngredients[0] -= 350;
        coffeeMachineIngredients[1] -= 75;
        coffeeMachineIngredients[2] -= 20;
        coffeeMachineIngredients[3]--;
        coffeeMachineIngredients[4] += 7;
        return coffeeMachineIngredients;
    }

    public static int[] cappucino(int[] coffeeMachineIngredients) {
        coffeeMachineIngredients[0] -= 200;
        coffeeMachineIngredients[1] -= 100;
        coffeeMachineIngredients[2] -= 12;
        coffeeMachineIngredients[3]--;
        coffeeMachineIngredients[4] += 6;
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
}