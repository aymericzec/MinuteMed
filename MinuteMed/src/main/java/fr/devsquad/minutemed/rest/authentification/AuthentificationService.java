/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.rest.authentification;

import javax.ejb.EJB;
import javax.ejb.NoSuchEntityException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;


/**
 *
 * @author myfou
 */
public class AuthentificationService {
    @EJB
    private BookRepository repository;

    @Context
    private UriInfo uriInfo;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Book book) {
        repository.save(book);
        URI bookUri = uriInfo.getBaseUriBuilder().path(BookRestService.class).path(book.getId().toString()).build();
        return Response.created(bookUri).build();
    }

    @POST
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logout(@PathParam("id") Long id) {
        try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.noContent().build();
    }    
}
