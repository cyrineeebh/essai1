package com.vermeg.settlementModule.instructionManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.vermeg.settlementModule.model.Instruction;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

	@Autowired
	private InstructionRepository InstructionRepository;

	@GetMapping("/instructions")
	public List<com.vermeg.settlementModule.model.Instruction> getAllInstructions() {
		return InstructionRepository.findAll();
	}

	@GetMapping("/instructions/{id}")
	public ResponseEntity<com.vermeg.settlementModule.model.Instruction> getInstructionById(
			@PathVariable(value = "id") Long instructionId) throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Instruction instruction = InstructionRepository.findById(instructionId)
				.orElseThrow(
						() -> new RessourceNotFoundException("instruction not found for this id :: " + instructionId));
		return ResponseEntity.ok().body(instruction);
	}

	@PostMapping("/instruction")
	public Instruction createInstruction(@Valid @RequestBody Instruction instruction) {
		return InstructionRepository.save(instruction);
	}

	@PutMapping("/instructions/{id}")
	public ResponseEntity<Instruction> updateInstruction(@PathVariable(value = "id") Long instructionId,
			@Valid @RequestBody com.vermeg.settlementModule.model.Instruction instructionDetails)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Instruction instruction = InstructionRepository.findById(instructionId)
				.orElseThrow(
						() -> new RessourceNotFoundException("instruction not found for this id :: " + instructionId));

		instruction.setId(instructionDetails.getId());
		instruction.setSecacc(instructionDetails.getSecacc());
		instruction.setTransactionType(instructionDetails.getTransactionType());
		instruction.setInstrument(instructionDetails.getInstrument());
		instruction.setQuantity(instructionDetails.getQuantity());
		instruction.setPrice(instructionDetails.getPrice());
		instruction.setTradeDate(instructionDetails.getTradeDate());
		instruction.setSettlementDate(instructionDetails.getSettlementDate());

		final com.vermeg.settlementModule.model.Instruction updatedInstruction = InstructionRepository
				.save(instruction);
		return ResponseEntity.ok(updatedInstruction);
	}

	@DeleteMapping("/instructions/{Id}")
	public Map<String, Boolean> deleteInstruction(@PathVariable(value = "Id") Long instructionId)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.Instruction instruction = InstructionRepository.findById(instructionId)
				.orElseThrow(
						() -> new RessourceNotFoundException("instruction not found for this id :: " + instructionId));

		InstructionRepository.delete(instruction);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}