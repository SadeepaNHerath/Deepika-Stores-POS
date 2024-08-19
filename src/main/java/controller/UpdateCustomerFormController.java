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

public class UpdateCustomerFormController {

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private JFXTextField txtTitle;

    @FXML
    private AnchorPane updateCustomerWindow;

    Stage updateCustomerStage;

    List<Customer> customerList = thogakadePOS.getInstance().getCustomerList();

    @FXML
    void btnExitOnAction(ActionEvent event) {
        updateCustomerStage = (Stage) updateCustomerWindow.getScene().getWindow();
        updateCustomerStage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String check = txtSearch.getText();
        for (Customer obj : customerList){
            if (obj.getId().equalsIgnoreCase(check)){
                txtTitle.setEditable(false);
                txtTitle.setText(obj.getTitle());
                txtName.setText( obj.getName());
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
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String check = txtSearch.getText();
        for (Customer obj : customerList){
            if (obj.getId().equalsIgnoreCase(check)){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Update Confirmation");
                alert.setHeaderText("Are you sure you want to Update this customer?");
                alert.setContentText(null);

                ButtonType buttonTypeYes = new ButtonType("Yes");
                ButtonType buttonTypeNo = new ButtonType("No");
                alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

                Optional<ButtonType> result = alert.showAndWait();

                if (result.isPresent() && result.get() == buttonTypeYes) {
                    obj.setName(txtName.getText());
                    obj.setAddress(txtAddress.getText());
                    obj.setContactNum(txtContact.getText());
                    txtName.setText("");
                    txtAddress.setText("");
                    txtContact.setText("");
                    txtTitle.setText("");
                    Alert deleteAlert = new Alert(Alert.AlertType.INFORMATION);
                    deleteAlert.setTitle("Update");
                    deleteAlert.setHeaderText("Customer Updated");
                    deleteAlert.setContentText("Customer successfully Updated.");
                    deleteAlert.showAndWait();
                }
                return;
            }
        }
    }

}
