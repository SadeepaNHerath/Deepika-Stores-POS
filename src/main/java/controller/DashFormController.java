package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class DashFormController {

    @FXML
    private JFXButton btnAddCustomer;

    @FXML
    private JFXButton btnDeleteCustomer;

    @FXML
    private JFXButton btnExit;

    @FXML
    private JFXButton btnSearchCustomer;

    @FXML
    private JFXButton btnUpdateCustomer;

    @FXML
    private AnchorPane mainWindow;

    Stage mainStage;

    @FXML
    void btnAddCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/add_customer_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/delete_customer_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        mainStage = (Stage) mainWindow.getScene().getWindow();
        mainStage.close();
    }

    @FXML
    void btnSearchCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/search_customer_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateCustomerOnAction(ActionEvent event) {
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/update_customer_form.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
