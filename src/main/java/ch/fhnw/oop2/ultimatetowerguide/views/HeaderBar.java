package ch.fhnw.oop2.ultimatetowerguide.views;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Mario Winiker on 20/12/2016.
 */
public class HeaderBar extends HBox implements ViewMixin {
    private Button save;
    private Button add;
    private Button delete;

    public HeaderBar() {
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
}
