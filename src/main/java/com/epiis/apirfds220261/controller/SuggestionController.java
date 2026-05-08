package com.epiis.apirfds220261.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epiis.apirfds220261.business.BusinessSuggestion;
import com.epiis.apirfds220261.dto.request.RequestSuggestionInsert;
import com.epiis.apirfds220261.dto.response.ResponseSuggestionInsert;

@RestController
@RequestMapping(path = "suggestion")
public class SuggestionController {
	private final BusinessSuggestion businessSuggestion;
	
	public SuggestionController(
		BusinessSuggestion businessSuggestion
	) {
		this.businessSuggestion = businessSuggestion;
	}
	
	@PostMapping(path = "insert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseSuggestionInsert> actionInsert(@ModelAttribute RequestSuggestionInsert request) {
		try {
			ResponseSuggestionInsert response = businessSuggestion.insert(request);
			
			return ResponseEntity.ok(response);
		} catch(Exception _) {
			return null;
		}
	}
}