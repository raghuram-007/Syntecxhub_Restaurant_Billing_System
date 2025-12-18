import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantBillingSystem {

    static ArrayList<MenuItem> menu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize menu
        menu.add(new MenuItem(1, "Burger", 120));
        menu.add(new MenuItem(2, "Pizza", 250));
        menu.add(new MenuItem(3, "Pasta", 180));

        while (true) {
            System.out.println("\n--- Restaurant Billing System ---");
            System.out.println("1. View Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Enter a number.");
                sc.next();
                continue;
            }

            switch (choice) {
                case 1 -> viewMenu();
                case 2 -> addMenuItem();
                case 3 -> removeMenuItem();
                case 4 -> placeOrder();
                case 5 -> {
                    System.out.println("Exiting system. Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void viewMenu() {
        System.out.println("\n--- Menu ---");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
    }

    static void addMenuItem() {
        sc.nextLine(); // Consume newline
        System.out.print("Enter item name: ");
        String name = sc.nextLine();
        System.out.print("Enter item price: ");
        double price = sc.nextDouble();
        int id = menu.size() + 1;
        menu.add(new MenuItem(id, name, price));
        System.out.println("Item added successfully!");
    }

    static void removeMenuItem() {
        System.out.print("Enter item ID to remove: ");
        int id = sc.nextInt();
        boolean removed = menu.removeIf(item -> item.getId() == id);
        if (removed) {
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Invalid item ID.");
        }
    }

    static void placeOrder() {
        sc.nextLine(); // Consume newline
        ArrayList<MenuItem> orderItems = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        double total = 0;
        while (true) {
            viewMenu();
            System.out.print("Enter item ID to order (0 to finish): ");
            int id = sc.nextInt();
            if (id == 0) break;
            MenuItem selected = null;
            for (MenuItem item : menu) {
                if (item.getId() == id) {
                    selected = item;
                    break;
                }
            }
            if (selected == null) {
                System.out.println("Invalid item ID.");
                continue;
            }
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            orderItems.add(selected);
            quantities.add(qty);
            total += selected.getPrice() * qty;
        }

        double gst = total * 0.05; // 5% GST
        double finalAmount = total + gst;

        System.out.println("\n--- Bill ---");
        System.out.printf("%-20s %-10s %-10s%n", "Item", "Qty", "Price");
        for (int i = 0; i < orderItems.size(); i++) {
            System.out.printf("%-20s %-10d %-10.2f%n",
                    orderItems.get(i).getName(), quantities.get(i),
                    orderItems.get(i).getPrice() * quantities.get(i));
        }
        System.out.printf("\n%-20s %-10s %-10.2f%n", "Subtotal", "", total);
        System.out.printf("%-20s %-10s %-10.2f%n", "GST (5%)", "", gst);
        System.out.printf("%-20s %-10s %-10.2f%n", "Total Amount", "", finalAmount);
    }
}
