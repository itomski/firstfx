module de.lubowiecki.firstfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;


    opens de.lubowiecki.firstfx to javafx.fxml;
    exports de.lubowiecki.firstfx;
    exports de.lubowiecki.firstfx.model to com.fasterxml.jackson.databind;
}