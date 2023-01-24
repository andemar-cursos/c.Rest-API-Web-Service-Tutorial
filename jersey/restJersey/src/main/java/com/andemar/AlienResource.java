package com.andemar;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

    AlienRepository repo = new AlienRepository();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Alien> getAlien() {

        return repo.getAliens();
    }

    @POST
    @Path("alien")
    public Alien createAlien(Alien a1) {
        repo.create(a1);
        return a1;
    }
// https://youtu.be/BZi44GOD8kY?t=4312

}
