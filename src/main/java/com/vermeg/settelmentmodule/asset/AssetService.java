package com.vermeg.settelmentmodule.asset;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AssetService  { 
	@Autowired
 private assetRepository repo ; 
	public List<asset> LIstAll() {
		return repo.findAll();
		}
	public void save(asset  asset) {
		repo.save(asset); 
} 
	public asset get (Long id) {
		return repo.findById(id).get();
	}
	public void  delete (Long id) {
		 repo.deleteById(id);
	}
} 