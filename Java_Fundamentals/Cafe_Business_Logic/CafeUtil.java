import java.util.ArrayList;

public class CafeUtil{
    public int getStreakGoal(){
        int count=0;
        for (int week = 1; week <= 10 ; week++){
            count += week;
        }
        return count;
    }

    public double getOrderTotal(double[] prices){
        int sum = 0;
        for (double price: prices){
            sum+=price;
        }
        return sum;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i<menuItems.size(); i++){
            System.out.println(i +" "+ menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        customers.add(userName);
        System.out.println("Hello," + userName);
        System.out.printf("There are %d people ahead of you.", customers.size());
    }
}