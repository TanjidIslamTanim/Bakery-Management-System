public interface Menu {
    // Final item names and prices
    final public String CHOC_CAKE = "Chocolate Cake";
    final public String VANILLA_CAKE = "Vanilla Cake";
    final public double CHOC_CAKE_PRICE = 10.00;
    final public double VANILLA_CAKE_PRICE = 9.00;

    final public String WHITE_BREAD = "White Bread";
    final public String WHOLEMEAL_BREAD = "Wholemeal Bread";
    final public double WHITE_BREAD_PRICE = 2.00;
    final public double WHOLEMEAL_BREAD_PRICE = 2.50;

    final public String CHOC_CHIP_COOKIE = "Chocolate Chip Cookie";
    final public String PEANUT_COOKIE = "Peanut Cookie";
    final public double CHOC_CHIP_PRICE = 1.50;
    final public double PEANUT_PRICE = 1.80;

    final public String FRUIT_PASTRY = "Fruit Pastry";
    final public String CREAM_PASTRY = "Cream Pastry";
    final public double FRUIT_PASTRY_PRICE = 3.00;
    final public double CREAM_PASTRY_PRICE = 3.50;

    // Abstract methods
   public void displayMenu();
   public double calculatePrice(String itemName, int quantity);
}
