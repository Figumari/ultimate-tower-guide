package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class HeaderBar extends ToolBar implements ViewMixin {
    private final TowerListPM model;
    private final TableView<TowerPM> view;

    private Button save;
    private Button add;
    private Button remove;

// ** Konstruktor ** //

    public HeaderBar(TowerListPM model, TableView<TowerPM> view) {
        this.model = model;
        this.view = view;
        init();
        getStyleClass().add("header");
    }

// ** Methoden ** //

    @Override
    public void initializeControls() {
        save = new Button();
        add = new Button();
        remove = new Button();
    }

    @Override
    public void layoutControls() {
        getItems().addAll(save, add, remove);
        save.getStyleClass().add("save-button");
        add.getStyleClass().add("add-button");
        remove.getStyleClass().add("remove-button");
    }

    @Override
    public void addEventHandlers() {
        save.addEventHandler(ActionEvent.ACTION, event -> model.saveFile());
//        todo Generate ID
        add.setOnAction(event -> addTower());
        remove.setOnAction(event -> model.getTowers().remove(view.getSelectionModel().getFocusedIndex()));

    }

    public void addTower() {
        model.getTowers().add(new TowerPM());

//        Springt an das Ende der Liste
        Platform.runLater(() -> view.scrollTo(model.getTowers().size()-1));
    }
}
