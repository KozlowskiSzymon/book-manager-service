package com.kozlowskiszymon.book.boundry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO implements Serializable {

    private long id;
    private String title;
    private String author;
    private String description;
    private String genre;
    private String image;
    private boolean available;
    private String price;

}
