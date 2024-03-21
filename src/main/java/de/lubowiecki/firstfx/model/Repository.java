package de.lubowiecki.firstfx.model;

import java.io.IOException;
import java.util.List;

public interface Repository<T> { // T ist ein Platzhalter für eine komplexen Datentyp

    void insert(T t) throws IOException;

    void update(T t) throws IOException;

    void delete(T t) throws IOException;

    List<T> findAll();
}
