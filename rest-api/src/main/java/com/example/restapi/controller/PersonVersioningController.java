package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dto.Name;
import com.example.restapi.dto.PersonV1;
import com.example.restapi.dto.PersonV2;


@RestController
public class PersonVersioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionPerson() {
		return new PersonV1("bob marley");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionPerson() {
		return new PersonV2(new Name("Bob", "marley"));
	}
	
	
	// ?version=
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getQueryVersion1Person() {
		return new PersonV1("bob marley");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getQueryVersion2Person() {
		return new PersonV2(new Name("Bob", "marley"));
	}
	
	
	// header
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getHeaderVersion1Person() {
		return new PersonV1("bob marley");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getHeaderVersion2Person() {
		return new PersonV2(new Name("Bob", "marley"));
	}
	

	// Media type - add tht produces string in Accept header
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getMediaTypeVersion1Person() {
		return new PersonV1("bob marley");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getMediaTypeVersion2Person() {
		return new PersonV2(new Name("Bob", "marley"));
	}
	
}
