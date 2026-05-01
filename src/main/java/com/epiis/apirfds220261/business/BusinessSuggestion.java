package com.epiis.apirfds220261.business;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epiis.apirfds220261.dto.request.RequestSuggestionInsert;
import com.epiis.apirfds220261.dto.response.ResponseSuggestionInsert;
import com.epiis.apirfds220261.entity.EntityOffice;
import com.epiis.apirfds220261.entity.EntitySuggestion;
import com.epiis.apirfds220261.helper.GenericHelper;
import com.epiis.apirfds220261.repository.RepositorySuggestion;
import com.epiis.apirfds220261.staticdata.EnumProcess;

@Service
public class BusinessSuggestion {
	@Autowired
	private RepositorySuggestion repositorySuggestion;
	
	public ResponseSuggestionInsert insert(RequestSuggestionInsert request) {
		ResponseSuggestionInsert response = new ResponseSuggestionInsert();
		
		EntityOffice entityOffice = new EntityOffice();
		
		entityOffice.setIdOffice(request.getIdOffice());
		
		EntitySuggestion entitySuggestion = new EntitySuggestion();
		
		entitySuggestion.setIdSuggestion(UUID.randomUUID().toString());
		entitySuggestion.setParentOffice(entityOffice);
		entitySuggestion.setCode(GenericHelper.followCodeGeneration());
		entitySuggestion.setPersonFullName(request.getPersonFullName());
		entitySuggestion.setDescription(request.getDescription());
		entitySuggestion.setStatus(EnumProcess.PENDING.toString());
		entitySuggestion.setCreatedAt(new java.sql.Date(new Date().getTime()));
		entitySuggestion.setUpdatedAt(entitySuggestion.getCreatedAt());
		
		repositorySuggestion.save(entitySuggestion);
		
		response.success();
		response.listMessage.add("Registro realizado correctamente.");
		
		return response;
	}
}