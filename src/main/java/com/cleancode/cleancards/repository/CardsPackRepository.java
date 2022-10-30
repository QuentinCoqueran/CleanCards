package com.cleancode.cleancards.repository;

import com.cleancode.cleancards.models.CardsPack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsPackRepository extends CrudRepository<CardsPack, Long> {
}
