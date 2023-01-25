package com.andemar.springbootrest.rest;

import com.andemar.springbootrest.objects.Alien;
import com.andemar.springbootrest.repository.AlienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlienResource {

    @Autowired
    private AlienRepository repo;

    @GetMapping("aliens")
    public List<Alien> getAliens() {
        List<Alien> aliens = (List<Alien>) repo.findAll() ;

        return aliens;
    }

}
