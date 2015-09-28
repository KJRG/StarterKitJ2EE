package edu.starterkit.observer;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;

import edu.starterkit.to.BookTo;

public class BooksObserver {

	private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public void onBookToEvent(@Observes BookTo book) {
		logger.log(Level.INFO, "An event referring to book:\n" + book.toString() + "\nwas raised.");
	}
}
