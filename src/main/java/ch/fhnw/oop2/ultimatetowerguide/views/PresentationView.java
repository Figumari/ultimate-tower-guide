package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import com.sun.xml.internal.rngom.ast.builder.GrammarSection;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class PresentationView extends GridPane implements ViewMixin{

    private final TowerListPM model;

    private Label labelRank;
    private Label labelBuilding;
    private Label labelLocation;
    private Label labelHeight;
    private ImageView imageView;

    public PresentationView(TowerListPM model) {
        this.model = model;
        init();
        getStyleClass().add("presentation");
    }

    @Override
    public void initializeControls() {
        labelRank = new Label();
        labelBuilding = new Label();
        labelLocation = new Label();
        labelHeight = new Label();
//        todo Immer das gleiche Bild.
        imageView = new ImageView("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Ping%27an_IFC%2C_2014-12-21.jpg/135px-Ping%27an_IFC%2C_2014-12-21.jpg");
    }

    @Override
    public void layoutControls() {
        add(labelRank, 0, 0);
        add(labelBuilding, 0, 1);
        add(labelLocation, 0, 2);
        add(labelHeight, 0, 3);
        add(imageView, 3, 0, 1, 7);
//        todo Komma und weiter Werte.
    }

    @Override
    public void addBindings() {
        TowerPM proxy = model.getTowerProxy();

        labelRank.textProperty().bind(proxy.rankProperty().asString());
        labelBuilding.textProperty().bind(proxy.buildingProperty());
        labelLocation.textProperty().bind(proxy.cityProperty().concat(", ").concat(proxy.countryProperty()));
        labelHeight.textProperty().bind(proxy.heightMProperty().asString().concat(" Meter"));

    }
}
