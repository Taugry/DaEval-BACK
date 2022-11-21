package fr.dawan.miseensituation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.dawan.miseensituation.dto.LoginDto;
import fr.dawan.miseensituation.dto.LoginResponseDto;
import fr.dawan.miseensituation.services.UtilisateurService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
	public LoginResponseDto checkLogin(@RequestBody LoginDto loginDto) throws Exception {
		return utilisateurService.checkLogin(loginDto);
	}
}
