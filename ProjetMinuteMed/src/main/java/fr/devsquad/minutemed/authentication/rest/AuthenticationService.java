/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.rest;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.arborescence.repository.*;
import fr.devsquad.minutemed.authentication.domain.*;
import fr.devsquad.minutemed.authentication.repository.AuthenticationRepository;
import fr.devsquad.minutemed.specialization.domain.*;
import fr.devsquad.minutemed.specialization.repository.*;
import fr.devsquad.minutemed.staff.domain.*;
import fr.devsquad.minutemed.staff.domain.utils.*;
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
    private ArborescenceRepository arborescenceRepository;
    
    @EJB
    private SpecializationRepository specializationRepository;
    
    
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
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 409, message = "Username conflict")}
    )
    @Path("/create/doctor")
    public Response createDoctorAccount(@NotNull DoctorCreator doctorCreator) throws IOException {
        if(authenticationRepository.usernameAlreadyExist(doctorCreator.getUsername())){
            return Response.status(Response.Status.CONFLICT).entity("An account with this username already exist !").build();
        }
        Specialization specialization = specializationRepository.findByStaffName(doctorCreator.getSpecialization());
        if(specialization == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Node !").build();
        }
        Node node = arborescenceRepository.findNode(doctorCreator.getIdNode(), Node.class);
        if(node == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Node !").build();
        }
        Doctor doctor = MedicalStaffFactory.createDoctorFromCreator(doctorCreator, node, specialization);
        Long doctorID = staffRepository.saveMedicalStaff(doctor);
        UserAccount userAccount = authenticationRepository.saveDoctorAccount(doctorID, doctorCreator);

        return Response.ok("{\"userAccount\": " + userAccount + "}").build();
    }
    
    
    @POST
    @ApiOperation(value = "Create a nurse account", response = UserAccount.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is created."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 409, message = "Username conflict")}
    )
    @Path("/create/nurse")
    public Response createNurseAccount(@NotNull NurseCreator nurseCreator) throws IOException {
        if(authenticationRepository.usernameAlreadyExist(nurseCreator.getUsername())){
            return Response.status(Response.Status.CONFLICT).entity("An account with this username already exist !").build();
        }
        Node node = arborescenceRepository.findNode(nurseCreator.getIdNode(), Node.class);
        if(node == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Node !").build();
        }
        Nurse nurse = MedicalStaffFactory.createNurseFromCreator(nurseCreator, node);
        Long nurseID = staffRepository.saveMedicalStaff(nurse);
        UserAccount userAccount = authenticationRepository.saveNurseAccount(nurseID, nurseCreator);

        return Response.ok("{\"userAccount\": " + userAccount + "}").build();
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
