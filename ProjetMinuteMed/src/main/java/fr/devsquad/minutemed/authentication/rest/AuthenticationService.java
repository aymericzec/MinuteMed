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
import fr.devsquad.minutemed.jwt.filter.JWTNeeded;
import fr.devsquad.minutemed.jwt.util.KeyGenerator;
import fr.devsquad.minutemed.jwt.util.TokenUtils;
import fr.devsquad.minutemed.specialization.domain.*;
import fr.devsquad.minutemed.specialization.repository.*;
import fr.devsquad.minutemed.staff.domain.*;
import fr.devsquad.minutemed.staff.domain.utils.*;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Enzo
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
    
    // ======================================
    // =          Injection Points          =
    // ======================================

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger logger;

    @Inject
    private KeyGenerator keyGenerator;
    
    
    @POST
    @Path("/login")
    @ApiOperation(value = "login to the application")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "You are login"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("login") String login,
                                     @FormParam("password") String password) {

        try {

            logger.info("#### login/password truc : " + login + "/" + password);

            // Authenticate the user using the credentials provided
            UserAccount user = authenticationRepository.Authenticate(login, password);
            if (user == null)
                throw new SecurityException("Invalid user/password");
            
            // Issue a token for the user
            String token = TokenUtils.issueToken(keyGenerator, login, user.getIdAccount(), uriInfo.getAbsolutePath().toString());

            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).build();
        }
    }

    //TODO: A voir si besoin en back !
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
    @ApiOperation(value = "Create a user account", response = UserAccount.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is created."),
        @ApiResponse(code = 409, message = "Username conflict")
    })
    @Path("/create")
    public Response createUserAccount(@NotNull UserAccount user) throws IOException {
        System.out.println(user);
        if(authenticationRepository.usernameAlreadyExist(user.getUsername())){
            return Response.status(Response.Status.CONFLICT).entity("An account with this username already exist !").build();
        }
        
        authenticationRepository.saveUserAccount1(user);

        return Response.ok(user).build();
    }
    
    
    @POST
    @ApiOperation(value = "Create a data manager account", response = UserAccount.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is created."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 409, message = "Username conflict")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    @Path("/create/datamanager")
    public Response createDataManagerAccount(@NotNull DataManagerCreator dataManagerCreator) throws IOException {
        if(authenticationRepository.usernameAlreadyExist(dataManagerCreator.getUsername())){
            return Response.status(Response.Status.CONFLICT).entity("An account with this username already exist !").build();
        }
        Node node = arborescenceRepository.findNode(dataManagerCreator.getIdNode(), Node.class);
        if(node == null){
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Node !").build();
        }
        DataManager dataManager = MedicalStaffFactory.createDataManagerFromCreator(dataManagerCreator, node);
        Long dataManagerID = staffRepository.saveMedicalStaff(dataManager);
        UserAccount userAccount = authenticationRepository.saveDataManagerAccount(dataManagerID, dataManagerCreator);

        return Response.ok("{\"userAccount\": " + userAccount + "}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a doctor account", response = UserAccount.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The User Account is created."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 409, message = "Username conflict")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
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
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
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
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    @Path("/delete/{idAccount}")
    public Response deleteUser(@PathParam("idAccount") Long idAccount) throws IOException {
        System.out.println("DELETE user");
        authenticationRepository.delete(idAccount);
        return Response.ok("{\"delete\":"+ idAccount +"}").build();
    }
    
    @GET
    @ApiOperation(value = "get all user account")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the user account."),
        @ApiResponse(code = 404, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response findAllUsers() {
        
        List<UserAccount> allUsers = authenticationRepository.findAllUsers();
        if (allUsers == null)
            return Response.status(NOT_FOUND).build();

        return Response.ok(allUsers).build();
    }
     
}
