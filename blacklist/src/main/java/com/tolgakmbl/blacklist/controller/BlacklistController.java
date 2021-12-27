package com.tolgakmbl.blacklist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blacklist")
public class BlacklistController {

	//Dummy black list controller
	@GetMapping()
	public ResponseEntity<Boolean> isBlacklisted() {
		return ResponseEntity.ok(false);
	}
}
