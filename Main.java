package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = scanner.nextInt();

        int waterCaffe = water / 200;
        int milkCaffe = milk / 50;
        int beansCaffe = beans / 15;
        int min = Integer.MAX_VALUE;
        int[] maxCups = {waterCaffe, milkCaffe, beansCaffe};

        for (int i = 0; i < maxCups.length; i++) {
            if (maxCups[i] < min) {
                min = maxCups[i];
            }
        }
        howMuchCaffe(min);
    }
    public static void howMuchCaffe(int min) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int howMuchCoffe = scanner.nextInt();
        if (howMuchCoffe == min) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (howMuchCoffe > min) {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        } else {
            int howMuchMoreCups = min - howMuchCoffe;
            System.out.println("Yes, I can make that amount of coffee (and even " + howMuchMoreCups + " more than that)");
        }
    }
}