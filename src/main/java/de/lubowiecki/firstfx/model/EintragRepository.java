package de.lubowiecki.firstfx.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EintragRepository implements Repository<Eintrag> {

    private List<Eintrag> eintraege;

    private final String FILE_NAME = System.getProperty("user.home") + "/einkaufsliste.json";

    private  final ObjectMapper mapper;

    public EintragRepository() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Nur bei verwendug der Java 8 Time-Typen nötig
        try {
            eintraege = load();
        }
        catch(IOException e) {
            eintraege = new ArrayList<>();
        }
    }

    @Override
    public void insert(Eintrag e) throws IOException {
        eintraege.add(e);
        save();
    }

    @Override
    public void update(Eintrag e) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Eintrag e) throws IOException {
        eintraege.remove(e);
        save();
    }

    @Override
    public List<Eintrag> findAll() {
        return eintraege;
    }

    private void save() throws IOException {
        mapper.writeValue(new FileWriter(FILE_NAME), eintraege);
    }

    private List<Eintrag> load() throws IOException {
        CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Eintrag.class);
        List<Eintrag> eintraege = mapper.readValue(new FileReader(FILE_NAME), type);
        return eintraege;
    }
}
