package com.example.instructionManger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {
	@Autowired  
private InstructionRepository repo ;
	public List<Instruction> ListAll() {
		return repo.findAll();
	}
	 public void save(Instruction instruction) {
		 repo.save(instruction);
		 
		 
	 }
	 public Instruction get (Long id ) {
		 return repo.findById(id).get();
	 }
	 public void delete(long id) {
		 repo.deleteById(id);
	 }
}
