module de.lubowiecki.firstfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.lubowiecki.firstfx to javafx.fxml;
    exports de.lubowiecki.firstfx;
}