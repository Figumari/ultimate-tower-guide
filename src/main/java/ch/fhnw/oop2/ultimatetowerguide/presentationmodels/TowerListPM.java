package ch.fhnw.oop2.ultimatetowerguide.presentationmodels;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class TowerListPM {
    private static final String FILE_NAME = "towers.csv";
    private static final String SEMICOLON = ";";

//??    Warum final?
    private final IntegerProperty selectedTowerId = new SimpleIntegerProperty(-1);

    private final ObservableList<TowerPM> towers = FXCollections.observableArrayList();

//    Überträgt eine Liste von Türmen in eine ObservableList
    public TowerListPM() {
        towers.addAll(readFromFile());
    }

//    Erstellt eine Liste von Türmen
    private List<TowerPM> readFromFile() {
        return getStreamOfLines(FILE_NAME).skip(1).map(s -> new TowerPM(s.split(SEMICOLON))).collect(Collectors.toList());
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
