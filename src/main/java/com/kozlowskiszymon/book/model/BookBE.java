package com.kozlowskiszymon.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;

@NamedQuery(name = "BookBE.findAll", query = "select b from Book b")
@NamedQuery(name = "BookBE.findById", query = "select b from Book b where b.id = :id")
@NamedQuery(name = "BookBE.findByText", query = "select b from Book b where " +
        "lower(b.author) like '%' || lower(:text) || '%' or " +
        "lower(b.title) like '%' || lower(:text) || '%' or " +
        "lower(b.description) like '%' || lower(:text) || '%' or " +
        "lower(b.genre) like '%' || lower(:text) || '%'")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Book")
public class BookBE {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column(length = 4096)
    private String description;

    @Column
    private String genre;

    @Column
    private boolean available;

    @Column
    private String image;

    @Column
    private String price;
}
