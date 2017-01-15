package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import com.sun.xml.internal.rngom.ast.builder.GrammarSection;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class PresentationView extends GridPane implements ViewMixin{

    private final TowerListPM model;
    private final TableView<TowerPM> view;

    private Label labelRank;
    private Label labelBuilding;
    private Label labelLocation;
    private Label labelHeight;
    private ImageView imageView;

    public PresentationView(TowerListPM model, TableView<TowerPM> view) {
        this.model = model;
        this.view = view;
        init();
        getStyleClass().add("presentation");
        Platform.runLater(() -> setImageView());
    }

    @Override
    public void initializeControls() {
        labelRank = new Label();
        labelBuilding = new Label();
        labelLocation = new Label();
        labelHeight = new Label();
//        todo Immer das gleiche Bild.
        imageView = new ImageView();
    }

    @Override
    public void layoutControls() {
        add(labelRank, 0, 0);
        add(labelBuilding, 0, 1);
        add(labelLocation, 0, 2);
        add(labelHeight, 0, 3);
        add(imageView, 1, 0, 1, 5);

        getColumnConstraints().add(new ColumnConstraints(400));

        imageView.setPreserveRatio(true);
        imageView.setFitWidth(200);

//        deleteme
        setGridLinesVisible(true);

        labelRank.getStyleClass().add("rank");
//        todo Komma und weiter Werte.
    }

    @Override
    public void addValueChangedListeners() {
        view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> setImageView());
    }

    @Override
    public void addBindings() {
        TowerPM proxy = model.getTowerProxy();

        labelRank.textProperty().bind(proxy.rankProperty().asString());
        labelBuilding.textProperty().bind(proxy.buildingProperty());
        labelLocation.textProperty().bind(proxy.cityProperty().concat(", ").concat(proxy.countryProperty()));
        labelHeight.textProperty().bind(proxy.heightMProperty().asString().concat(" Meter"));
    }

    public void setImageView() {
        TowerPM proxy = model.getTowerProxy();

        try {
            Image temp = new Image(proxy.getImageURL());
            imageView.setImage(temp);
        } catch (Exception e) {
            imageView.setImage(new Image("/imageException.png"));
        }
    }
}
