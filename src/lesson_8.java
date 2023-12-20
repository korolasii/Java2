public class lesson_8 {
    public static void main() {

        Currency usd = new Currency("USD", 1.0);
        Currency eur = new Currency("EUR", 0.85);


        User user1 = new User("John", "Doe", "john@example.com");
        RegularUser regularUser = new RegularUser(3);
        PremiumUser premiumUser = new PremiumUser(true);


        BankAccount account1 = new BankAccount(user1, usd, 1000.0);
        BankAccount account2 = new BankAccount(user1, eur, 500.0);


        account1.deposit(500.0);
        account1.withdraw(200.0);
        account1.convertBalance(eur);

        account2.deposit(300.0);
        account2.withdraw(100.0);
        account2.convertBalance(usd);

        System.out.println("Account 1 Information:");
        account1.displayAccountInfo();
        System.out.println("\nAccount 2 Information:");
        account2.displayAccountInfo();
    }
}


class Currency {
    private String code;
    private double exchangeRate;

    public Currency(String code, double exchangeRate) {
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}


class User {
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void displayUserInfo() {
        System.out.println("User: " + firstName + " " + lastName + ", Email: " + email);
    }
}


abstract class UserType {
    public abstract void displayUserInfo();
}


class RegularUser extends UserType {
    private int activityLevel;

    public RegularUser(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Regular User: Activity Level " + activityLevel);
    }

    public void changeActivityLevel(int newLevel) {
        this.activityLevel = newLevel;
    }
}


class PremiumUser extends UserType {
    private boolean isPremium;

    public PremiumUser(boolean isPremium) {
        this.isPremium = isPremium;
    }

    @Override
    public void displayUserInfo() {
        System.out.println("Premium User: Premium Status " + isPremium);
    }

    public void changePremiumStatus(boolean newStatus) {
        this.isPremium = newStatus;
    }
}


class BankAccount {
    private User accountOwner;
    private Currency currency;
    private double balance;

    public BankAccount(User accountOwner, Currency currency, double balance) {
        this.accountOwner = accountOwner;
        this.currency = currency;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " " + currency.getCode());
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + " " + currency.getCode());
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void convertBalance(Currency newCurrency) {
        double convertedBalance = balance * (newCurrency.getExchangeRate() / currency.getExchangeRate());
        System.out.println("Converted balance to " + newCurrency.getCode() + ": " + convertedBalance);
    }

    public void displayAccountInfo() {
        accountOwner.displayUserInfo();
        System.out.println("Balance: " + balance + " " + currency.getCode());
    }
}


