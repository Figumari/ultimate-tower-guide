package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class PresentationView extends GridPane implements ViewMixin{

    private final TowerListPM model;

    private Label labelRank;
    private Label labelBuilding;
    private Label labelCity;
    private Label labelHeight;

    public PresentationView(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        labelRank = new Label();
        labelBuilding = new Label("test");
        labelCity = new Label();
        labelHeight = new Label();
    }

    @Override
    public void layoutControls() {
        add(labelBuilding, 0, 0);
    }

    @Override
    public void addBindings() {
        labelRank.textProperty().bind(model.getTowers().get(1).rankProperty().asString());
        Bindings.bindBidirectional(labelBuilding.textProperty(), model.selectedTowerIdProperty(), new NumberStringConverter());
    }
}
