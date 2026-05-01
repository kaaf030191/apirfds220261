package com.epiis.apirfds220261.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epiis.apirfds220261.business.BusinessSuggestion;
import com.epiis.apirfds220261.dto.request.RequestSuggestionInsert;
import com.epiis.apirfds220261.dto.response.ResponseSuggestionInsert;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "suggestion")
public class SuggestionController {
	@Autowired
	private BusinessSuggestion businessSuggestion;
	
	@PostMapping(path = "insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseSuggestionInsert> actionInsert(@RequestBody RequestSuggestionInsert request) {
		ResponseSuggestionInsert response = businessSuggestion.insert(request);
		
		return ResponseEntity.ok(response);
	}
}