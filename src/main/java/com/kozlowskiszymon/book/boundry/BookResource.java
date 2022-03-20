package com.kozlowskiszymon.book.boundry;

import com.kozlowskiszymon.book.control.BookBF;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/book")
@ApplicationScoped
public class BookResource {

    @Inject
    BookBF bookBF;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok().entity(bookBF.getAll()).build();
    }
}