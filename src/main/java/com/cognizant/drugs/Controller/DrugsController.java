package com.cognizant.drugs.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.drugs.Model.Drugs;
import com.cognizant.drugs.Service.DrugsService;


@RestController
public class DrugsController {
	@Autowired
	DrugsService drugsService;

	@GetMapping("/searchDrugsByID/{drugId}")
	public ResponseEntity<?> searchDrugsByID(@PathVariable int drugId){
		Drugs drug = drugsService.searchDrugsByID(drugId).orElse(null);
		if (drug != null)
			return new ResponseEntity<>(drug, HttpStatus.OK);
		return new ResponseEntity<>(drug, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/searchDrugsByName/{name}")
	public ResponseEntity<Drugs> searchDrugsByName(@PathVariable String name){
		Drugs drug = drugsService.searchDrugsByName(name).orElse(null);
		if (drug != null)
			return new ResponseEntity<>(drug, HttpStatus.OK);
		return new ResponseEntity<>(drug, HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getDispatchableDrugStock/{drugId}/{location}")
	public ResponseEntity<Drugs> getDispatchableDrugStock(@PathVariable int drugId, @PathVariable String location){
		Drugs drug = drugsService.findByLocation(drugId, location);
	
		return new ResponseEntity<>(drug, HttpStatus.OK);
	}

	@PostMapping("/drugsAdd")
	public void save(@RequestBody Drugs med) {
		drugsService.save(med);
	}

}
