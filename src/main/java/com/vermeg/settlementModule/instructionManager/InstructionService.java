package com.vermeg.settlementModule.instructionManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vermeg.settlementModule.model.Instruction;

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
