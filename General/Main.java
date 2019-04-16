package sample.General;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controllers.Controller;

import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../sources/mainSimple.fxml"));


        primaryStage.setTitle("adressbook");
        primaryStage.setMinHeight(480);
        primaryStage.setMinWidth(400);
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(700);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        
    }




    public static void main(String[] args) {
        launch(args);
    }
}
