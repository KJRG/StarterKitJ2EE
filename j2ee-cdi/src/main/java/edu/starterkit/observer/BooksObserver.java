package edu.starterkit.observer;

import javax.enterprise.event.Observes;

import edu.starterkit.to.BookTo;

public class BooksObserver {

	public void onBookToEvent(@Observes BookTo book) {
		System.out.println("An event referring to book:\n" + book.toString() + "\n was raised.");
	}
}
