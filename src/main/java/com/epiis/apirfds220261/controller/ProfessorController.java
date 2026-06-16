package com.epiis.apirfds220261.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epiis.apirfds220261.business.BusinessProfessor;
import com.epiis.apirfds220261.dto.response.ResponseProfessorGetAll;

@RestController
@RequestMapping(path = "professor")
public class ProfessorController {
private final BusinessProfessor businessProfessor;
	
	public ProfessorController(
			BusinessProfessor businessProfessor
	) {
		this.businessProfessor = businessProfessor;
	}
	
	@GetMapping(path = "getall")
	public ResponseEntity<ResponseProfessorGetAll> actionGetAll() {
		return ResponseEntity.ok(businessProfessor.getAll());
	}
}