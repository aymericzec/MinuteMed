/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.rest;

import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author JSalmon
 */

@Path("/staff")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("Staff REST Endpoint")
public class StaffService {
    
    @EJB
    private StaffRepository repository;
    
    
    ///////////////
    /// DELETE ///
    /////////////
    
    @Delete
    @Path("/doctor/{idDoctor}")
    @ApiOperation(value = "Delete a Doctor.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is deleted"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor not found")}
    )
    public Response deleteDoctor(@PathParam("idDoctor") Long idDoctor) {
        
        return return Response.ok("{\"idDoctor\":"+idDoctor+"}").build();
    }
    
    @Delete
    @Path("/nurse/{idNurse}")
    @ApiOperation(value = "Delete a Nurse.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is deleted"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse not found")}
    )
    public Response deleteDoctor(@PathParam("idNurse") Long idNurse) {
        
        return return Response.ok("{\"idNurse\":"+idNurse+"}").build();
    }
    
    ///////////////
    //// POST ////
    /////////////
    
    @Post
    @Path("/doctor")
    @ApiOperation(value = "Create a Doctor")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is created !"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor already exists")}
    )
    public Response createDoctor(@NotNull Doctor doctor) {
        
        return Response.ok("{\"firstName\":"+doctor.getFirstName()+"}").build();
    }
    
    @Post
    @Path("/nurse")
    @ApiOperation(value = "Create a Nurse")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is created !"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse already exists")}
    )
    public Response createNurse(@NotNull Nurse nurse) {
        
        return Response.ok("{\"firstName\":"+nurse.getFirstName()+"}").build();
    }
    
    //////////////
    //// GET ////
    ////////////
    
    @GET
    @Path("/")
    @ApiOperation(value = "Get all staff.", response = IHospitalStaff.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Staff Hospital are returned.")}
    )
    public Response getAllStaffs() {
        return Response.ok("{\"idHospitalStaff\" }").build();
    }
    
    @GET
    @Path("/staff/dataManager/{idDataManager}")
    @ApiOperation(value = "Get a DataManager.", reponse = DataManager.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The DataManager is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "DataManager not exists")}
    )
    public Response getDatamanager(@PathParam("idDataManager") Long idDataManager) {
        return Response.ok("{\"idDataManager\":"+idDataManager+"}").build();
    }
    
    @GET
    @Path("/doctors")
    @ApiOperation(value = "Get all doctor.", response = Doctor.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Doctors are returned.")}
    )
    public Response getAllDoctors() {
        return Response.ok("{\"idDoctor\" }").build();
    }
    
    @GET
    @Path("/staff/doctor/{idDoctor}")
    @ApiOperation(value = "Get a doctor.", reponse = Doctor.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor not exists")}
    )
    public Response getDoctor(@PathParam("idDoctor") Long idDoctor) {
        return Response.ok("{\"idDoctor\":"+idDoctor+"}").build();
    }
    
    @GET
    @Path("/nurses")
    @ApiOperation(value = "Get all nurses.", response = Nurse.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Nurses are returned.")}
    )
    public Response getAllNurses() {
        return Response.ok("{\"idNurse\" }").build();
    }
    
    @GET
    @Path("/staff/nurse/{idNurse}")
    @ApiOperation(value = "Get a nurse.", reponse = Nurse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse not exists")}
    )
    public Response getNurse(@PathParam("idNurse") Long idNurse) {
        return Response.ok("{\"idNurse\":"+idNurse+"}").build();
    }
    
    
}
