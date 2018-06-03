/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Book;
import domain.Game;
import domain.Inventory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author M
 */
@Singleton
@Startup
public class init {

    @Inject
    BookService bookService;

    @Inject
    GameService gameService;

    @Inject
    InventoryService inventoryService;

    @PostConstruct
    public void Init() {
        Inventory inventoryGames = new Inventory("Game Inventory");

        List<Game> games = new ArrayList();
        games.add(new Game("Witch hunter3", 60, "RPG", "11-12-2014"));
        games.add(new Game("GTA V", 45, "ARPG", "11-11-2013"));
        games.add(new Game("Need for speed: Road hunter", 35, "Race", "20-04-2008"));

        inventoryGames.setGames(games);
        //inventoryService.insertInventory(inventoryGames);

        Inventory inventoryBooks = new Inventory("Books Inventory");
        List<Book> books = new ArrayList();
        books.add(new Book("Stephen King IT", 25, "Random Horror stories", "Stephan King"));
        books.add(new Book("LOTR", 60, "New age stories", "Hans Zimmer"));
        books.add(new Book("King of Queens", 20, "Blush me twice books & co", "Frederich zomerkampf"));
        
        books.add(new Book("Rapunzel and the wolf", 15, "Random Horror stories", "Stephan King"));
        books.add(new Book("Sea of thieves", 90, "New age stories", "Rick ferweg"));
        books.add(new Book("Big Atlas", 20, "Atlas brothers", "Leopold field"));
        
        books.add(new Book("Dancing with the other dancing startrs", 45, "Show bizz", "Francine Leonardo"));
        books.add(new Book("Wolf and muders", 60, "Mayfield & Weather", "Ramsteiun vonkrich Zimmer"));
        books.add(new Book("World of Warcraft the guide", 20, "Heavy gamingology", "Joop bnieman londtraag"));

        inventoryBooks.setBooks(books);
        inventoryService.insertInventory(inventoryBooks);

    }
}
