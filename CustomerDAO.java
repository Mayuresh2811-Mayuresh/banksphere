import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public void addCustomer(String name, String email, String phone, String address) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO customers (name, email, phone, address) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, phone);
        stmt.setString(4, address);
        stmt.executeUpdate();
        System.out.println("Customer added successfully.");
    }

    public void getCustomerById(int customerId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM customers WHERE customer_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Customer ID: " + rs.getInt("customer_id"));
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Email: " + rs.getString("email"));
            System.out.println("Phone: " + rs.getString("phone"));
            System.out.println("Address: " + rs.getString("address"));
        } else {
            System.out.println("Customer not found.");
        }
    }
}
