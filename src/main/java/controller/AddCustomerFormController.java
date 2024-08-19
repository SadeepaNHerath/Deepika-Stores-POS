package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import iCET.service.thogakadePOS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Customer;

import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCustomerFormController implements Initializable {

    @FXML
    private AnchorPane addCustomerWindow;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnExit;

    @FXML
    private ComboBox<String> cmbTitle;

    @FXML
    private DatePicker dateDob;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private Label txtId;

    @FXML
    private JFXTextField txtName;

    Stage addCustomerStage;

    List<Customer> customerList = thogakadePOS.getInstance().getCustomerList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> titles = FXCollections.observableArrayList();
        titles.add("Mr.");
        titles.add("Mrs.");
        titles.add("Miss");
        cmbTitle.setItems(titles);

        txtId.setText(generateID());
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (isNoError()) {
            customerList.add(
                    new Customer(
                            txtId.getText(),
                            cmbTitle.getValue(),
                            txtName.getText(),
                            txtAddress.getText(),
                            txtContact.getText(),
                            dateDob.getValue()
                    )
            );
            cmbTitle.setValue(null);
            txtName.setText("");
            txtAddress.setText("");
            txtContact.setText("");
            dateDob.setValue(null);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Customer Added");
            alert.setContentText("Customer successfully added.");
            alert.showAndWait();
            txtId.setText(generateID());
        }
    }
    @FXML
    void btnExitOnAction (ActionEvent actionEvent){
        cmbTitle.setValue(null);
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
        dateDob.setValue(null);

        addCustomerStage = (Stage) addCustomerWindow.getScene().getWindow();
        addCustomerStage.close();
    }

    public boolean isNoError(){
        if (cmbTitle.getValue() == (null) || txtName.getText().isEmpty() || txtAddress.getText().isEmpty() || txtContact.getText().isEmpty() || dateDob.getValue() == (null)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Not completed!");
            alert.setContentText("Missing important information. Please fill all the details.");
            alert.showAndWait();
            return false;
        }
        return true;
    }

    String generateID(){
        if (customerList.isEmpty()) {
            return "C0001" ;
        }
        return ("C" + String.format("%04d",Integer.parseInt((customerList.get(customerList.size()-1).getId()).substring(1))+1));
    }
}