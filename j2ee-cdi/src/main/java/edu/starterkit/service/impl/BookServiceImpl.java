package edu.starterkit.service.impl;

import java.util.List;

import javax.inject.Inject;

import edu.starterkit.aop.logger.Logged;
import edu.starterkit.dao.BookDao;
import edu.starterkit.dao.annotations.BookDaoRegular;
import edu.starterkit.service.BookService;
import edu.starterkit.to.BookTo;

@Logged
public class BookServiceImpl implements BookService {

	@Inject
	@BookDaoRegular
	private BookDao bookDao;

	@Override
	public List<BookTo> findAllBooks() {
		return bookDao.findAll();
	}

	@Override
	public List<BookTo> findBooksByTitle(String title) {
		return bookDao.findBookByTitle(title);
	}

	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		return bookDao.findBooksByAuthor(author);
	}

	@Override
	public BookTo saveBook(BookTo book) {
		return bookDao.save(book);
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}
