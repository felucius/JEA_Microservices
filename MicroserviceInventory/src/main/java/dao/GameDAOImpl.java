/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Book;
import domain.Game;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author M
 */
@Stateless
public class GameDAOImpl implements GameDAO {

    @PersistenceContext(name = "MicroserviceInventoryPU")
    EntityManager em;

    @Override
    public Game getGame(Integer gameId) throws PersistenceException {
        return (Game) em.createNamedQuery("Game.findGame").setParameter("gameId", gameId).getSingleResult();
    }

    @Override
    public List<Game> getGamesById(List<Integer> gameIds) throws PersistenceException {
        List<Game> games = new ArrayList();
        Game game;
        for (Integer g : gameIds) {
            game = (Game) em.createNamedQuery("Game.findGame").setParameter("gameId", g).getSingleResult();
            games.add(game);
        }
        return games;
    }

    @Override
    public List<Game> getGames() throws PersistenceException {
        return em.createNamedQuery("Game.getGames").getResultList();
    }

    @Override
    public Boolean insertGame(Game game) throws PersistenceException {
        em.persist(game);
        return true;
    }

    @Override
    public Boolean updateGame(Game game) throws PersistenceException {
        em.merge(game);
        return true;
    }

    @Override
    public Boolean deleteGame(Game game) throws PersistenceException {
        em.remove(game);
        return true;
    }

}
