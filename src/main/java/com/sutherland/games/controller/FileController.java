package com.sutherland.games.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sutherland.games.model.Game;
import com.sutherland.games.service.GameService;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FileController {
	
	private final GameService gameService;

	@PostMapping("/upload")
	public ResponseEntity<List<Game>> uploadFile(@RequestParam("file") MultipartFile uploadfile) throws IOException {
		log.fine("Single file upload!");
		List<Game> games = gameService.addGamesFromFile(uploadfile);
		return ResponseEntity.status(HttpStatus.OK).body(games);
	}

	
}
