import java.util.*;

public class Report {
    private List<Order> orders;

    public Report(List<Order> orders) {
        this.orders = orders;
    }

    public void generateReport() {
        int completedCount = 0;
        double totalRevenue = 0;
        Map<String, Integer> inventorySold = new HashMap<>();

        for (Order order : orders) {
            if (order.getStatus().equalsIgnoreCase("Completed")) {
                completedCount++;
                totalRevenue += order.getTotal();
                for (BakeryItem item : order.getItems()) {
                    inventorySold.put(item.getName(),
                        inventorySold.getOrDefault(item.getName(), 0) + item.getQuantity());
                }
            }
        }

        System.out.println("\n===== SALES REPORT =====");
        System.out.println("Total Completed Orders: " + completedCount);
        System.out.printf("Total Revenue: RM%.2f%n", totalRevenue);

        System.out.println("\n===== INVENTORY SOLD =====");
        for (Map.Entry<String, Integer> entry : inventorySold.entrySet()) {
            System.out.printf("%s: %d units%n", entry.getKey(), entry.getValue());
        }

        System.out.println("\n===== INVENTORY REMAINING =====");
        for (Map.Entry<String, Integer> entry : Order.getInventory().entrySet()) {
            System.out.printf("%s: %d units remaining%n", entry.getKey(), entry.getValue());
        }
    }
}
