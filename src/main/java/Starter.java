import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Starter extends Application {
    public static void main(String[] args) {

        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/dash_form.fxml"))));
        stage.getIcons().add(new Image(getClass().getResourceAsStream("img/Logo.png")));
        stage.setTitle("Deepika Stores POS System");
        stage.show();
    }
}