/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.rest.authentication;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 *
 * @author myfou
 */
@Path("/auth")
@Api("Authentication REST Endpoint")
public class AuthenticationService {
    
    @POST
    @Path("/login")
    @ApiOperation(value = "login to the application")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "You are login"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login() throws IOException {
        System.out.println("POST");
        
        return Response.ok("{\"name\":login}").build();
    }
    
    @POST
    @ApiOperation(value = "logout to the application")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The speaker is created"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/logout")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logout() throws IOException {
        System.out.println("POST");
        
        return Response.ok("{\"name\":logout}").build();
    }
     
}
