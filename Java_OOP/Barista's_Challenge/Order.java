import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {
        this.name = "Guest";
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItem() {
        return items;
    }

    public void setItem(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public double getOrderTotal() {
        double sum = 0;
        for (Item i : items) {
            sum += i.getPrice();
        }
        return sum;
    }

    public void display() {
        System.out.println("Customer Name:" + name);
        for (Item i : this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting.Your order will be ready soon.";
        }
    }
}