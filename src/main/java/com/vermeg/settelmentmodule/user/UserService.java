package com.vermeg.settelmentmodule.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repoU ;
	 public List<User>ListAll() {
		 return repoU.findAll() ;
	 }
	  public void save(User utilisateur) {
		  repoU.save(utilisateur);
	  }
	  public User get (Long id) {
		  return repoU.findById(id).get();
	  }
}
