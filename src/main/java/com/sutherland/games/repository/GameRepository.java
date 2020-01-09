package com.sutherland.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sutherland.games.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	@Query("select g from Game g where g.editorChoce = :#{#game.editorChoce}")
	List<Game> findGamesByGamesEditorChoce(@Param("game") Game game);
}
