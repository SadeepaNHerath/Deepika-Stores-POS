package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import iCET.service.thogakadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.util.List;
import java.util.Optional;

public class DeleteCustomerFormController {

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private AnchorPane deleteCustomerWindow;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearch;

    Stage deleteCustomerStage;

    List<Customer> customerList = thogakadePOS.getInstance().getCustomerList();

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String check = txtSearch.getText();
        for (int i=0 ; i<customerList.size() ; i++) {
            if (customerList.get(i).getId().equalsIgnoreCase(check)) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Delete Confirmation");
                alert.setHeaderText("Are you sure you want to delete this customer?");
                alert.setContentText("This action cannot be undone.");

                ButtonType buttonTypeYes = new ButtonType("Yes");
                ButtonType buttonTypeNo = new ButtonType("No");
                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == buttonTypeYes) {
                    customerList.remove(i);
                    txtName.setText("");
                    txtAddress.setText("");
                    txtContact.setText("");
                    Alert deleteAlert = new Alert(Alert.AlertType.INFORMATION);
                    deleteAlert.setTitle("Deleted");
                    deleteAlert.setHeaderText("Customer Deleted");
                    deleteAlert.setContentText("Customer successfully Deleted.");
                    deleteAlert.showAndWait();
                }
                return;
            }
        }
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        deleteCustomerStage = (Stage) deleteCustomerWindow.getScene().getWindow();
        deleteCustomerStage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String check = txtSearch.getText();
        for (Customer obj : customerList){
            if (obj.getId().equalsIgnoreCase(check)){
                txtName.setText(obj.getTitle() + " " + obj.getName());
                txtAddress.setText(obj.getAddress());
                txtContact.setText(obj.getContactNum());
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("User Not Found!");
        alert.setContentText("Invalid Customer ID. Please check and enter again.");
        alert.showAndWait();
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
    }

}
