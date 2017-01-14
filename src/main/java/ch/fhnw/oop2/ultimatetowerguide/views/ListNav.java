package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.beans.property.IntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import javax.security.auth.callback.Callback;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class ListNav extends VBox implements ViewMixin {
    private final TowerListPM model;

    private TableView<TowerPM> view;
    private TableColumn<TowerPM, Number> rank;
    private TableColumn<TowerPM, String> name;
    private TableColumn location;
    private TableColumn<TowerPM, String> locationCity;
    private TableColumn<TowerPM, String> locationCountry;

// ** Konstruktor ** //

    public ListNav(TowerListPM model, TableView<TowerPM> view) {
        this.model = model;
        this.view = view;
        init();
        getStyleClass().add("listnav");
    }

// ** Methoden ** //

    @Override
    public void initializeControls() {
        view.setItems(model.getTowers());
        view.setEditable(true);
        view.requestFocus();
        view.getSelectionModel().select(0);
        view.getFocusModel().focus(0);

        rank = new TableColumn<>("Rank");
        rank.setCellValueFactory(param -> param.getValue().rankProperty());
        name = new TableColumn<>("Name");
        name.setCellValueFactory(param -> param.getValue().buildingProperty());
        location = new TableColumn("Location");
//        Subcolumns for Location
        locationCity = new TableColumn<>("City");
        locationCity.setCellValueFactory(param -> param.getValue().cityProperty());
        locationCountry = new TableColumn<>("Country");
        locationCountry.setCellValueFactory(param -> param.getValue().countryProperty());
    }

    @Override
    public void layoutControls() {
        location.getColumns().addAll(locationCity, locationCountry);
        view.getColumns().addAll(rank, name, location);
        getChildren().addAll(view);
    }


    @Override
    public void addValueChangedListeners() {
//        Schaut, welche Reihe in der Tabele angewählt ist.
        view.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.setSelectedTowerId(view.getSelectionModel().getSelectedItem().getId());
            }
        });
    }
}
