/**
 * This class is generated by jOOQ
 */
package com.izhaoyan.jooq2.domain;


import com.izhaoyan.jooq2.domain.tables.Author;
import com.izhaoyan.jooq2.domain.tables.Book;
import com.izhaoyan.jooq2.domain.tables.records.AuthorRecord;
import com.izhaoyan.jooq2.domain.tables.records.BookRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>library</code> 
 * schema
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------


	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = UniqueKeys0.KEY_AUTHOR_PRIMARY;
	public static final UniqueKey<BookRecord> KEY_BOOK_PRIMARY = UniqueKeys0.KEY_BOOK_PRIMARY;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final ForeignKey<BookRecord, AuthorRecord> FK_T_BOOK_AUTHOR_ID = ForeignKeys0.FK_T_BOOK_AUTHOR_ID;
	public static final ForeignKey<BookRecord, AuthorRecord> FK_T_BOOK_CO_AUTHOR_ID = ForeignKeys0.FK_T_BOOK_CO_AUTHOR_ID;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class UniqueKeys0 extends AbstractKeys {
		public static final UniqueKey<AuthorRecord> KEY_AUTHOR_PRIMARY = createUniqueKey(Author.AUTHOR, Author.AUTHOR.ID);
		public static final UniqueKey<BookRecord> KEY_BOOK_PRIMARY = createUniqueKey(Book.BOOK, Book.BOOK.ID);
	}

	private static class ForeignKeys0 extends AbstractKeys {
		public static final ForeignKey<BookRecord, AuthorRecord> FK_T_BOOK_AUTHOR_ID = createForeignKey(com.izhaoyan.jooq2.domain.Keys.KEY_AUTHOR_PRIMARY, Book.BOOK, Book.BOOK.AUTHOR_ID);
		public static final ForeignKey<BookRecord, AuthorRecord> FK_T_BOOK_CO_AUTHOR_ID = createForeignKey(com.izhaoyan.jooq2.domain.Keys.KEY_AUTHOR_PRIMARY, Book.BOOK, Book.BOOK.CO_AUTHOR_ID);
	}
}
