package com.sutherland.games.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.sutherland.games.model.Game;

public interface GameService {

	Page<Game> findAllGames(Pageable pageable);

	Integer addNewGame(Game game);

	Integer updateGame(Integer id, Game game);

	void deleteById(Integer id);

	List<Game> addGamesFromFile(MultipartFile uploadfile) throws IOException;

}
