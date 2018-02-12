/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.rest;

import fr.devsquad.minutemed.arborescenceOld.domain.NodeOld;
import fr.devsquad.minutemed.arborescenceOld.repository.ArborescenceRepositoryOld;
import fr.devsquad.minutemed.authentication.domain.DoctorCreator;
import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.authentication.repository.AuthenticationRepository;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import fr.devsquad.minutemed.specialization.domain.SpecializationEnum;
import fr.devsquad.minutemed.specialization.repository.SpecializationRepository;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
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
    private AuthenticationRepository authenticationRepository;
    
    @EJB
    private StaffRepository staffRepository;
    
    @EJB
    private ArborescenceRepositoryOld arborescenceRepository;
    
//    @EJB
//    private SpecializationRepository specializationRepository;
    

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
    @ApiOperation(value = "Create a doctor account", response = UserAccount.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/create/doctor")
    public Response createDoctor(@NotNull DoctorCreator doctorCreator) throws IOException {

        System.out.println("createDoctor");
        UserAccount userAccount = authenticationRepository.saveDoctorAccount(doctorCreator);
        NodeOld node = arborescenceRepository.findNode(doctorCreator.getTypeNode(), doctorCreator.getIdNode());
        Specialization specialization = new Specialization(SpecializationEnum.Pediatrie);
        Doctor doctor = Doctor.createFromDoctorCreator(userAccount.getIdAccount(), doctorCreator, node, specialization);
        staffRepository.saveDoctor(doctor);
        
        return Response.ok("{\"userAccount\":"+ userAccount +"}").build();
    }
    
    
    @DELETE
    @ApiOperation(value = "delete an user account")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is deleted."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/delete/{idAccount}")
    public Response deleteUser(@PathParam("idAccount") Long idAccount) throws IOException {
        System.out.println("DELETE user");
        authenticationRepository.delete(idAccount);
        return Response.ok("{\"delete\":"+ idAccount +"}").build();
    }
     
}
