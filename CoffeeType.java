package machine;

enum CoffeeType {
    ESPRESSO(50, 0, 16, 1, 4),
    LATTE(350, 75, 20, 1, 7),
    CAPPUCCINO(200, 100, 12, 1, 6);

    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int cups;
    private final int price;

    CoffeeType(int water, int milk, int coffeeBeans,int cups, int price) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.price = price;
    }

    int getWater() {
        return water;
    }

    int getMilk() {
        return milk;
    }

    int getCoffeeBeans() {
        return coffeeBeans;
    }

    int getCups() {
        return cups;
    }

    int getPrice() {
        return price;
    }

    static int returnIngredientAmount(CoffeeType coffeeType, int id) {
        if (id == 1) return coffeeType.getWater();
        if (id == 2) return coffeeType.getMilk();
        if (id == 3) return coffeeType.getCoffeeBeans();
        if (id == 4) return coffeeType.getCups();
        return 0;
    }
}
