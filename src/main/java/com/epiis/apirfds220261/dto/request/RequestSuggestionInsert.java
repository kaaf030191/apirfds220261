package com.epiis.apirfds220261.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestSuggestionInsert {
	private String idOffice;
	private String personFullName;
	private String description;
}