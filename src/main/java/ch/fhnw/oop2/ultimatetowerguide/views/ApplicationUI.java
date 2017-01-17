package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import javafx.scene.layout.BorderPane;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class ApplicationUI extends BorderPane implements ViewMixin {
    private final TowerListPM model;
    private final ListNav view;

    private HeaderBar headerBar;
    private DetailView detailView;
    private EditView editView;

    public ApplicationUI(TowerListPM model, ListNav view) {
        this.model = model;
        this.view = view;
        init();
    }

    @Override
    public void initializeControls() {
        headerBar = new HeaderBar(model, view);
        detailView = new DetailView(model, view);
        editView = new EditView(model, view);
    }

    @Override
    public void layoutControls() {
        setTop(headerBar);
        setCenter(detailView);
        setBottom(editView);
    }
}
