package machine;

enum Ingredients {
    WATER("water", " ml of water", "Write how many ml of water you want to add:  ", "Sorry, not enough water!"),
    MILK("milk", " ml of milk", "Write how many ml of milk you want to add:  ", "Sorry, not enough milk!"),
    BEANS("beans", " g of coffee beans", "Write how many grams of coffee beans you want to add:  ", "Sorry, not enough coffee beans!"),
    CUPS("cups", " disposable cups", "Write how many disposable cups of coffee you want to add: ", "Sorry, not enough disposable cups!");

    private final String name;
    private final String unitInfo;
    private final String fillInfo;
    private final String apology;


    Ingredients(String name, String unitInfo, String fillInfo, String apology) {
        this.name = name;
        this.unitInfo = unitInfo;
        this.fillInfo = fillInfo;
        this.apology = apology;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getUnitInfo() {
        return unitInfo;
    }

    public String getFillInfo() {
        return fillInfo;
    }

    public String getApology() {
        return apology;
    }

    public static Ingredients returnIngredient(int id) {
        if (id == 1) return Ingredients.WATER;
        if (id == 2) return Ingredients.MILK;
        if (id == 3) return Ingredients.BEANS;
        if (id == 4) return Ingredients.CUPS;
        return null;
    }
}
