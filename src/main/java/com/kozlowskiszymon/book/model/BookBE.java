package com.kozlowskiszymon.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NamedQuery(name = "BookBE.findAll", query = "select b from Book b")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Book")
public class BookBE {

    @Id
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
    private String price;
}
