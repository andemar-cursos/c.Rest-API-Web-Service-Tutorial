package com.andemar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlienRepository {

    List<Alien> aliens;

    public AlienRepository() {
        aliens = new ArrayList<>();
        Alien a1 = new Alien();
        a1.setId(1);
        a1.setName("Navin");
        a1.setPoints(60);

        Alien a2 = new Alien();
        a2.setId(2);
        a2.setName("Arati");
        a2.setPoints(60);

        aliens.add(a1);
        aliens.add(a2);
    }


    public List<Alien> getAliens() {
        return aliens;
    }

    public Alien getALienById(int id) {
        return aliens.stream().filter(alien -> alien.getId() == id).collect(Collectors.toList()).get(0);
    }

    public Alien getAlienByName(String name) {
        return aliens.stream().filter((alien -> alien.getName().equalsIgnoreCase(name))).collect(Collectors.toList()).get(0);
    }

    public void create(Alien a1) {
        aliens.add(a1);
    }
}
