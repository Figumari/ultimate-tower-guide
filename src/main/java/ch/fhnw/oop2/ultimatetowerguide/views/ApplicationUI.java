package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import javafx.scene.layout.BorderPane;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class ApplicationUI extends BorderPane implements ViewMixin {
    private final TowerListPM model;

    private HeaderBar headerBar;
    private ListNav listNav;
    private DetailView detailView;

    public ApplicationUI(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        headerBar = new HeaderBar();
        listNav = new ListNav(model);
        detailView = new DetailView();
    }

    @Override
    public void layoutControls() {
        setTop(headerBar);
        setLeft(listNav);
        setCenter(detailView);
    }
}
