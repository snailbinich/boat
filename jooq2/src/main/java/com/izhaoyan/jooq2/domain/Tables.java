/**
 * This class is generated by jOOQ
 */
package com.izhaoyan.jooq2.domain;


import com.izhaoyan.jooq2.domain.tables.Author;
import com.izhaoyan.jooq2.domain.tables.Book;
import com.izhaoyan.jooq2.domain.tables.BookStore;
import com.izhaoyan.jooq2.domain.tables.BookToBookStore;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in library
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * The table library.author
	 */
	public static final Author AUTHOR = com.izhaoyan.jooq2.domain.tables.Author.AUTHOR;

	/**
	 * The table library.book
	 */
	public static final Book BOOK = com.izhaoyan.jooq2.domain.tables.Book.BOOK;

	/**
	 * The table library.book_store
	 */
	public static final BookStore BOOK_STORE = com.izhaoyan.jooq2.domain.tables.BookStore.BOOK_STORE;

	/**
	 * The table library.book_to_book_store
	 */
	public static final BookToBookStore BOOK_TO_BOOK_STORE = com.izhaoyan.jooq2.domain.tables.BookToBookStore.BOOK_TO_BOOK_STORE;
}