public class BankAccount {

    private double checkingBalance;
    private double savingBalance;
    public static int numberOfAccount = 0;
    public static double totalStoredMoney = 0;

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingBalance = 0;
        numberOfAccount++;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public void setSavingsBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public void deposit(double amountOfMoney, String type) {
        if (type == "checking") {
            this.checkingBalance += amountOfMoney;
            totalStoredMoney += amountOfMoney;
        } else if (type == "saving") {
            this.savingBalance += amountOfMoney;
            totalStoredMoney += amountOfMoney;
        }
    }

    public void withdraw(double amountOfMoney, String type) {
        if (type == "checking" && this.checkingBalance >= amountOfMoney) {
            checkingBalance -= amountOfMoney;
            totalStoredMoney -= amountOfMoney;
        } else if (type == "saving" && this.savingBalance >= amountOfMoney) {
            savingBalance -= amountOfMoney;
            totalStoredMoney -= amountOfMoney;
        }
    }

    public void getTotalMoney() {
        System.out.printf("Total Money %f\n", this.checkingBalance + this.savingBalance);
        System.out.printf("While checking is  %f\n", this.checkingBalance);
        System.out.printf("While saving is  %f\n", this.savingBalance);

    }
}