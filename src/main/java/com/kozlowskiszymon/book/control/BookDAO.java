package com.kozlowskiszymon.book.control;

import com.kozlowskiszymon.book.model.BookBE;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import java.util.List;

@RequestScoped
public class BookDAO {

    @Inject
    EntityManager em;

    public List<BookBE> getAll() {
        var result = em.createNamedQuery("BookBE.findAll", BookBE.class).getResultList();
        System.out.println(result.get(0));
        return result;
    }

    public BookBE getById(long id) {
        var query = em.createNamedQuery("BookBE.findById", BookBE.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny()
                .orElseThrow(() -> new NotFoundException("No book found with id: " + id ));
    }

    public List<BookBE> getByText(String text) {
        var query = em.createNamedQuery("BookBE.findByText", BookBE.class);
        query.setParameter("text", text);
        return query.getResultList();
    }

    public void save(BookBE toSave) {
        em.persist(toSave);
    }

    public void delete(long id) {
        em.remove(getById(id));
    }
}
