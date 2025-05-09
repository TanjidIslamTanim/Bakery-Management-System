import java.util.*;

public class Order implements Menu {
    private static int counter = 1;
    private int orderId;
    private List<BakeryItem> items = new ArrayList<>();
    private String status;

    private static final Map<String, Integer> inventory = new HashMap<>();

    static {
        inventory.put(CHOC_CAKE, 10);
        inventory.put(VANILLA_CAKE, 8);
        inventory.put(WHITE_BREAD, 15);
        inventory.put(WHOLEMEAL_BREAD, 12);
        inventory.put(CHOC_CHIP_COOKIE, 20);
        inventory.put(PEANUT_COOKIE, 18);
        inventory.put(FRUIT_PASTRY, 10);
        inventory.put(CREAM_PASTRY, 10);
    }

    public Order() {
        this.orderId = counter++;
        this.status = "Pending";
    }

    public void setInProgress() {
        if (status.equals("Pending")) {
            this.status = "In Progress";
        }
    }

    public void addItem(BakeryItem item) {
        int stock = inventory.getOrDefault(item.getName(), 0);
        if (item.getQuantity() <= stock) {
            inventory.put(item.getName(), stock - item.getQuantity());
            items.add(item);
        } else {
            System.out.println("Insufficient stock for " + item.getName() + ". Available: " + stock);
        }
    }

    public void displayOrder(String customerName, String contact) {
        System.out.printf("Order #%d for %s (%s):%n", orderId, customerName, contact);
        if (items.isEmpty()) {
            System.out.println("No items in this order.");
        } else {
            for (BakeryItem item : items) {
                item.displayItem();
            }
        }
        System.out.println("Order Status: " + status);
        System.out.printf("Total: RM%.2f%n", getTotal());
    }

    public double getTotal() {
        return items.stream().mapToDouble(BakeryItem::getTotalPrice).sum();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<BakeryItem> getItems() {
        return items;
    }

    public static Map<String, Integer> getInventory() {
        return inventory;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n===== Bakery Menu =====");
        System.out.printf("%-3s %-25s %-12s %-10s%n", "No", "Item", "Price (RM)", "Available");
        System.out.println("---------------------------------------------------------");

        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 1, CHOC_CAKE, CHOC_CAKE_PRICE, inventory.get(CHOC_CAKE));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 2, VANILLA_CAKE, VANILLA_CAKE_PRICE, inventory.get(VANILLA_CAKE));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 3, WHITE_BREAD, WHITE_BREAD_PRICE, inventory.get(WHITE_BREAD));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 4, WHOLEMEAL_BREAD, WHOLEMEAL_BREAD_PRICE, inventory.get(WHOLEMEAL_BREAD));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 5, CHOC_CHIP_COOKIE, CHOC_CHIP_PRICE, inventory.get(CHOC_CHIP_COOKIE));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 6, PEANUT_COOKIE, PEANUT_PRICE, inventory.get(PEANUT_COOKIE));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 7, FRUIT_PASTRY, FRUIT_PASTRY_PRICE, inventory.get(FRUIT_PASTRY));
        System.out.printf("%-3d %-25s RM%-10.2f %-10d%n", 8, CREAM_PASTRY, CREAM_PASTRY_PRICE, inventory.get(CREAM_PASTRY));
    }

    @Override
    public double calculatePrice(String itemName, int quantity) {
        return switch (itemName) {
            case CHOC_CAKE -> CHOC_CAKE_PRICE * quantity;
            case VANILLA_CAKE -> VANILLA_CAKE_PRICE * quantity;
            case WHITE_BREAD -> WHITE_BREAD_PRICE * quantity;
            case WHOLEMEAL_BREAD -> WHOLEMEAL_BREAD_PRICE * quantity;
            case CHOC_CHIP_COOKIE -> CHOC_CHIP_PRICE * quantity;
            case PEANUT_COOKIE -> PEANUT_PRICE * quantity;
            case FRUIT_PASTRY -> FRUIT_PASTRY_PRICE * quantity;
            case CREAM_PASTRY -> CREAM_PASTRY_PRICE * quantity;
            default -> 0.0;
        };
    }

    public double getUnitPrice(String itemName) {
        return calculatePrice(itemName, 1);
    }

    public String getItemNameByNumber(int number) {
        return switch (number) {
            case 1 -> CHOC_CAKE;
            case 2 -> VANILLA_CAKE;
            case 3 -> WHITE_BREAD;
            case 4 -> WHOLEMEAL_BREAD;
            case 5 -> CHOC_CHIP_COOKIE;
            case 6 -> PEANUT_COOKIE;
            case 7 -> FRUIT_PASTRY;
            case 8 -> CREAM_PASTRY;
            default -> null;
        };
    }
}
