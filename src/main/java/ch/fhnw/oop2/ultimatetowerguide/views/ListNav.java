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

    private TableView<TowerPM> listOfTowers;
    private TableColumn<TowerPM, Integer> rank;
    private TableColumn<TowerPM, String> name;
    private TableColumn location;
    private TableColumn<TowerPM, String> locationCity;
    private TableColumn<TowerPM, String> locationCountry;

    private Label totalTowers;

    public ListNav(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        listOfTowers = new TableView<>(model.getTowers());
        listOfTowers.setEditable(true);
        rank = new TableColumn<>("Rank");
//??        Wieso kann ich hier nicht mit Lambda arbeiten?
        rank.setCellValueFactory(new PropertyValueFactory<>("rank"));
        name = new TableColumn<>("Name");
        name.setCellValueFactory(param -> param.getValue().buildingProperty());
        location = new TableColumn("Location");
//        Subcolumns for Location
        locationCity = new TableColumn<>("City");
        locationCity.setCellValueFactory(param -> param.getValue().cityProperty());
        locationCountry = new TableColumn<>("Country");
        locationCountry.setCellValueFactory(param -> param.getValue().countryProperty());
        totalTowers = new Label();
    }

    @Override
    public void layoutControls() {
        location.getColumns().addAll(locationCity, locationCountry);
        listOfTowers.getColumns().addAll(rank, name, location);
        getChildren().addAll(listOfTowers, totalTowers);
    }
}
