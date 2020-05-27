package com.vermeg.settelmentmodule.transaction;

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

import com.vermeg.settelmentmodule.asset.RessourceNotFoundException;
import com.vermeg.settelmentmodule.asset.asset;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

public class transactionController {
	@Autowired
	private transactionRepository transactionRepository ; 
	@GetMapping("/transactions")
	public List<com.vermeg.settelmentmodule.transaction.transaction> getAlltransaction() {
		return transactionRepository.findAll();
	}
	@GetMapping("/transaction/{id}")
	public ResponseEntity<com.vermeg.settelmentmodule.transaction.transaction> gettransactionById(
			@PathVariable(value = "Id") Long idtransaction) throws notFound {
		com.vermeg.settelmentmodule.transaction.transaction transaction= transactionRepository.findById(idtransaction)
				.orElseThrow(
						() -> new notFound("transaction not found for this id :: " +idtransaction));
		return ResponseEntity.ok().body(transaction);
	}
	@PostMapping("/transaction")
	public @Valid transaction createtransaction(@Valid @RequestBody transaction transaction ) {
		return transactionRepository.save(transaction);
	}

	@PutMapping("/transaction/{idtransaction}")
	public ResponseEntity<transaction> updatetransaction(@PathVariable(value = "Id") Long idtransaction,
			@Valid @RequestBody com.vermeg.settelmentmodule.transaction.transaction transactionDetails)
			throws notFound {
		com.vermeg.settelmentmodule.transaction.transaction transaction = transactionRepository.findById(idtransaction)
				.orElseThrow(
						() -> new notFound("transaction not found for this id :: " + idtransaction));
		
		transaction.setIdtransaction(transactionDetails.getIdtransaction());
		transaction.setContracttype(transactionDetails.getContracttype());
		transaction.setTransactiontype(transactionDetails.getTransactiontype());
		transaction.setSettelmentnature( transactionDetails).getSettelmentnature());


		final com.vermeg.settelmentmodule.transaction.transaction updatetransaction = transactionRepository
				.save(transaction);
		return ResponseEntity.ok(updatetransaction);
	}
	
		@DeleteMapping("/transaction/{Idtransaction}")
		public Map<String, Boolean> deletetransaction(@PathVariable(value = "Id") Long idtransaction)
		throws notFound	{
			com.vermeg.settelmentmodule.transaction.transaction  transaction = transactionRepository.findById(idtransaction)
					.orElseThrow(
							() -> new  notFound ("transaction not found for this id :: " + idtransaction));

			transactionRepository.delete(transaction);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}

}
