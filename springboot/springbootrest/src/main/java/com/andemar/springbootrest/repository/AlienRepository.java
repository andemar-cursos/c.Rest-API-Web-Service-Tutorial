package com.andemar.springbootrest.repository;

import com.andemar.springbootrest.objects.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepository extends CrudRepository<Alien, Integer> {

}
