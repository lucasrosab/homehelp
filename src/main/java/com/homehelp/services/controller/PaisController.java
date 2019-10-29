package com.homehelp.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homehelp.services.repository.PaisRepository;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;
	
	
}
