import java.util.ArrayList;

public class Item{
    String name;
    double price;
}

public class Order{
    String name;
    double total;
    boolean ready;
    ArrayList<Item>items;
}