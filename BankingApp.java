import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankingApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking Management System");

        TextField nameField = new TextField();
        nameField.setPromptText("Customer Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Customer Email");

        TextField phoneField = new TextField();
        phoneField.setPromptText("Customer Phone");

        TextField addressField = new TextField();
        addressField.setPromptText("Customer Address");

        Button addCustomerButton = new Button("Add Customer");
        addCustomerButton.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();

            CustomerDAO customerDAO = new CustomerDAO();
            try {
                customerDAO.addCustomer(name, email, phone, address);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(nameField, emailField, phoneField, addressField, addCustomerButton);

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
