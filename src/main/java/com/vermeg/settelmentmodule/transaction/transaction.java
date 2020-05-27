package com.vermeg.settelmentmodule.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vermeg.settlementModule.model.enums.TransactionType;
@Entity

public class transaction {
 
	private Long idtransaction ;
	private  String contracttype;
	private TransactionType transactiontype ;
	private settelmentnature settelmentnature ;
	public transaction() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdtransaction() {
		return idtransaction;
	}
	public void setIdtransaction(Long idtransaction) {
		this.idtransaction = idtransaction;
	}
	public String getContracttype() {
		return contracttype;
	}
	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}
	public TransactionType getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(TransactionType transactiontype) {
		this.transactiontype = transactiontype;
	}
	public settelmentnature getSettelmentnature() {
		return settelmentnature;
	}
	public void setSettelmentnature(settelmentnature settelmentnature) {
		this.settelmentnature = settelmentnature;
	}
	
}
