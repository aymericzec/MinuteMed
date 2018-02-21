/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.rest;

import fr.devsquad.minutemed.jwt.filter.JWTNeeded;
import fr.devsquad.minutemed.jwt.util.TokenUtils;
import fr.devsquad.minutemed.staff.domain.*;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author JSalmon
 */

@Path("/staffs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("Staff REST Endpoint")
public class StaffService {
    
    @EJB
    private StaffRepository repository;
    
    @Inject
    private TokenUtils tokenUtils;
    
    
    ///////////////
    /// DELETE ///
    /////////////
    
    //TODO:  A BOUGER DANS ABRBORESCENCE
    
    
    @DELETE
    @Path("/doctors/{idDoctor}")
    @ApiOperation(value = "Delete a Doctor.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is deleted"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response deleteDoctor(@PathParam("idDoctor") Long idDoctor) {
        System.out.println("DELETE deleteDoctor("+idDoctor+")");
        
        repository.deleteMedicalStaff(idDoctor, Doctor.class);
        return Response.ok("{\"idDoctor\":"+idDoctor+"}").build();
    }
    
    @DELETE
    @Path("/nurses/{idNurse}")
    @ApiOperation(value = "Delete a Nurse.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is deleted"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse not found")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response deleteNurse(@PathParam("idNurse") Long idNurse) {
        System.out.println("DELETE deleteNurse("+idNurse+")");
        
        repository.deleteMedicalStaff(idNurse, Nurse.class);
        return Response.ok("{\"idNurse\":"+idNurse+"}").build();
    }
    
    
    //////////////
    //// GET ////
    ////////////
    
    @GET
    @ApiOperation(value = "Get all staff.", response = MedicalStaff.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Staff Hospital are returned.")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response getAllStaffs() {
        System.out.println("GET getALLStaffs()");
        
        List<MedicalStaff> staffs = repository.findAllMedicalStaffs();
        return Response.ok(staffs).build();
    }
    
    @GET
    @Path("/dataManagers/{idDataManager}")
    @ApiOperation(value = "Get a DataManager.", response = DataManager.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The DataManager is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "DataManager not exists")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response getDatamanager(@PathParam("idDataManager") Long idDataManager) {
        System.out.println("GET getDatamanager("+idDataManager+")");
        
        DataManager staff = repository.findMedicalStaff(idDataManager, DataManager.class);
        return Response.ok(staff).build();
    }
    
    @GET
    @Path("/doctors")
    @ApiOperation(value = "Get all doctor.", response = Doctor.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Doctors are returned.")}
    )
    //@JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response getAllDoctors() {
        System.out.println("GET getAllDoctors()");
        
        List<Doctor> staffs = repository.findMedicalStaffs(Doctor.class);
        return Response.ok(staffs).build();
    }
    
    @GET
    @Path("/doctors/{idDoctor}")
    @ApiOperation(value = "Get a doctor.", response = Doctor.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor not exists")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER, StaffEnum.DOCTOR})
    public Response getDoctor(@PathParam("idDoctor") Long idDoctor) {
        System.out.println("GET getDoctor("+idDoctor+")");
        
        Doctor staff = repository.findMedicalStaff(idDoctor, Doctor.class);
        return Response.ok(staff).build();
    }
    
    @GET
    @Path("/nurses")
    @ApiOperation(value = "Get all nurses.", response = Nurse.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Nurses are returned.")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
    public Response getAllNurses() {
        System.out.println("GET getAllNurses()");
        
        List<Nurse> staffs = repository.findMedicalStaffs(Nurse.class);
        return Response.ok(staffs).build();
    }
    
    @GET
    @Path("/nurses/{idNurse}")
    @ApiOperation(value = "Get a nurse.", response = Nurse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse not exists")}
    )
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER, StaffEnum.NURSE})
    public Response getNurse(@PathParam("idNurse") Long idNurse) {
        System.out.println("GET getNurse("+idNurse+")");
        
        Nurse staff = repository.findMedicalStaff(idNurse, Nurse.class);
        return Response.ok(staff).build();
    }
    
    @GET
    @Path("/me")
    @ApiOperation(value = "Get the current staff.", response = MedicalStaff.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The MedicalStaff is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "MedicalStaff not exists")}
    )
    @JWTNeeded(groups = {StaffEnum.ALL})
    public Response getCurrentUser(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer".length()).trim();
        Long id = tokenUtils.decryptIdFromToken(token);
        MedicalStaff me = repository.findMedicalStaff(id);
        if(me == null){
            return Response.status(Response.Status.NOT_FOUND).entity("Bad id !").build();
        }
        return Response.status(Response.Status.OK).entity(me).build();
    }
    
}
