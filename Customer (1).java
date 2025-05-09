import java.util.*;

public class Customer {
    private String name;
    private String contact;
    private List<Order> orderHistory = new ArrayList<>();
    private Order activeOrder = new Order();

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public void addItemToOrder(BakeryItem item) {
        activeOrder.addItem(item);
    }

    public void finalizeOrder() {
        activeOrder.setStatus("Completed");
        orderHistory.add(activeOrder);
        System.out.println("\n===== ORDER FINALIZED =====");
        activeOrder.displayOrder(name, contact);
        activeOrder = new Order();
    }

    public void viewOrderHistory() {
        System.out.println("\n===== ORDER HISTORY =====");
        for (Order o : orderHistory) {
            o.displayOrder(name, contact);
            System.out.println();
        }
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
