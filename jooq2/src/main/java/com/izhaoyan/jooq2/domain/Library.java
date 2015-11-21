/**
 * This class is generated by jOOQ
 */
package com.izhaoyan.jooq2.domain;


import com.izhaoyan.jooq2.domain.tables.Author;
import com.izhaoyan.jooq2.domain.tables.Book;
import com.izhaoyan.jooq2.domain.tables.BookStore;
import com.izhaoyan.jooq2.domain.tables.BookToBookStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Library extends SchemaImpl {

	private static final long serialVersionUID = 1287864122;

	/**
	 * The reference instance of <code>library</code>
	 */
	public static final Library LIBRARY = new Library();

	/**
	 * No further instances allowed
	 */
	private Library() {
		super("library");
	}

	@Override
	public final List<Table<?>> getTables() {
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0() {
		return Arrays.<Table<?>>asList(
			Author.AUTHOR,
			Book.BOOK,
			BookStore.BOOK_STORE,
			BookToBookStore.BOOK_TO_BOOK_STORE);
	}
}