package com.kozlowskiszymon.book.boundry;

import java.io.Serializable;

public class BookDTO implements Serializable {

    private long id;
    private String title;
    private String author;
    private String description;
    private String genre;
    private boolean available;
    private String price;

}
