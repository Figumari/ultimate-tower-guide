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
public class ListNav extends TableView<TowerPM> implements ViewMixin {
    private final TowerListPM model;

    private TableColumn<TowerPM, Number> rank;
    private TableColumn<TowerPM, String> name;
    private TableColumn location;
    private TableColumn<TowerPM, String> locationCity;
    private TableColumn<TowerPM, String> locationCountry;

// ** Konstruktor ** //

    public ListNav(TowerListPM model) {
        this.model = model;
        init();
        getStyleClass().add("listnav");
    }

// ** Methoden ** //

    @Override
    public void initializeControls() {
        setItems(model.getTowers());
        setEditable(true);
        requestFocus();
        getSelectionModel().select(0);
        getFocusModel().focus(0);

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
        getColumns().addAll(rank, name, location);
    }


    @Override
    public void addValueChangedListeners() {
//        Schaut, welche Reihe in der Tabele angewählt ist.
        getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.setSelectedTowerId(getSelectionModel().getSelectedItem().getId());
            }
        });
    }
}
