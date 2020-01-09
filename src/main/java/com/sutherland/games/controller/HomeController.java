package com.sutherland.games.controller;

import java.io.IOException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController
@RequiredArgsConstructor
public class HomeController {

	@GetMapping("/")
	public String home(Model model) throws IOException {
		log.fine("Home file upload!");
		model.addAttribute("name", System.currentTimeMillis());
		return "home";
	}

}
