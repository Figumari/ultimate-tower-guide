package ch.fhnw.oop2.ultimatetowerguide.presentationmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class TowerListPM {
//    question Wie komme ich in den Resources Folder?
    private static final String FILE_NAME = "saved-towers.csv";
    private static final String SEMICOLON = ";";

//    question Warum final?
    private final IntegerProperty selectedTowerId = new SimpleIntegerProperty(-1);

    private final ObservableList<TowerPM> towers = FXCollections.observableArrayList();

    private final TowerPM towerProxy = new TowerPM();

// ** Konstruktor ** //

    public TowerListPM() {
//    Überträgt eine Liste von Türmen in eine ObservableList
        towers.addAll(readFromFile());
//        deleteme System.out.println(towerProxy.getPersonAsString());
//        deleteme saveFile();

        selectedTowerIdProperty().addListener((observable, oldValue, newValue) -> {
            TowerPM oldSelection = getTower(oldValue.intValue());
            TowerPM newSelection = getTower(newValue.intValue());

            if (oldSelection != null) {
                towerProxy.idProperty().unbindBidirectional(oldSelection.idProperty());
                towerProxy.rankProperty().unbindBidirectional(oldSelection.rankProperty());
                towerProxy.buildingProperty().unbindBidirectional(oldSelection.buildingProperty());
                towerProxy.cityProperty().unbindBidirectional(oldSelection.cityProperty());
                towerProxy.countryProperty().unbindBidirectional(oldSelection.countryProperty());
                towerProxy.heightMProperty().unbindBidirectional(oldSelection.heightMProperty());
                towerProxy.floorsProperty().unbindBidirectional(oldSelection.floorsProperty());
                towerProxy.buildProperty().unbindBidirectional(oldSelection.buildProperty());
                towerProxy.architectProperty().unbindBidirectional(oldSelection.architectProperty());
                towerProxy.architecturalStyleProperty().unbindBidirectional(oldSelection.architecturalStyleProperty());
                towerProxy.costProperty().unbindBidirectional(oldSelection.costProperty());
                towerProxy.materialProperty().unbindBidirectional(oldSelection.materialProperty());
                towerProxy.longitudeProperty().unbindBidirectional(oldSelection.longitudeProperty());
                towerProxy.latitudeProperty().unbindBidirectional(oldSelection.latitudeProperty());
                towerProxy.imageURLProperty().unbindBidirectional(oldSelection.imageURLProperty());
            }

            if (newSelection != null) {
                towerProxy.idProperty().bindBidirectional(newSelection.idProperty());
                towerProxy.rankProperty().bindBidirectional(newSelection.rankProperty());
                towerProxy.buildingProperty().bindBidirectional(newSelection.buildingProperty());
                towerProxy.cityProperty().bindBidirectional(newSelection.cityProperty());
                towerProxy.countryProperty().bindBidirectional(newSelection.countryProperty());
                towerProxy.heightMProperty().bindBidirectional(newSelection.heightMProperty());
                towerProxy.floorsProperty().bindBidirectional(newSelection.floorsProperty());
                towerProxy.buildProperty().bindBidirectional(newSelection.buildProperty());
                towerProxy.architectProperty().bindBidirectional(newSelection.architectProperty());
                towerProxy.architecturalStyleProperty().bindBidirectional(newSelection.architecturalStyleProperty());
                towerProxy.costProperty().bindBidirectional(newSelection.costProperty());
                towerProxy.materialProperty().bindBidirectional(newSelection.materialProperty());
                towerProxy.longitudeProperty().bindBidirectional(newSelection.longitudeProperty());
                towerProxy.latitudeProperty().bindBidirectional(newSelection.latitudeProperty());
                towerProxy.imageURLProperty().bindBidirectional(newSelection.imageURLProperty());
            }
        });
    }

// ** File einlesen ** //
//    Erstellt eine Liste von Türmen
    private List<TowerPM> readFromFile() {
        return getStreamOfLines(FILE_NAME).map(s -> new TowerPM(s.split(SEMICOLON))).collect(Collectors.toList());
//       deleteme return getStreamOfLines(FILE_NAME).skip(1).map(s -> new TowerPM(s.split(SEMICOLON))).collect(Collectors.toList());
    }

//    Gibt einen Stream vom Typ String zurück
    private Stream<String> getStreamOfLines(String fileName) {
        try {
            return Files.lines(getPath(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

//    Gibt den Pfad der Datei FILE_NAME zurück
    private Path getPath(String fileName) {
        try {
            return Paths.get(getClass().getResource(fileName).toURI());
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

// ** File abspeichern ** //

    public void saveFile() {
//        deleteme ArrayList arrayList = new ArrayList(towers.stream().map(TowerPM::getPersonAsString).collect(Collectors.toList()));
//        deleteme System.out.println(arrayList);
        try {
            Files.write(Paths.get("src/main/resources/saved-towers.csv"), towers.stream().map(TowerPM::getPersonAsString).collect(Collectors.toList()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

// ** Andere Methoden ** //

    public TowerPM getTower(int id) {
        return towers.stream().filter(towerPM -> towerPM.getId() == id).findAny().orElse(null);
    }

    public TowerPM getTowerProxy() {
        return towerProxy;
    }

    public ObservableList<TowerPM> getTowers() {
        return towers;
    }

    public int getSelectedTowerId() {
        return selectedTowerId.get();
    }

    public IntegerProperty selectedTowerIdProperty() {
        return selectedTowerId;
    }

    public void setSelectedTowerId(int selectedTowerId) {
        this.selectedTowerId.set(selectedTowerId);
    }
}
