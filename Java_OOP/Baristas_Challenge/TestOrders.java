
public class TestOrders {
    public static void main(String[] args) {

        // Menu items
        // Item item1 = new Item("latte", 3.5);

        Item item2 = new Item("mocha", 3);

        // Item item3 = new Item("dripped coffee", 2);

        // Item item4 = new Item("capuccino", 4);

        // Order variables -- order1, order2 etc.

        Order order1 = new Order("Cindhuri");

        // Order order2 = new Order("Jimmy");

        // Order order3 = new Order("Noah");

        // Order order4 = new Order("Sam");

        // Application Simulations

        // order2.addItem(item1);

        // order3.addItem(item4);

        order1.addItem(item2);

        // order1.ready = true;

        // order4.addItem(item1);
        // order4.addItem(item1);
        // order4.total += item1.price * 2;

        // order2.ready = true;

        order1.display();
        // order2.display();
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.name);
        // System.out.printf("Total: %s\n", order1.total);
        // System.out.printf("Ready: %s\n", order1.ready);
    }
}
