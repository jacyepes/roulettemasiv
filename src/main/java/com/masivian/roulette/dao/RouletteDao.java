package com.masivian.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masivian.roulette.entitys.Roulette;

public interface RouletteDao extends JpaRepository<Roulette, Long> {

}
