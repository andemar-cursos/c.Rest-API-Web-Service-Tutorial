package com.andemar.springbootrest.objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {

    @Id
    private int id;
    private String name;
    private int pointers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointers() {
        return pointers;
    }

    public void setPointers(int pointers) {
        this.pointers = pointers;
    }
}
