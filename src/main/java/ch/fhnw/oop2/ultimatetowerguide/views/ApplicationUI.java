package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class ApplicationUI extends BorderPane implements ViewMixin {
    private final TowerListPM model;
    private final TableView<TowerPM> view;

    private HeaderBar headerBar;
    private DetailView detailView;
    private EditView editView;

    public ApplicationUI(TowerListPM model, TableView view) {
        this.model = model;
        this.view = view;
        init();
    }

    @Override
    public void initializeControls() {
        headerBar = new HeaderBar(model, view);
        detailView = new DetailView(model, view);
        editView = new EditView(model);
    }

    @Override
    public void layoutControls() {
        setTop(headerBar);
        setCenter(detailView);
        setBottom(editView);
    }
}
