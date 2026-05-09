package projectgroupd;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainPage extends Application {

    @Override
    public void start(Stage stage) {

        Label title = new Label(
                "⭐ Event Ticket Booking System ⭐"
        );

        title.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: purple;"
        );

        Button loginBtn = new Button("Login");

        Button exitBtn = new Button("Exit");

        loginBtn.setPrefWidth(200);
        exitBtn.setPrefWidth(200);

        loginBtn.setStyle(
                "-fx-background-color: purple;" +
                "-fx-text-fill: white;"
        );

        exitBtn.setStyle(
                "-fx-background-color: darkred;" +
                "-fx-text-fill: white;"
        );

        

        loginBtn.setOnAction(e -> {

            Projectgroupd system =
                    new Projectgroupd();

            try {

                Stage newStage = new Stage();

                system.start(newStage);

                stage.close();

            } catch (Exception ex) {

                ex.printStackTrace();

            }

        });

        

        exitBtn.setOnAction(e -> {

            stage.close();

        });

        VBox root = new VBox(20);

        root.setAlignment(Pos.CENTER);

        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                title,
                loginBtn,
                exitBtn
        );

        Scene scene =
                new Scene(root, 400, 300);

        stage.setTitle("Main Page");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }
}
