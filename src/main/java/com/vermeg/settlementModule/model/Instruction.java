package com.vermeg.settlementModule.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vermeg.settlementModule.model.enums.TransactionType;

@Entity
public class Instruction {
	private long Id ;
	private long secacc ;
	private long id_client ;
	private long id_transaction ;
	private String instrument ; 
	private Integer  quantity ;
	private float price ; 
	private long Id_currency ;
	private String Isin ;
	private Date tradeDate ;
	private Date settlementDate ;
	private TransactionType transactionType ;
	public Instruction() {
		  
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getSecacc() {
		return secacc;
	}
	public void setSecacc(long secacc) {
		this.secacc = secacc;
	}
	public long getId_client() {
		return id_client;
	}
	public void setId_client(long id_client) {
		this.id_client = id_client;
	}
	public long getId_transaction() {
		return id_transaction;
	}
	public void setId_transaction(long id_transaction) {
		this.id_transaction = id_transaction;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public long getId_currency() {
		return Id_currency;
	}
	public void setId_currency(long id_currency) {
		Id_currency = id_currency;
	}
	public String getIsin() {
		return Isin;
	}
	public void setIsin(String isin) {
		Isin = isin;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	public Date getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	
	
}
