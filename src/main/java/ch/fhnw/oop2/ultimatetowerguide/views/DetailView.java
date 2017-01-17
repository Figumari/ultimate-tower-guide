package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;

/**
 * Created by Mario Winiker on 05.01.17.
 */
public class DetailView extends SplitPane implements ViewMixin {
    private final TowerListPM model;
    private final ListNav view;

    private PresentationView presentationView;

    public DetailView(TowerListPM model, ListNav view) {
        this.model = model;
        this.view = view;
        init();
        getStyleClass().add("detail");
    }

    @Override
    public void initializeControls() {
        presentationView = new PresentationView(model, view);
    }

    @Override
    public void layoutControls() {
        getItems().addAll(view, presentationView);
    }
}
