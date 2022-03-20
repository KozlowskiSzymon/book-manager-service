package com.kozlowskiszymon.book.boundry;

import com.kozlowskiszymon.book.model.BookBE;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface BookMapper {

    BookDTO toDto(BookBE book);

    List<BookDTO> toDto(List<BookBE> books);

}
