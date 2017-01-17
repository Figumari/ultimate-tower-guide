package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class PresentationView extends GridPane implements ViewMixin{

    private final TowerListPM model;
    private final ListNav view;

    private Label labelRank;
    private Label labelBuilding;
    private Label labelLocation;
    private Label labelHeight;
    private ImageView imageView;

    public PresentationView(TowerListPM model, ListNav view) {
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
        imageView = new ImageView();
    }

    @Override
    public void layoutControls() {
        add(labelRank, 1, 0);
        add(labelBuilding, 1, 1);
        add(labelLocation, 1, 2);
        add(labelHeight, 1, 3);
        add(imageView, 2, 0, 1, 5);

        ColumnConstraints cc = new ColumnConstraints();
        cc.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(cc);

        ColumnConstraints cc1 = new ColumnConstraints();
        cc1.setHalignment(HPos.RIGHT);
        getColumnConstraints().add(cc1);

        imageView.setPreserveRatio(true);
        imageView.setFitWidth(200);

        labelRank.getStyleClass().add("rank");
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
