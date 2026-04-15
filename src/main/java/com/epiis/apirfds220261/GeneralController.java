package com.epiis.apirfds220261;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "general")
public class GeneralController {
	@GetMapping(path = "index")
	public ResponseEntity<Map<String, String>> actionIndex() {
		Map<String, String> data = new HashMap<>();
		
		data.put("welcome", "Hola mundo cruel!!!");

		return new ResponseEntity<>(data, HttpStatus.OK);
	}
}
