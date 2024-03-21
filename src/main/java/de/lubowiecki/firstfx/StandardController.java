package de.lubowiecki.firstfx;

import de.lubowiecki.firstfx.model.Eintrag;
import de.lubowiecki.firstfx.model.EintragRepository;
import de.lubowiecki.firstfx.model.Repository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StandardController {

    // Elemente die man manipolieren möchte werden im Controller angesprochen
    // Element die mit der Oberfläche interagieren sollen brauchen die Annotation @FXML

    private Repository<Eintrag> repo = new EintragRepository();

    @FXML
    private TextField eingabe;

    @FXML
    private ListView<Eintrag> eintraege;

    private Eintrag cur;

    @FXML
    public void removeSelected() {
        Eintrag eintrag = eintraege.getSelectionModel().getSelectedItem();

        try{
            repo.delete(eintrag);
            updateList();
        }
        catch (Exception e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    public void changeSelected() {
        cur.setName(eingabe.getText());
        cur.setGeaendertAm(LocalDateTime.now());
        cur = null;
        updateList();
    }

    @FXML
    public void add() {
        Eintrag eintrag = new Eintrag(eingabe.getText());
        try {
            repo.insert(eintrag);
            eingabe.clear();
            updateList();
        }
        catch (Exception e) {
            System.out.println("Problem" + e.getMessage());
        }
    }

    private void updateList() {
        eintraege.getItems().clear();
        eintraege.getItems().addAll(repo.findAll());
    }

    @FXML
    public void selectItem() {
        Eintrag eintrag = eintraege.getSelectionModel().getSelectedItem();
        if(eintrag != null) {
            cur = eintrag;
            eingabe.setText(eintrag.getName());
        }
    }
}