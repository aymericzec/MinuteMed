/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.rest;

import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.authentication.repository.AuthenticationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author myfou
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("Authentication REST Endpoint")
public class AuthenticationService {
    
    @EJB
    private AuthenticationRepository repository;

    @Context
    private UriInfo uriInfo;
    
    @POST
    @Path("/login")
    @ApiOperation(value = "login to the application")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "You are login"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    public Response login() throws IOException {
        System.out.println("POST");
        
        return Response.ok("{\"name\":login}").build();
    }
    
    @POST
    @ApiOperation(value = "logout to the application")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "You are logout"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/logout")
    public Response logout() throws IOException {
        System.out.println("POST");
        
        return Response.ok("{\"name\":logout}").build();
    }
    
    
    /////////////////////
    ////  DATA MANAGER
    ////////////////////
    
    @POST
    @ApiOperation(value = "Create an user account")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/create")
    public Response createUser(@NotNull UserAccount userAccount) throws IOException {
        System.out.println("POST createUser");
        Long id = repository.save(userAccount);
        return Response.ok("{\"idAccountCreated\":"+ id +"}").build();
    }
    
    
    @DELETE
    @ApiOperation(value = "logout to the application")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is deleted."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/delete/{idAccount}")
    public Response deleteUser(@PathParam("idAccount") Long idAccount) throws IOException {
        System.out.println("DELETE user");
        repository.delete(idAccount);
        return Response.ok("{\"delete\":"+ idAccount +"}").build();
    }
     
}
