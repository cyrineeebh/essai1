package com.vermeg.settelmentmodule.asset;

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



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/")

public class assetController {
	@Autowired
	private assetRepository assetRepository;

	@GetMapping("/assets")
	public List<com.vermeg.settelmentmodule.asset.asset> getAllIasset() {
		return assetRepository.findAll();
	}

	@GetMapping("/asset/{id}")
	public ResponseEntity<com.vermeg.settelmentmodule.asset.asset> getassetById(
			@PathVariable(value = "Id") Long isin) throws RessourceNotFoundException {
		com.vermeg.settelmentmodule.asset.asset asset= assetRepository.findById(isin)
				.orElseThrow(
						() -> new RessourceNotFoundException("asset not found for this id :: " +isin));
		return ResponseEntity.ok().body(asset);
	}

	@PostMapping("/asset")
	public asset createasset(@Valid @RequestBody asset asset ) {
		return assetRepository.save(asset);
	}

	@PutMapping("/asset/{isin}")
	public ResponseEntity<asset> updateasset(@PathVariable(value = "Id") Long isin,
			@Valid @RequestBody com.vermeg.settelmentmodule.asset.asset  assetDetails)
			throws RessourceNotFoundException {
		com.vermeg.settelmentmodule.asset.asset asset = assetRepository.findById(isin)
				.orElseThrow(
						() -> new RessourceNotFoundException("asset not found for this id :: " + isin));

		asset.setIsin(assetDetails.getIsin());
		asset.setInstrument(assetDetails.getInstrument());
		asset.setSettelmentplace(assetDetails.getSettelmentplace());
		asset.setNostrocashacc(assetDetails.getNostrocashacc());
		asset.setNostrocashacc(assetDetails.getNostrocashacc());
		
		

		final com.vermeg.settelmentmodule.asset.asset updateasset = assetRepository
				.save(asset);
		return ResponseEntity.ok(updateasset);
	}

	@DeleteMapping("/asset/{Id}")
	public Map<String, Boolean> deleteasset(@PathVariable(value = "Id") Long isin)
	throws RessourceNotFoundException	{
		com.vermeg.settelmentmodule.asset.asset  asset = assetRepository.findById(isin)
				.orElseThrow(
						() -> new RessourceNotFoundException("asset not found for this id :: " + isin));

		assetRepository.delete(asset);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
 