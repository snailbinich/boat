package com.izhaoyan.jooq2.services;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.izhaoyan.jooq2.domain.Tables.BOOK;

/**
 * Created by zhaoyan on 15-11-21.
 */
@Service
public class BookServices {

    @Autowired
    DSLContext dsl;

    @Transactional
    public void test(){

        System.out.println("-----[ start insert "+dsl.fetchCount(BOOK)+"]-----");
        for (int i = 0; i < 2; i++) {
            System.out.println("--- [insert "+i+" , current count = "+dsl.fetchCount(BOOK)+"]----");
            dsl.insertInto(BOOK)
                    .set(BOOK.ID, 5)
                    .set(BOOK.AUTHOR_ID, 1)
                    .set(BOOK.TITLE, "Book 5")
                    .execute();
        }
    }
}
