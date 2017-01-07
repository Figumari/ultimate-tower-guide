package ch.fhnw.oop2.ultimatetowerguide.presentationmodels;

import javafx.beans.property.*;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class TowerPM {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final IntegerProperty rank = new SimpleIntegerProperty();
    private final StringProperty building = new SimpleStringProperty();
    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty country = new SimpleStringProperty();
    private final DoubleProperty heightM = new SimpleDoubleProperty();
    private final DoubleProperty heightFT = new SimpleDoubleProperty();
    private final IntegerProperty floors = new SimpleIntegerProperty();
    private final IntegerProperty build = new SimpleIntegerProperty();
    private final StringProperty architect = new SimpleStringProperty();
    private final StringProperty architecturalStyle = new SimpleStringProperty();
    private final DoubleProperty cost = new SimpleDoubleProperty();
    private final StringProperty material = new SimpleStringProperty();
    private final DoubleProperty longitude = new SimpleDoubleProperty();
    private final DoubleProperty latitude = new SimpleDoubleProperty();
    private final StringProperty imageURL = new SimpleStringProperty();

// ** Konstruktoren ** //

    public TowerPM() {
    }

    public TowerPM(String[] line) {
        setId(Integer.valueOf(line[0]));
        setRank(Integer.valueOf(line[1]));
        setBuilding(line[2]);
        setCity(line[3]);
        setCountry(line[4]);
        setHeightM(Double.valueOf(line[5]));
        setHeightFT(Double.valueOf(line[6]));
        setFloors(Integer.valueOf(line[7]));
        setBuild(Integer.valueOf(line[8]));
        setArchitect(line[9]);
        setArchitecturalStyle(line[10]);
        setCost(Double.valueOf(line[11]));
        setMaterial(line[12]);
        setLongitude(Double.valueOf(line[13]));
        setLatitude(Double.valueOf(line[14]));

//        Warum muss die letzte Instanz so abgesichert werden?
        if (line.length >= 16) {
            setImageURL(line[15]);
        } else {
            setImageURL("");
        }
//        setImageURL(line[15]);
    }

//    Erzeugt einen String für das Abspeichern einer Datei.
//??    Geht das auch anders?
    public String getPersonAsString() {
        return id.getValue()+";"+
                rank.getValue()+";"+
                building.getValue()+";"+
                city.getValue()+";"+
                country.getValue()+";"+
                heightM.getValue()+";"+
                heightFT.getValue()+";"+
                floors.getValue()+";"+
                build.getValue()+";"+
                architect.getValue()+";"+
                architecturalStyle.getValue()+";"+
                cost.getValue()+";"+
                material.getValue()+";"+
                longitude.getValue()+";"+
                latitude.getValue()+";"+
                imageURL.getValue()+";";
    }

// ** Methoden ** //

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getRank() {
        return rank.get();
    }

    public IntegerProperty rankProperty() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank.set(rank);
    }

    public String getBuilding() {
        return building.get();
    }

    public StringProperty buildingProperty() {
        return building;
    }

    public void setBuilding(String building) {
        this.building.set(building);
    }

    public String getCity() {
        return city.get();
    }

    public StringProperty cityProperty() {
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public double getHeightM() {
        return heightM.get();
    }

    public DoubleProperty heightMProperty() {
        return heightM;
    }

    public void setHeightM(double heightM) {
        this.heightM.set(heightM);
    }

    public double getHeightFT() {
        return heightFT.get();
    }

    public DoubleProperty heightFTProperty() {
        return heightFT;
    }

    public void setHeightFT(double heightFT) {
        this.heightFT.set(heightFT);
    }

    public int getFloors() {
        return floors.get();
    }

    public IntegerProperty floorsProperty() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors.set(floors);
    }

    public int getBuild() {
        return build.get();
    }

    public IntegerProperty buildProperty() {
        return build;
    }

    public void setBuild(int build) {
        this.build.set(build);
    }

    public String getArchitect() {
        return architect.get();
    }

    public StringProperty architectProperty() {
        return architect;
    }

    public void setArchitect(String architect) {
        this.architect.set(architect);
    }

    public String getArchitecturalStyle() {
        return architecturalStyle.get();
    }

    public StringProperty architecturalStyleProperty() {
        return architecturalStyle;
    }

    public void setArchitecturalStyle(String architecturalStyle) {
        this.architecturalStyle.set(architecturalStyle);
    }

    public double getCost() {
        return cost.get();
    }

    public DoubleProperty costProperty() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost.set(cost);
    }

    public String getMaterial() {
        return material.get();
    }

    public StringProperty materialProperty() {
        return material;
    }

    public void setMaterial(String material) {
        this.material.set(material);
    }

    public double getLongitude() {
        return longitude.get();
    }

    public DoubleProperty longitudeProperty() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude.set(longitude);
    }

    public double getLatitude() {
        return latitude.get();
    }

    public DoubleProperty latitudeProperty() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude.set(latitude);
    }

    public String getImageURL() {
        return imageURL.get();
    }

    public StringProperty imageURLProperty() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL.set(imageURL);
    }
}
