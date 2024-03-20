package de.lubowiecki.firstfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class StandardController {

    // Elemente die man manipolieren möchte werden im Controller angesprochen
    // Element die mit der Oberfläche interagieren sollen brauchen die Annotation @FXML

    @FXML
    private Label title;

    @FXML
    private TextField eingabe;

    private List<String> liste = new ArrayList<>();

    @FXML
    public void aendereTitle() {
        String input = eingabe.getText(); // Lese Test aus dem Formularfeld ein
        // liste.add(input);
        eingabe.setText(""); // Formularfeld leeren
        title.setText(input); // Gebe einen Text in der Überschrift aus
    }

    // Aufgabe:
    // Schreibe eine einfach Einkaufsliste
    // Ausgabe kann erstmal in ein TextArea erfolgen
}