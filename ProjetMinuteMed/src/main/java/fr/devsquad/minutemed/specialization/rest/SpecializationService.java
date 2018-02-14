/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization.rest;

import fr.devsquad.minutemed.specialization.domain.*;
import fr.devsquad.minutemed.specialization.repository.*;
import fr.devsquad.minutemed.staff.domain.*;
import io.swagger.annotations.*;
import java.util.*;
import javax.ejb.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author JSalmon
 */
@Path("/specializations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("Specializations REST Endpoint")
public class SpecializationService {
    
    @EJB
    private SpecializationRepository repository;
    
    //////////////
    //// GET ////
    ////////////
    
    @GET
    @ApiOperation(value = "Get all specializations.", response = Specialization.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Specializations are returned.")}
    )
    public Response getAllSpecializations() {
        System.out.println("GET getAllSpecializations()");
        
        List<Specialization> specializations = repository.listAllSpecializations();
        return Response.ok(specializations).build();
    }
    
}
