package de.lubowiecki.firstfx.model;

import java.time.LocalDateTime;

public class Eintrag {

    private String name;
    private LocalDateTime erfasstAm;
    private LocalDateTime geaendertAm;

    private boolean erledigt;

    public Eintrag() {
    }

    public Eintrag(String name) {
        this.name = name;
        erfasstAm = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getErfasstAm() {
        return erfasstAm;
    }

    public void setErfasstAm(LocalDateTime erfasstAm) {
        this.erfasstAm = erfasstAm;
    }

    public LocalDateTime getGeaendertAm() {
        return geaendertAm;
    }

    public void setGeaendertAm(LocalDateTime geaendertAm) {
        this.geaendertAm = geaendertAm;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    @Override
    public String toString() {
        return name;
    }
}
