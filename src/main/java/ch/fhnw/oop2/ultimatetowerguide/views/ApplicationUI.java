package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import javafx.scene.layout.VBox;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class ApplicationUI extends VBox implements ViewMixin {
    private final TowerListPM model;

    private HeaderBar headerBar;
    private DetailView detailView;
    private EditView editView;

    public ApplicationUI(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        headerBar = new HeaderBar();
        detailView = new DetailView(model);
        editView = new EditView();
    }

    @Override
    public void layoutControls() {
        getChildren().addAll(headerBar, detailView, editView);
    }
}
