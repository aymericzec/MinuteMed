/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.staff.rest;

import fr.devsquad.minutemed.staff.domain.DataManager;
import fr.devsquad.minutemed.staff.domain.Doctor;
import fr.devsquad.minutemed.staff.domain.IHospitalStaff;
import fr.devsquad.minutemed.staff.domain.Nurse;
import fr.devsquad.minutemed.staff.repository.StaffRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ejb.EJB;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    
    @DELETE
    @Path("/doctor/{idDoctor}")
    @ApiOperation(value = "Delete a Doctor.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is deleted"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor not found")}
    )
    public Response deleteDoctor(@PathParam("idDoctor") Long idDoctor) {
        System.out.println("DELETE deleteDoctor("+idDoctor+")");
        
        repository.deleteDoctor(idDoctor);
        return Response.ok("{\"idDoctor\":"+idDoctor+"}").build();
    }
    
    @DELETE
    @Path("/nurse/{idNurse}")
    @ApiOperation(value = "Delete a Nurse.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is deleted"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse not found")}
    )
    public Response deleteNurse(@PathParam("idNurse") Long idNurse) {
        System.out.println("DELETE deleteNurse("+idNurse+")");
        
        repository.deleteNurse(idNurse);
        return Response.ok("{\"idNurse\":"+idNurse+"}").build();
    }
    
    ///////////////
    //// POST ////
    /////////////
    
    @POST
    @Path("/doctor")
    @ApiOperation(value = "Create a Doctor")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is created !"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor already exists")}
    )
    public Response createDoctor(@NotNull Doctor doctor) {
        System.out.println("POST createNurse("+doctor+")");
        
        repository.saveDoctor(doctor);
        return Response.ok("{\"firstName\":"+doctor.getFirstName()+"}").build();
    }
    
    @POST
    @Path("/nurse")
    @ApiOperation(value = "Create a Nurse")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is created !"),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse already exists")}
    )
    public Response createNurse(@NotNull Nurse nurse) {
        System.out.println("POST createNurse("+nurse+")");
        
        repository.saveNurse(nurse);
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
        System.out.println("GET getALLStaffs()");
        
        List<IHospitalStaff> staffs = repository.findAllStaffs();
        return Response.ok(staffs).build();
    }
    
    @GET
    @Path("/staff/dataManager/{idDataManager}")
    @ApiOperation(value = "Get a DataManager.", response = DataManager.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The DataManager is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "DataManager not exists")}
    )
    public Response getDatamanager(@PathParam("idDataManager") Long idDataManager) {
        System.out.println("GET getDatamanager("+idDataManager+")");
        
        DataManager staff = repository.findDataManager(idDataManager);
        return Response.ok(staff).build();
    }
    
    @GET
    @Path("/doctors")
    @ApiOperation(value = "Get all doctor.", response = Doctor.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Doctors are returned.")}
    )
    public Response getAllDoctors() {
        System.out.println("GET getAllDoctors()");
        
        List<Doctor> staffs = repository.findAllDoctor();
        return Response.ok(staffs).build();
    }
    
    @GET
    @Path("/staff/doctor/{idDoctor}")
    @ApiOperation(value = "Get a doctor.", response = Doctor.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Doctor is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Doctor not exists")}
    )
    public Response getDoctor(@PathParam("idDoctor") Long idDoctor) {
        System.out.println("GET getDoctor("+idDoctor+")");
        
        Doctor staff = repository.findDoctor(idDoctor);
        return Response.ok(staff).build();
    }
    
    @GET
    @Path("/nurses")
    @ApiOperation(value = "Get all nurses.", response = Nurse.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Nurses are returned.")}
    )
    public Response getAllNurses() {
        System.out.println("GET getAllNurses()");
        
        List<Nurse> staffs = repository.findAllNurse();
        return Response.ok(staffs).build();
    }
    
    @GET
    @Path("/staff/nurse/{idNurse}")
    @ApiOperation(value = "Get a nurse.", response = Nurse.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Nurse is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Nurse not exists")}
    )
    public Response getNurse(@PathParam("idNurse") Long idNurse) {
        System.out.println("GET getNurse("+idNurse+")");
        
        Nurse staff = repository.findNurse(idNurse);
        return Response.ok(staff).build();
    }
    
    
}
