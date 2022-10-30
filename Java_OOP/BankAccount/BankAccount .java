public class BankAccount {

    private double checkingBalance;
    private double savingBalance;
    private static int numberOfAccount = 0;
    public static double totalStoredMoney = 0;

    public BankAccount() {
        double checkingBalance; 
        double savingBalance;
        totalStoredMoney++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setCheckingBalance(Double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(Double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public void deposit(double amountOfMoney, String type) {
        if (type == "checking") {
            checkingBalance += amountOfMoney;
            totalStoredMoney += amountOfMoney;
        } else if (type == "saving") {
            savingBalance += amountOfMoney;
            totalStoredMoney += amountOfMoney;
        }

    }

}