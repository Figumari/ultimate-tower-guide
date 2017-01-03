package ch.fhnw.oop2.ultimatetowerguide.views;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public interface ViewMixin {
    default void init() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    void initializeControls();

    void layoutControls();

    default void addEventHandlers() {
    }

    default void addValueChangedListeners() {
    }

    default void addBindings() {
    }
}
