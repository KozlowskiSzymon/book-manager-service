package com.kozlowskiszymon.book.control;

import com.kozlowskiszymon.book.boundry.BookDTO;
import com.kozlowskiszymon.book.boundry.BookMapper;
import com.kozlowskiszymon.book.model.BookBE;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class BookBF {

    @Inject
    BookMapper bookMapper;

    @Inject
    BookDAO bookDAO;

    @Transactional
    public List<BookBE> getAll() {
        return bookDAO.getAll();
    }

    @Transactional
    public BookBE getById(long id) {
        return bookDAO.getById(id);
    }

    @Transactional
    public List<BookBE> getByText(String text) {
        return bookDAO.getByText(text);
    }

    @Transactional
    public void save(BookDTO book) {
        System.out.println(book.getDescription());
        BookBE toSave;
        if (book.getId() != null) {
            toSave = bookDAO.getById(book.getId());
        } else {
            toSave = new BookBE();
        }
        toSave.setAuthor(book.getAuthor());
        toSave.setTitle(book.getTitle());
        toSave.setDescription(book.getDescription());
        toSave.setGenre(book.getGenre());
        toSave.setAvailable(book.isAvailable());
        toSave.setImage(book.getImage());
        toSave.setPrice(book.getPrice());
        bookDAO.save(toSave);
    }

    @Transactional
    public void delete(long id) {
        bookDAO.delete(id);
    }
}
