/**
 * This class is generated by jOOQ
 */
package com.izhaoyan.jooq2.domain.tables;


import com.izhaoyan.jooq2.domain.Keys;
import com.izhaoyan.jooq2.domain.Library;
import com.izhaoyan.jooq2.domain.tables.records.BookRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Book extends TableImpl<BookRecord> {

	private static final long serialVersionUID = -1598791466;

	/**
	 * The reference instance of <code>library.book</code>
	 */
	public static final Book BOOK = new Book();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<BookRecord> getRecordType() {
		return BookRecord.class;
	}

	/**
	 * The column <code>library.book.id</code>.
	 */
	public final TableField<BookRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>library.book.author_id</code>.
	 */
	public final TableField<BookRecord, Integer> AUTHOR_ID = createField("author_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>library.book.co_author_id</code>.
	 */
	public final TableField<BookRecord, Integer> CO_AUTHOR_ID = createField("co_author_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>library.book.details_id</code>.
	 */
	public final TableField<BookRecord, Integer> DETAILS_ID = createField("details_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>library.book.title</code>.
	 */
	public final TableField<BookRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(400).nullable(false), this, "");

	/**
	 * The column <code>library.book.published_in</code>.
	 */
	public final TableField<BookRecord, Integer> PUBLISHED_IN = createField("published_in", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>library.book.language_id</code>.
	 */
	public final TableField<BookRecord, Integer> LANGUAGE_ID = createField("language_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>library.book.content_text</code>.
	 */
	public final TableField<BookRecord, String> CONTENT_TEXT = createField("content_text", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>library.book.content_pdf</code>.
	 */
	public final TableField<BookRecord, String> CONTENT_PDF = createField("content_pdf", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>library.book.rec_version</code>.
	 */
	public final TableField<BookRecord, Integer> REC_VERSION = createField("rec_version", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>library.book.rec_timestamp</code>.
	 */
	public final TableField<BookRecord, Timestamp> REC_TIMESTAMP = createField("rec_timestamp", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * Create a <code>library.book</code> table reference
	 */
	public Book() {
		this("book", null);
	}

	/**
	 * Create an aliased <code>library.book</code> table reference
	 */
	public Book(String alias) {
		this(alias, BOOK);
	}

	private Book(String alias, Table<BookRecord> aliased) {
		this(alias, aliased, null);
	}

	private Book(String alias, Table<BookRecord> aliased, Field<?>[] parameters) {
		super(alias, Library.LIBRARY, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<BookRecord> getPrimaryKey() {
		return Keys.KEY_BOOK_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<BookRecord>> getKeys() {
		return Arrays.<UniqueKey<BookRecord>>asList(Keys.KEY_BOOK_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<BookRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<BookRecord, ?>>asList(Keys.FK_T_BOOK_AUTHOR_ID, Keys.FK_T_BOOK_CO_AUTHOR_ID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Book as(String alias) {
		return new Book(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Book rename(String name) {
		return new Book(name, null);
	}
}