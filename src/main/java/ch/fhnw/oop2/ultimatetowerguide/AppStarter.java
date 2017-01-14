package ch.fhnw.oop2.ultimatetowerguide;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import ch.fhnw.oop2.ultimatetowerguide.views.ApplicationUI;
import com.sun.tools.javadoc.Start;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class AppStarter extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        TowerListPM model = new TowerListPM();
        TableView<TowerPM> view = new TableView<>();

        Parent rootPane = new ApplicationUI(model, view);

        Scene scene = new Scene(rootPane);

        String stylesheet = getClass().getResource("style.css").toExternalForm();
        scene.getStylesheets().add(stylesheet);

        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/tower-icon.png")));
        primaryStage.setTitle("Ultimate Tower Guide");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {launch(args);
    }
}
