package com.vermeg.settelmentmodule.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class transactionService {
	@Autowired
	 private transactionRepository repo ; 
		public List<transaction> LIstAll() {
			return repo.findAll();
			}
		public void save(transaction  transaction) {
			repo.save(transaction); 
	} 
		public transaction get (Long id) {
			return repo.findById(id).get();
		}
		public void  delete (Long id) {
			 repo.deleteById(id);
		}

}

