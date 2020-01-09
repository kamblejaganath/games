package com.sutherland.games.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutherland.games.model.Game;
import com.sutherland.games.service.GameService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/games")
@RequiredArgsConstructor
public class GameController {

	private final GameService gameService;

	@GetMapping
	public Page<Game> findAllGames(Pageable pageable) {
		return gameService.findAllGames(pageable);
	}

	@PostMapping
	public ResponseEntity<Integer> addNewGame(@RequestBody Game game) {
		Integer id = gameService.addNewGame(game);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Integer> updateGame(@PathVariable Integer id, @RequestBody Game game) {
		id = gameService.updateGame(id, game);
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}

	@DeleteMapping("/{id}")
	public BodyBuilder deleteById(@PathVariable Integer id) {
		gameService.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT);
	}
}
