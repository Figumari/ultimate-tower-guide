package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class HeaderBar extends HBox implements ViewMixin {
    private final TowerListPM model;

    private Button save;
    private Button add;
    private Button delete;

    public HeaderBar(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        save = new Button("s");
        add = new Button("+");
        delete = new Button("-");
    }

    @Override
    public void layoutControls() {
        getChildren().addAll(save, add, delete);
    }

    @Override
    public void addEventHandlers() {
        save.addEventHandler(ActionEvent.ACTION, event -> model.saveFile());
//        todo Bei Hinzufügen Sprung nach ganze hinten.
        add.setOnAction(event -> model.getTowers().add(new TowerPM()));
//        delete.setOnAction(event -> model.getTowers().remove();
    }
}
