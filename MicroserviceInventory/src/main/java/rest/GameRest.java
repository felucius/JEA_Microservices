/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import domain.Game;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.GameService;

/**
 *
 * @author M
 */
@Stateless
@Path("games")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameRest {

    @Inject
    GameService gameService;

    @GET
    @Path("{id}")
    public Game getGame(@PathParam("id") Integer gameId) throws PersistenceException {
        return gameService.getGame(gameId);
    }

    @GET
    public List<Game> getGames() throws PersistenceException {
        return gameService.getGames();
    }

    @POST
    @Path("items")
    public List<Game> getGamesById(List<Integer> gameIds) throws PersistenceException {
        return gameService.getGamesById(gameIds);
    }

    @POST
    public Boolean insertGame(Game game) throws PersistenceException {
        return gameService.insertGame(game);
    }

    @PUT
    public Boolean updateGame(Game game) throws PersistenceException {
        return gameService.updateGame(game);
    }

    @DELETE
    public Boolean deleteGame(Game game) throws PersistenceException {
        return gameService.deleteGame(game);
    }
}
