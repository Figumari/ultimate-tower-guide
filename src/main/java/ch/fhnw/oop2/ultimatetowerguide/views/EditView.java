package ch.fhnw.oop2.ultimatetowerguide.views;

import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerListPM;
import ch.fhnw.oop2.ultimatetowerguide.presentationmodels.TowerPM;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

import java.util.Locale;

/**
 * Created by Mario Winiker on 05.01.17.
 */
public class EditView extends GridPane implements ViewMixin {

    private final TowerListPM model;
    private static final Double meterInFeet = 3.28084;

    private final Label labelId = new Label("ID:");
    private final Label labelRank = new Label("Rang:");
    private final Label labelBuilding = new Label("Name:");
    private final Label labelCity = new Label("Stadt:");
    private final Label labelCountry = new Label("Land:");
    private final Label labelHeightM = new Label("Höhe (m):");
    private final Label labelHeightFT = new Label("Höhe (Fuss):");
    private final Label labelFloors = new Label("Stockwerke:");
    private final Label labelBuild = new Label("Baujahr:");
    private final Label labelArchitect = new Label("Architekt:");
    private final Label labelArchitecturalStyle = new Label("Architekturstil:");
    private final Label labelCost = new Label("Baukosten:");
    private final Label labelMaterial = new Label("Material:");
    private final Label labelLongitude = new Label("Längengrad:");
    private final Label labelLatitude = new Label("Breitengrad:");
//    private final Label labelImageURL = new Label("Bild-URL:");

    private TextField textFieldId;
    private TextField textFieldRank;
    private TextField textFieldBuilding;
    private TextField textFieldCity;
    private TextField textFieldCountry;
    private TextField textFieldHeightM;
    private Label labelHeightFTValue;
    private TextField textFieldFloors;
    private TextField textFieldBuild;
    private TextField textFieldArchitect;
    private TextField textFieldArchitecturalStyle;
    private TextField textFieldCost;
    private TextField textFieldMaterial;
    private TextField textFieldLongitude;
    private TextField textFieldLatitude;
//    private TextField textFieldImageURL;


    public EditView(TowerListPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        textFieldId = new TextField();
        textFieldRank = new TextField();
        textFieldBuilding = new TextField();
        textFieldCity = new TextField();
        textFieldCountry = new TextField();
        textFieldHeightM = new TextField();
        labelHeightFTValue = new Label();
        textFieldFloors = new TextField();
        textFieldBuild = new TextField();
        textFieldArchitect = new TextField();
        textFieldArchitecturalStyle = new TextField();
        textFieldCost = new TextField();
        textFieldMaterial = new TextField();
        textFieldLongitude = new TextField();
        textFieldLatitude = new TextField();
//        textFieldImageURL = new TextField();
    }

    @Override
    public void layoutControls() {
        add(labelId, 0, 0);
        add(labelBuilding, 0, 1);
        add(labelCity, 0, 2);
        add(labelCountry, 3, 2);
        add(labelHeightM, 0, 3);
        add(labelHeightFT, 3, 3);
        add(labelFloors, 0, 4);
        add(labelBuild, 3, 4);
        add(labelArchitect, 0, 5);
        add(labelArchitecturalStyle, 3, 5);
        add(labelCost, 0, 6);
        add(labelMaterial, 3, 6);
        add(labelLongitude, 0, 7);
        add(labelLatitude, 3, 7);
//        add(labelImageURL, 0, 8);

        add(textFieldBuilding, 1, 1);
        add(textFieldCity, 1, 2);
        add(textFieldCountry, 4, 2);
        add(textFieldHeightM, 1, 3);
        add(labelHeightFTValue, 4, 3);
        add(textFieldFloors, 1, 4);
        add(textFieldBuild, 4, 4);
        add(textFieldArchitect, 1, 5);
        add(textFieldArchitecturalStyle, 4, 5);
        add(textFieldCost, 1, 6);
        add(textFieldMaterial, 4, 6);
        add(textFieldLongitude, 1, 7);
        add(textFieldLatitude, 4, 7);
//        add(textFieldImageURL, 1, 8);
    }

//    deleteme @Override
//    public void addValueChangedListeners() {
//        textFieldHeightM.textProperty().addListener((observable, oldValue, newValue) -> {
//
//        });
//    }

    @Override
    public void addBindings() {
        TowerPM proxy = model.getTowerProxy();

        Bindings.bindBidirectional(textFieldId.textProperty(), proxy.idProperty(), new NumberStringConverter(new Locale("de", "CH")));
        Bindings.bindBidirectional(textFieldRank.textProperty(), proxy.rankProperty(), new NumberStringConverter(new Locale("de", "CH")));
        textFieldBuilding.textProperty().bindBidirectional(proxy.buildingProperty());
        textFieldCity.textProperty().bindBidirectional(proxy.cityProperty());
        textFieldCountry.textProperty().bindBidirectional(proxy.countryProperty());
        Bindings.bindBidirectional(textFieldHeightM.textProperty(), proxy.heightMProperty(), new NumberStringConverter(new Locale("de", "CH")));
        Bindings.bindBidirectional(labelHeightFTValue.textProperty(), proxy.heightFTProperty(), new NumberStringConverter(new Locale("de", "CH")));
        Bindings.bindBidirectional(textFieldFloors.textProperty(), proxy.floorsProperty(), new NumberStringConverter(new Locale("de", "CH")));
        Bindings.bindBidirectional(textFieldBuild.textProperty(), proxy.buildProperty(), new NumberStringConverter(new Locale("de", "CH")));
        textFieldArchitect.textProperty().bindBidirectional(proxy.architectProperty());
        textFieldArchitecturalStyle.textProperty().bindBidirectional(proxy.architecturalStyleProperty());
        Bindings.bindBidirectional(textFieldCost.textProperty(), proxy.costProperty(), new NumberStringConverter(new Locale("de", "CH")));
        textFieldMaterial.textProperty().bindBidirectional(proxy.materialProperty());
        Bindings.bindBidirectional(textFieldLongitude.textProperty(), proxy.longitudeProperty(), new NumberStringConverter(new Locale("de", "CH")));
        Bindings.bindBidirectional(textFieldLatitude.textProperty(), proxy.latitudeProperty(), new NumberStringConverter(new Locale("de", "CH")));
//        textFieldImageURL.textProperty().bindBidirectional(proxy.imageURLProperty());

//        question Wie kann ich das bidirektional machen?
//        Bindet Feet an Meter
        proxy.heightFTProperty().bind(proxy.heightMProperty().multiply(meterInFeet));
    }
}
