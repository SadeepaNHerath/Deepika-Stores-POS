package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import iCET.service.thogakadePOS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchCustomerFormController implements Initializable {

    @FXML
    private AnchorPane searchCustomerWindow;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXTextField txtDob;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearch;

    Stage searchCustomerStage;

    List<Customer> customerList = thogakadePOS.getInstance().getCustomerList();

    @FXML
    void btnExitOnAction(ActionEvent event) {
        searchCustomerStage = (Stage) searchCustomerWindow.getScene().getWindow();
        searchCustomerStage.close();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String check = txtSearch.getText();
        for (Customer obj : customerList){
            if (obj.getId().equalsIgnoreCase(check)){
                txtName.setText(obj.getTitle() + " " + obj.getName());
                txtAddress.setText(obj.getAddress());
                txtContact.setText(obj.getContactNum());
                txtDob.setText(obj.getDob()+"");
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("User Not Found!");
        alert.setContentText("Invalid Customer ID. Please check and enter again.");
        alert.showAndWait();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtName.setEditable(false);
        txtAddress.setEditable(false);
        txtContact.setEditable(false);
        txtDob.setEditable(false);
    }
}
