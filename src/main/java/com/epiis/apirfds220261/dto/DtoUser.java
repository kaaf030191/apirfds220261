package com.epiis.apirfds220261.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DtoUser {
	private String idUser;
	private String firstName;
	private String surName;
	private String email;
	private String password;
	private String role;
	private Date createdAt;
	private Date updatedAt;
}
