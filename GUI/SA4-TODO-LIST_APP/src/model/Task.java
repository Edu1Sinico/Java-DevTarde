package model;

import java.util.List;

public class Task {

    // Atributos 
    int id;
    String description;
    boolean done;

    // Construtor
    public Task(String description, boolean b) {
        this.description = description;
        this.done = false;
    }

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }
    
    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
