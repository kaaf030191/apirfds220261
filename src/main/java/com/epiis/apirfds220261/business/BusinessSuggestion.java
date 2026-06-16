package com.epiis.apirfds220261.business;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.epiis.apirfds220261.dto.request.RequestSuggestionInsert;
import com.epiis.apirfds220261.dto.response.ResponseSuggestionInsert;
import com.epiis.apirfds220261.entity.EntitySuggestion;
import com.epiis.apirfds220261.entity.EntitySuggestionFile;
import com.epiis.apirfds220261.helper.GenericHelper;
import com.epiis.apirfds220261.repository.RepositorySuggestion;
import com.epiis.apirfds220261.repository.RepositorySuggestionFile;
import com.epiis.apirfds220261.staticdata.EnumProcess;

@Service
public class BusinessSuggestion {
	private final RepositorySuggestion repositorySuggestion;
	private final RepositorySuggestionFile repositorySuggestionFile;
	
	public BusinessSuggestion(
		RepositorySuggestion repositorySuggestion,
		RepositorySuggestionFile repositorySuggestionFile
	) {
		this.repositorySuggestion = repositorySuggestion;
		this.repositorySuggestionFile = repositorySuggestionFile;
	}
	
	public ResponseSuggestionInsert insert(RequestSuggestionInsert request) throws IOException {
		ResponseSuggestionInsert response = new ResponseSuggestionInsert();
		
		EntitySuggestion entitySuggestion = new EntitySuggestion();
		
		entitySuggestion.setIdSuggestion(UUID.randomUUID().toString());
		entitySuggestion.setIdOffice(request.getIdOffice());
		entitySuggestion.setCode(GenericHelper.followCodeGeneration());
		entitySuggestion.setPersonFullName(request.getPersonFullName().trim());
		entitySuggestion.setDescription(request.getDescription().trim());
		entitySuggestion.setStatus(EnumProcess.PENDING.toString());
		entitySuggestion.setCreatedAt(new java.sql.Date(new Date().getTime()));
		entitySuggestion.setUpdatedAt(entitySuggestion.getCreatedAt());
		
		repositorySuggestion.save(entitySuggestion);
		
		if(request.getFiles() != null) {
			Path basePath = Paths.get("storage/suggestionfile");
			
			if(!Files.exists(basePath)) {
	            Files.createDirectories(basePath);
	        }
			
			List<EntitySuggestionFile> listEntitySuggestionFile = new ArrayList<>();
			
			for(var file: request.getFiles()) {
				EntitySuggestionFile entitySuggestionFile = new EntitySuggestionFile();
	            
	            entitySuggestionFile.setIdSuggestionfile(UUID.randomUUID().toString());
	            entitySuggestionFile.setIdSuggestion(entitySuggestion.getIdSuggestion());
	            entitySuggestionFile.setName(file.getOriginalFilename());
	            entitySuggestionFile.setExtension(entitySuggestionFile.getName().substring(entitySuggestionFile.getName().lastIndexOf(".") + 1).toLowerCase());
	            entitySuggestionFile.setCreatedAt(entitySuggestion.getCreatedAt());
	            entitySuggestionFile.setUpdatedAt(entitySuggestion.getCreatedAt());
	            
	            listEntitySuggestionFile.add(entitySuggestionFile);
	            
	            Files.copy(file.getInputStream(), basePath.resolve(entitySuggestionFile.getIdSuggestionfile() + "." + entitySuggestionFile.getExtension()));
			}
	        
	        repositorySuggestionFile.saveAll(listEntitySuggestionFile);
	    }
		
		response.success();
		response.listMessage.add("Registro realizado correctamente.");
		
		return response;
	}
}