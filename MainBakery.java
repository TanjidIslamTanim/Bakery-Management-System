import java.util.*;

public class MainBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Order> allOrders = new ArrayList<>();

        System.out.println("=== Welcome to the Bakery Management System ===");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contact = scanner.nextLine();

        Customer customer = new Customer(name, contact);
        boolean running = true;

        while (running) {
            Order tempOrder = new Order();
            tempOrder.displayMenu();

            while (true) {
                System.out.println("\nCurrent Order Status: " + tempOrder.getStatus());
                System.out.print("Enter item number (1-8) or 0 to finish order: ");
                int itemNum = scanner.nextInt();
                scanner.nextLine();

                if (itemNum == 0) break;

                String itemName = tempOrder.getItemNameByNumber(itemNum);
                if (itemName == null) {
                    System.out.println("Invalid item number.");
                    continue;
                }

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                double unitPrice = tempOrder.getUnitPrice(itemName);
                int stock = Order.getInventory().get(itemName);

                if (quantity > stock) {
                    System.out.println("Only " + stock + " units available.");
                    continue;
                }

                BakeryItem item = new BakeryItem(itemName, unitPrice, quantity);
                customer.addItemToOrder(item);
                tempOrder.setInProgress(); // 🔄 switch to "In Progress"
            }

            customer.finalizeOrder();
            allOrders.addAll(customer.getOrderHistory());

            System.out.print("Add another order? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                running = false;
            }
        }

        System.out.print("\nView order history? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            customer.viewOrderHistory();
        }

        System.out.print("Generate sales report? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            Report report = new Report(allOrders);
            report.generateReport();
        }

        scanner.close();
        System.out.println("\nThank you for using the Bakery Management System!");
    }
}
