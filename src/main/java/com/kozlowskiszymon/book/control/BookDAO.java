package com.kozlowskiszymon.book.control;

import com.kozlowskiszymon.book.model.BookBE;
import io.agroal.api.AgroalDataSource;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.query.Query;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
}
