package com.example.instructionManger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.aspectj.apache.bcel.generic.Instruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

public class InstructionController {
	@Autowired
	private InstructionRepository InstructionRepository;
    @GetMapping("/instruction")
	public List<com.example.instructionManger.Instruction> getAllInstructions() {
	return InstructionRepository.findAll();
	}
    
    
    @GetMapping("/instructions/{id}")
    public ResponseEntity<com.example.instructionManger.Instruction> getInstructionById(@PathVariable(value = "id") Long instructionId)
    throws RessourceNotFoundException {
    com.example.instructionManger.Instruction instruction = InstructionRepository.findById(instructionId)
    .orElseThrow(() -> new RessourceNotFoundException("instruction not found for this id :: " + instructionId));
    return ResponseEntity.ok().body(instruction);
    }
    @PostMapping("/instructions")
    public Instruction createInstruction(@Valid @RequestBody Instruction instruction) {
    return InstructionRepository.saveAll(instruction);
    }
    @PutMapping("/instructions/{id}")
    public ResponseEntity<com.example.instructionManger.Instruction> updateInstruction(@PathVariable(value = "id") Long instructionId,
    @Valid @RequestBody Instruction instructionDetails) throws RessourceNotFoundException {
    	com.example.instructionManger.Instruction instruction = InstructionRepository.findById(instructionId)
    .orElseThrow(() -> new RessourceNotFoundException("instruction not found for this id :: " + instructionId));

    	instruction.setId(( instructionDetails).Id);
    	instruction.setSecacc(( instructionDetails).secacc);
    	instruction.setTransactiontype(( instructionDetails).transactiontype);
    	instruction.setInstrument(( instructionDetails).instrument);
    	instruction.setQuantity(( instructionDetails).quantity);
    	instruction.setPrice(( instructionDetails). price);
    	instruction.setTradedate(( instructionDetails).tradedate);
    	instruction.setSettelmentdate (( instructionDetails).settelmentdate);

    final com.example.instructionManger.Instruction updatedInstruction = InstructionRepository.save(instruction);
    return ResponseEntity.ok(updatedInstruction);
    }
    @DeleteMapping("/instructions/{Id}")
    public Map<String, Boolean> deleteInstruction(@PathVariable(value = "Id") Long instructionId)
    throws RessourceNotFoundException {
    	com.example.instructionManger.Instruction instruction = InstructionRepository.findById(instructionId)
    .orElseThrow(() -> new RessourceNotFoundException("instruction not found for this id :: " + instructionId));

    InstructionRepository.delete(instruction);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
    }
}
