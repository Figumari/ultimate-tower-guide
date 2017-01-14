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
    private final TableView<TowerPM> view;

    private ListNav listNav;
    private PresentationView presentationView;

    public DetailView(TowerListPM model, TableView<TowerPM> view) {
        this.model = model;
        this.view = view;
        init();
        getStyleClass().add("detail");
    }

    @Override
    public void initializeControls() {
        listNav = new ListNav(model, view);
        presentationView = new PresentationView(model);
    }

    @Override
    public void layoutControls() {
        getItems().addAll(listNav, presentationView);
    }
}
