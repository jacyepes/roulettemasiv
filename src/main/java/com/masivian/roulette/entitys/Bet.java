package com.masivian.roulette.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Bets")
public class Bet {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "userName", nullable = false)
	private String userName;
	@Column(name = "numeroBet", nullable = false)
	private int numeroBet;
	@Column(name = "colorBet", nullable = false)
	private String colorBet;
	@Column(name = "cash", nullable = false)
	private int cash=5000;
	@Column(name="idRoulette", nullable=false)
	private Long idRoulette;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroBet() {
		return numeroBet;
	}

	public void setNumeroBet(int numeroBet) {
		this.numeroBet = numeroBet;
	}

	public String getColorBet() {
		return colorBet;
	}

	public void setColorBet(String colorBet) {
		this.colorBet = colorBet;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getIdRoulette() {
		return idRoulette;
	}

	public void setIdRoulette(Long idRoulette) {
		this.idRoulette = idRoulette;
	}
	
	
}
