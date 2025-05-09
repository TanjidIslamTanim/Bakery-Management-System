public class BakeryItem {
    private String name;
    private double unitPrice;
    private int quantity;

    public BakeryItem(String name, double unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void displayItem() {
        System.out.printf("%s x%d - RM%.2f%n", name, quantity, getTotalPrice());
    }
}
