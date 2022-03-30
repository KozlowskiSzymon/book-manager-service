package com.kozlowskiszymon.book.boundry;

import com.kozlowskiszymon.book.control.BookBF;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        return Response.ok().entity(bookBF.getById(id)).build();
    }

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@RequestBody BookDTO book) {
        bookBF.save(book);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") long id) {
        bookBF.delete(id);
        return Response.ok().build();
    }

    @GET
    @Path("/text")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByText(@QueryParam("text") String text) {
        return Response.ok().entity(bookBF.getByText(text)).build();
    }
}