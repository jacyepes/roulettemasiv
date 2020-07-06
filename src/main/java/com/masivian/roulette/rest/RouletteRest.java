package com.masivian.roulette.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.roulette.dao.BetDao;
import com.masivian.roulette.dao.RouletteDao;
import com.masivian.roulette.entitys.Bet;
import com.masivian.roulette.entitys.Roulette;

@RestController
@RequestMapping("/roulette")
public class RouletteRest {

	@Autowired
	private RouletteDao rouletteDao;

	@Autowired
	private BetDao betDao;

	@GetMapping("/allroulettes")
	public ResponseEntity<List<Roulette>> getRoulette() {
		List<Roulette> roulette = rouletteDao.findAll();
		return ResponseEntity.ok(roulette);
	}

	@PostMapping("/newroulette")
	public ResponseEntity<Roulette> createdRoulette(@RequestBody Roulette roulette) {
		Roulette newRoulette = rouletteDao.save(roulette);
		return ResponseEntity.ok(newRoulette);
	}

	@RequestMapping(value = "{rouletteId}")
	public ResponseEntity<Roulette> getByid(@PathVariable("rouletteId") Long rouletteId) {
		Optional<Roulette> optionalRouletteId = rouletteDao.findById(rouletteId);
		if (optionalRouletteId.isPresent()) {
			return ResponseEntity.ok(optionalRouletteId.get());
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PutMapping("/openstate")
	public ResponseEntity<Roulette> openStateRoulette(@RequestBody Roulette roulette) {
		Optional<Roulette> optionalRouletteId = rouletteDao.findById(roulette.getId());
		if (optionalRouletteId.isPresent()) {
			Roulette updateRoulette = optionalRouletteId.get();
			updateRoulette.setState(1);
			rouletteDao.save(updateRoulette);
			return ResponseEntity.ok(updateRoulette);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("/newbet")
	public ResponseEntity<Bet> createdBet(@RequestBody Bet bet) {
		Long newBetId = bet.getIdRoulette();
		Roulette stateRoulette = rouletteDao.getOne(newBetId);
		int newStateRoulette = stateRoulette.getState();
		if (newStateRoulette == 1 && bet.getNumeroBet() <= 36
				&& (bet.getColorBet().equals("negro") || bet.getColorBet().equals("rojo"))) {
			System.out.println("Apuesta aceptada");
			Bet newBet = betDao.save(bet);
			return ResponseEntity.ok(newBet);
		} else {
			System.out.println("Apuesta no acpetada");
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/closebets")
	public ResponseEntity<List<Bet>> getBet() {
		List<Bet> bet = betDao.findAll();
		return ResponseEntity.ok(bet);
	}
}
