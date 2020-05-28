package com.vermeg.settelmentmodule.asset;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class asset {
    private long isin ;
    private String instrument ;
    private String  settelmentplace ;
    private String nostrocashacc ;
    private String nostrosecacc ;
	public asset() {

	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY   )
	public long getIsin() {
		return isin;
	}
	public void setIsin(long isin) {
		this.isin = isin;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getSettelmentplace() {
		return settelmentplace;
	}
	public void setSettelmentplace(String settelmentplace) {
		this.settelmentplace = settelmentplace;
	}
	public String getNostrocashacc() {
		return nostrocashacc;
	}
	public void setNostrocashacc(String nostrocashacc) {
		this.nostrocashacc = nostrocashacc;
	}
	public String getNostrosecacc() {
		return nostrosecacc;
	}
	public void setNostrosecacc(String nostrosecacc) {
		this.nostrosecacc = nostrosecacc;
	}
    
}
