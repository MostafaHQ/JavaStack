public class Test {
    public static void main(String[] args) {

        BankAccount user = new BankAccount();
        user.deposit(500, "checking");
        user.deposit(1000, "saving");
        user.withdraw(300, "checking");
        user.getTotalMoney();
    }
}
