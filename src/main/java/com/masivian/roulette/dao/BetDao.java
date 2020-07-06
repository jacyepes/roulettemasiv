package com.masivian.roulette.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masivian.roulette.entitys.Bet;

public interface BetDao extends JpaRepository<Bet, Long>  {

}
