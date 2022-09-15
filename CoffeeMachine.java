package machine;

import java.util.HashMap;
import java.util.Map;

class CoffeeMachine implements Invariables {
    int[] coffeeMachineIngredients = {400, 540, 120, 9, 550};

    Map<Ingredients, Integer> coffeeMachine = new HashMap<>(Map.of(Ingredients.WATER, 400, Ingredients.MILK, 540, Ingredients.BEANS, 120, Ingredients.CUPS, 9, Ingredients.MONEY, 550));

    boolean noResources;

    void coffeeMachineMenu() {
        menu:
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String action = sc.next();
            switch (action) {
                case "buy":
                    selectCoffeeType(coffeeMachineIngredients);
                    break;
                case "fill":
                    fillMachine(coffeeMachine);
                    break;
                case "take":
                    giveMoney(coffeeMachine);
                    break;
                case "remaining":
                    remainingIngredients();
                    break;
                case "exit":
                    break menu;
            }
        } while (true);
    }

    void remainingIngredients() {
        System.out.println("The caffe machine has: ");
        for (int id = 1; id < Ingredients.MONEY.getId(); id++) {
            System.out.println(coffeeMachine.get(Ingredients.returnIngredient(id)) + Ingredients.returnIngredient(id).getUnitInfo());
        }
        System.out.println("$" + coffeeMachine.get(Ingredients.MONEY) + " of money\n");

    }

    void selectCoffeeType(int[] coffeeMachineIngredients) {
        System.out.println("\n" +
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String choice = sc.next();
        switch (choice) {
            case "1":
                espresso(coffeeMachineIngredients);
                break;
            case "2":
                latte(coffeeMachineIngredients);
                break;
            case "3":
                cappuccino(coffeeMachineIngredients);
                break;
            case "back":

                break;
        }
    }

    int[] espresso(int[] coffeeMachineIngredients) {
        int[] ingredients = {250, 0, 16, 1, 4};
        Map<Ingredients, Integer> espressoIngredients = Map.of(Ingredients.WATER, 250, Ingredients.MILK, 0, Ingredients.BEANS, 16, Ingredients.CUPS, 1, Ingredients.MONEY, 4);
        makeCoffee(coffeeMachineIngredients);
        return coffeeMachineIngredients;
    }

    int[] latte(int[] coffeeMachineIngredients) {
        int[] ingredients = {350, 75, 20, 1, 7};
        makeCoffee(coffeeMachineIngredients);
        return coffeeMachineIngredients;
    }

    int[] cappuccino(int[] coffeeMachineIngredients) {
        int[] ingredients = {200, 100, 12, 1, 6};
        makeCoffee(coffeeMachineIngredients);
        return coffeeMachineIngredients;
    }

    void fillMachine(Map<Ingredients, Integer> coffeeMachine) {
        for (int i = 1; i < 5; i++) {
            System.out.println(Ingredients.returnIngredient(i).getFillInfo());;
            coffeeMachine.put(Ingredients.returnIngredient(i), coffeeMachine.get(Ingredients.returnIngredient(i)) + sc.nextInt());
        }
    }

    void giveMoney(Map<Ingredients, Integer> coffeeMachine) {
        System.out.println("I gave you $" + coffeeMachine.get(Ingredients.MONEY) + "\n");
        coffeeMachine.replace(Ingredients.MONEY, 0);
    }

    void makeCoffee(int[] ingredients) {
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
                case 0 -> System.out.println("Sorry, not enough water!");
                case 1 -> System.out.println("Sorry, not enough milk!");
                case 2 -> System.out.println("Sorry, not enough coffee beans!");
                case 3 -> System.out.println("Sorry, not enough disposable cups!");
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
    }
}
