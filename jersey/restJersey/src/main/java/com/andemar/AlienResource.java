package com.andemar;

import java.util.List;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import javax.print.attribute.standard.Media;

@Path("aliens")
public class AlienResource {

    AlienRepository repo = new AlienRepository();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Alien> getAliens() {

        return repo.getAliens();
    }

    @GET
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alien getAlien(@PathParam("id") int id) {
        return repo.getALienById(id);
    }

    @POST
    @Path("alien")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alien createAlien(Alien a1) {
        repo.create(a1);
        return a1;
    }

    @PUT
    @Path("alien")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Alien updateAlien(Alien a1) {

        if (getAlien(a1.getId()).getId() == 0) {
           repo.create(a1);
        } else {
            repo.update(a1);
        }
        return a1;
    }

    @DELETE
    @Path("alien/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void getAlien(@PathParam("id") int id) {
        repo.delete(id);
    }
}
