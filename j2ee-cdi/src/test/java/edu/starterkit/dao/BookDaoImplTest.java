package edu.starterkit.dao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.starterkit.dao.annotations.BookDaoRegular;
import edu.starterkit.dao.impl.BookDaoImpl;
import edu.starterkit.observer.BooksObserver;
import edu.starterkit.to.BookTo;

@RunWith(CdiRunner.class)
@AdditionalClasses({ BookTo.class, BookDao.class, BookDaoImpl.class, BooksObserver.class })
public class BookDaoImplTest {

	@Inject
	private BooksObserver observer;
	
	@Inject
	@BookDaoRegular
	private BookDao bookDao;
	
	@Test
	public void shouldFireEvent() {
		// given
		BookTo book = new BookTo(1L, "The Lord of the Rings: Two Towers", "John Ronald Reuel Tolkien");
		// when then
		bookDao.save(book);
	}

}
