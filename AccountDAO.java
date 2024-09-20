import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public void createAccount(int customerId, String accountType, double initialBalance) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO accounts (customer_id, account_type, balance) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customerId);
        stmt.setString(2, accountType);
        stmt.setDouble(3, initialBalance);
        stmt.executeUpdate();
        System.out.println("Account created successfully.");
    }

    public void getAccountById(int accountId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM accounts WHERE account_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, accountId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Account ID: " + rs.getInt("account_id"));
            System.out.println("Customer ID: " + rs.getInt("customer_id"));
            System.out.println("Account Type: " + rs.getString("account_type"));
            System.out.println("Balance: " + rs.getDouble("balance"));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(int accountId, double amount) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, amount);
        stmt.setInt(2, accountId);
        stmt.executeUpdate();
        System.out.println("Deposit successful.");
    }

    public void withdraw(int accountId, double amount) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setDouble(1, amount);
        stmt.setInt(2, accountId);
        stmt.setDouble(3, amount);
        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
