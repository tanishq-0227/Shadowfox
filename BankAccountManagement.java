import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountManagement {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(50);
        System.out.println("Current Balance: " + account.getBalance());
        System.out.println("Transaction History: " + account.getTransactionHistory());
    }

    static class BankAccount {
        private double balance;
        private List<String> transactionHistory;

        public BankAccount() {
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                transactionHistory.add("Deposited: " + amount);
            } else {
                throw new IllegalArgumentException("Deposit amount must be positive");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionHistory.add("Withdrew: " + amount);
            } else {
                throw new IllegalArgumentException("Invalid withdrawal amount");
            }
        }

        public double getBalance() {
            return balance;
        }

        public List<String> getTransactionHistory() {
            return new ArrayList<>(transactionHistory);
        }
    }

    // Unit Tests
    static class BankAccountTest {
        private BankAccount account;

        @BeforeEach
        void setUp() {
            account = new BankAccount();
        }

        @Test
        void testDeposit() {
            account.deposit(100.0);
            assertEquals(100.0, account.getBalance());
            assertEquals(1, account.getTransactionHistory().size());
            assertEquals("Deposited: 100.0", account.getTransactionHistory().get(0));
        }

        @Test
        void testWithdraw() {
            account.deposit(100.0);
            account.withdraw(50.0);
            assertEquals(50.0, account.getBalance());
            assertEquals(2, account.getTransactionHistory().size());
            assertEquals("Withdrew: 50.0", account.getTransactionHistory().get(1));
        }

        @Test
        void testBalanceInquiry() {
            assertEquals(0.0, account.getBalance());
            account.deposit(200.0);
            assertEquals(200.0, account.getBalance());
        }

        @Test
        void testTransactionHistory() {
            account.deposit(100.0);
            account.withdraw(50.0);
            assertEquals(2, account.getTransactionHistory().size());
        }

        @Test
        void testInvalidDeposit() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                account.deposit(-10.0);
            });
            assertEquals("Deposit amount must be positive", exception.getMessage());
        }

        @Test
        void testInvalidWithdrawal() {
            account.deposit(100.0);
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                account.withdraw(150.0);
            });
            assertEquals("Invalid withdrawal amount", exception.getMessage());
        }
    }
}
