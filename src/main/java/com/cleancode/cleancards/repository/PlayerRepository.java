package com.cleancode.cleancards.repository;

import com.cleancode.cleancards.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
