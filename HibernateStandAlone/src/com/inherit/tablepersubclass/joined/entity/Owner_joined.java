package com.inherit.tablepersubclass.joined.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "OWNER_PERSUBCLASS_JOINED")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Owner_joined extends Person_Joined implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "stocks")
	private Long stocks;

	@Column(name = "partnership_stake")
	private Long partnershipStake;

	public Owner_joined() {
	}

	public Owner_joined(String firstname, String lastname, Long stocks,
			Long partnershipStake) {

		super(firstname, lastname);

		this.stocks = stocks;
		this.partnershipStake = partnershipStake;
	}

	public Long getStocks() {
		return stocks;
	}

	public void setStocks(Long stocks) {
		this.stocks = stocks;
	}

	public Long getPartnershipStake() {
		return partnershipStake;
	}

	public void setPartnershipStake(Long partnershipStake) {
		this.partnershipStake = partnershipStake;
	}

}
