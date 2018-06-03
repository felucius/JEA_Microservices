/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Book;
import domain.Game;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
public interface GameDAO {

    Game getGame(Integer gameId) throws PersistenceException;

    List<Game> getGames() throws PersistenceException;

    List<Game> getGamesById(List<Integer> gameIds) throws PersistenceException;

    Boolean insertGame(Game game) throws PersistenceException;

    Boolean updateGame(Game game) throws PersistenceException;

    Boolean deleteGame(Game game) throws PersistenceException;
}
