package com.andemar;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAlien() {
        Alien a1 = new Alien();
        a1.setName("Navin");
        a1.setPoints(60);

        Alien a2 = new Alien();
        a2.setName("Arati");
        a2.setPoints(60);

        List<Alien> aliens = Arrays.asList(a1, a2);

        return aliens;
    }
}
