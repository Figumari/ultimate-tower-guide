package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import javafx.scene.control.SplitPane;

/**
 * Created by Mario Winiker on 05.01.17.
 */
public class DetailView extends SplitPane implements ViewMixin {
    private final TowerListPM model;

    private ListNav listNav;
    private PresentationView presentationView;

    public DetailView(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        listNav = new ListNav(model);
        presentationView = new PresentationView(model);
    }

    @Override
    public void layoutControls() {
        getItems().addAll(listNav, presentationView);
    }
}
