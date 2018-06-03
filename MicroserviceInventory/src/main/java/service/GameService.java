/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.GameDAO;
import domain.Game;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class GameService {

    @Inject
    GameDAO gameDAO;

    public Game getGame(Integer gameId) throws PersistenceException {
        return gameDAO.getGame(gameId);
    }

    public List<Game> getGames() throws PersistenceException {
        return gameDAO.getGames();
    }

    public List<Game> getGamesById(List<Integer> gameIds) throws PersistenceException {
        return gameDAO.getGamesById(gameIds);
    }

    public Boolean insertGame(Game game) throws PersistenceException {
        return gameDAO.insertGame(game);
    }

    public Boolean updateGame(Game game) throws PersistenceException {
        return gameDAO.updateGame(game);
    }

    public Boolean deleteGame(Game game) throws PersistenceException {
        return gameDAO.deleteGame(game);
    }
}
