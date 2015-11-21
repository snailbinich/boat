/**
 * This class is generated by jOOQ
 */
package com.izhaoyan.jooq2.domain.tables;


import com.izhaoyan.jooq2.domain.Library;
import com.izhaoyan.jooq2.domain.tables.records.BookStoreRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class BookStore extends TableImpl<BookStoreRecord> {

	private static final long serialVersionUID = -601035802;

	/**
	 * The reference instance of <code>library.book_store</code>
	 */
	public static final BookStore BOOK_STORE = new BookStore();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<BookStoreRecord> getRecordType() {
		return BookStoreRecord.class;
	}

	/**
	 * The column <code>library.book_store.name</code>.
	 */
	public final TableField<BookStoreRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(400).nullable(false), this, "");

	/**
	 * Create a <code>library.book_store</code> table reference
	 */
	public BookStore() {
		this("book_store", null);
	}

	/**
	 * Create an aliased <code>library.book_store</code> table reference
	 */
	public BookStore(String alias) {
		this(alias, BOOK_STORE);
	}

	private BookStore(String alias, Table<BookStoreRecord> aliased) {
		this(alias, aliased, null);
	}

	private BookStore(String alias, Table<BookStoreRecord> aliased, Field<?>[] parameters) {
		super(alias, Library.LIBRARY, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BookStore as(String alias) {
		return new BookStore(alias, this);
	}

	/**
	 * Rename this table
	 */
	public BookStore rename(String name) {
		return new BookStore(name, null);
	}
}