package com.sutherland.games.service.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.sutherland.games.model.Game;
import com.sutherland.games.repository.GameRepository;
import com.sutherland.games.service.GameService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

	private final GameRepository gameRepository;

	@Override
	public Page<Game> findAllGames(Pageable pageable) {
		return gameRepository.findAll(pageable);
	}

	@Override
	public Integer addNewGame(Game game) {
		game = gameRepository.save(game);
		return game.getId();
	}

	@Override
	public Integer updateGame(Integer id, Game game) {
		gameRepository.existsById(id);
		game.setId(id);
		gameRepository.save(game);
		return game.getId();
	}

	@Override
	public void deleteById(Integer id) {
		gameRepository.deleteById(id);
	}

	@Override
	public List<Game> addGamesFromFile(MultipartFile uploadfile) throws IOException {
		List<Game> games = new ArrayList<>();
		InputStreamReader reader = new InputStreamReader(uploadfile.getInputStream());
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
		csvReader.readAll().parallelStream().forEach(r-> {
			String[] tokens = r.clone();
			Game game = new Game();
			game.setTitle(tokens[0]);
			game.setPlatform(tokens[1]);
			game.setScore(tokens.length>2?Float.parseFloat(tokens[2]):0f);
			game.setGenre(tokens.length>3?tokens[3]: null);
			game.setEditorChoce(tokens.length>4? tokens[4]: null);
			games.add(gameRepository.save(game));
		});
		
		return games;
	}
	
	

}
