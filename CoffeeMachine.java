package machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CoffeeMachine extends ProgressBar {
    final Scanner sc = new Scanner(System.in);
    private final int numberOfIngredients = 4;
    private final Money money = new Money();
    private final Map<Ingredients, Integer> coffeeMachine = new HashMap<>(Map.of(Ingredients.WATER, 400, Ingredients.MILK, 540, Ingredients.BEANS, 120, Ingredients.CUPS, 9));

    void coffeeMachineMenu() {
        menu:
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.next();
            switch (action) {
                case "buy":
                    selectCoffeeType();
                    break;
                case "fill":
                    fillMachine(coffeeMachine);
                    break;
                case "take":
                    giveMoney(money);
                    break;
                case "remaining":
                    remainingIngredients();
                    break;
                case "exit":
                    break menu;
            }
        } while (true);
    }

    private void selectCoffeeType() {
        System.out.println("\n" +
                "What do you want to buy? Type:  \"1\" - espresso, \"2\" - latte, \"3\" - cappuccino, \"back\" - to main menu: ");
        String choice = sc.next();
        switch (choice) {
            case "1":
                makeCoffee(CoffeeType.ESPRESSO);
                break;
            case "2":
                makeCoffee(CoffeeType.LATTE);
                break;
            case "3":
                makeCoffee(CoffeeType.CAPPUCCINO);
                break;
            case "back":
                break;
        }
    }

    private void makeCoffee(CoffeeType coffeeType) {
        if (!checkResources(coffeeType)) {
            System.out.println("I have enough resources, making you a coffee!");
            for (int i = 0; i <= 200; i = i + 10) {
                ProgressBar.progressPercentage(i, 200);
                try {
                    Thread.sleep(500);
                } catch (Exception e) {

                }
            }
            System.out.println("Here is your coffee!\n");
            updateResources(coffeeType);
        }
    }

    private boolean checkResources(CoffeeType coffeeType) {
        for (int i = 1; i <= numberOfIngredients; i++) {
            if (coffeeMachine.get(Ingredients.returnIngredient(i)) < CoffeeType.returnIngredientAmount(coffeeType, i)) {
                System.out.println(Ingredients.returnIngredient(i).getApology());
                return true;
            }
        }
        return false;
    }

    private void updateResources(CoffeeType coffeeType) {
        for (int i = 1; i <= numberOfIngredients; i++) {
            coffeeMachine.put(Ingredients.returnIngredient(i), coffeeMachine.get(Ingredients.returnIngredient(i)) - CoffeeType.returnIngredientAmount(coffeeType, i));
        }
        money.setWallet(money.getWallet() + coffeeType.getPrice());
    }

    private void fillMachine(Map<Ingredients, Integer> coffeeMachine) {
        for (int i = 1; i <= numberOfIngredients; i++) {
            System.out.println(Ingredients.returnIngredient(i).getFillInfo());
            coffeeMachine.put(Ingredients.returnIngredient(i), coffeeMachine.get(Ingredients.returnIngredient(i)) + sc.nextInt());
        }
        System.out.println();
    }

    private void remainingIngredients() {
        System.out.println("The coffee machine has: ");
        for (int id = 1; id <= numberOfIngredients; id++) {
            System.out.println(coffeeMachine.get(Ingredients.returnIngredient(id)) + Ingredients.returnIngredient(id).getUnitInfo());
        }
        System.out.println("$" + money.getWallet() + money.getUnitInfo() + "\n");

    }

    private void giveMoney(Money money) {
        System.out.println("I gave you $" + money.getWallet() + "\n");
        money.setWallet(0);
    }
}
