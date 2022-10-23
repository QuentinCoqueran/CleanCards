package com.cleancode.cleancards.repository;


import com.cleancode.cleancards.models.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Long> {
}


