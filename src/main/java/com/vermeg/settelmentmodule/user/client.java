package com.vermeg.settelmentmodule.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")


public class client extends User {
	private String  cashacc ;
	private String  secacc ;
	private String  adresse ;
	public String getCashacc() {
		return cashacc;
	}
	public void setCashacc(String cashacc) {
		this.cashacc = cashacc;
	}
	public String getSecacc() {
		return secacc;
	}
	public void setSecacc(String secacc) {
		this.secacc = secacc;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	

}
