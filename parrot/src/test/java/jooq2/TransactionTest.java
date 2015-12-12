package jooq2;

import com.izhaoyan.jooq2.BootStrap;
import com.izhaoyan.jooq2.services.BookServices;
import org.jooq.DSLContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import static com.izhaoyan.jooq2.domain.Tables.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by zhaoyan on 15-11-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {BootStrap.class})
@EnableTransactionManagement(proxyTargetClass = true)
public class TransactionTest {

    @Autowired
    DSLContext dsl;
    @Autowired
    DataSourceTransactionManager txMgr;
//    @Autowired BookService books;

    @Autowired
    BookServices bookServices;

    @Before
    public void teardown() {
        // Delete all books that were created in any test
        dsl.delete(BOOK).where(BOOK.ID.gt(4)).execute();
    }

    @Test
    public void testExplicitTransactions() {
        bookServices.test();

        assertEquals(5, dsl.fetchCount(BOOK));
    }

    @Test
    public void testExplicitTransactions1() {
        boolean rollback = false;
        TransactionStatus tx = txMgr.getTransaction(new DefaultTransactionDefinition());
        try {
            // This is a "bug". The same book is created twice, resulting in a
            // constraint violation exception
            for (int i = 0; i < 2; i++)
                dsl.insertInto(BOOK)
                        .set(BOOK.ID, 5)
                        .set(BOOK.AUTHOR_ID, 1)
                        .set(BOOK.TITLE, "Book 5")
                        .execute();
            Assert.fail();
        }

        // Upon the constraint violation, we explicitly roll back the transaction.
        catch (DataAccessException e) {
            txMgr.rollback(tx);
            rollback = true;
        }
        assertEquals(4, dsl.fetchCount(BOOK));
        assertTrue(rollback);
    }




}
