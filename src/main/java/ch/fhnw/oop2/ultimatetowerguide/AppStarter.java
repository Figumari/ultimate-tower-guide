package ch.fhnw.oop2.ultimatetowerguide;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.views.ApplicationUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class AppStarter extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        TowerListPM model = new TowerListPM();

        Parent rootPane = new ApplicationUI(model);

        Scene scene = new Scene(rootPane);

        primaryStage.setTitle("Ultimate Tower Guide");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {launch(args);
    }
}
