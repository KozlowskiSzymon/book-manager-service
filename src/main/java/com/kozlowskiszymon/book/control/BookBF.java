package com.kozlowskiszymon.book.control;

import com.kozlowskiszymon.book.boundry.BookDTO;
import com.kozlowskiszymon.book.boundry.BookMapper;
import com.kozlowskiszymon.book.model.BookBE;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BookBF {

    @Inject
    BookMapper bookMapper;

    @Inject
    BookDAO bookDAO;

    public List<BookBE> getAll() {
        return bookDAO.getAll();
    }

    public BookBE getById(long id) {
        return bookDAO.getById(id);
    }

    public List<BookBE> getByText(String text) {
        return bookDAO.getByText(text);
    }
}
