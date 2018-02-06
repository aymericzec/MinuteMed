/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.rest.dmp;

import fr.devsquad.minutemed.dmp.*;
import io.swagger.annotations.*;
import java.util.*;
import javax.validation.constraints.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author myfou
 */
@Path("/records")
@Api("MedicalRecords REST Endpoint")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MedicalRecordService {
    
    //Example URL with params : 
    //http://localhost:8080/ProjetMinuteMed/api/records/4/dosages/5
    
    /////////////////////////
    //// POST
    /////////////////////////
    
    @POST
    @ApiOperation(value = "Create a medical record")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Medical Record is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    public Response createMedicalRecord(@NotNull MedicalRecord medicalRecord) {
        
        return Response.ok("{\"firstName\":"+medicalRecord.getFirstName()+"}").build();
    }
    
    @POST
    @Path("{idRecord}/exams")
    @ApiOperation(value = "Create an Exam in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Exam is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    public Response createExam(@PathParam("idRecord") Long idRecord, @NotNull Exam exam) {

        return Response.ok("{\"idRecord\":"+idRecord+", \"examTitle\":"+exam.getTitle()+" }").build();
    }
    
    @POST
    @Path("{idRecord}/diagnostics")
    @ApiOperation(value = "Create a Diagnostic in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Diagnostic is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    public Response createDiagnostic(@PathParam("idRecord") Long idRecord, @NotNull Diagnostic diagnostic) {

        return Response.ok("{\"idRecord\":"+idRecord+", \"diagnosticTitle\":"+diagnostic.getTitle()+" }").build();
    }
    
    @POST
    @Path("{idRecord}/prescriptions")
    @ApiOperation(value = "Create a Prescription in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Prescription is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    public Response createPrescription(@PathParam("idRecord") Long idRecord, @NotNull Prescription prescription) {

        return Response.ok("{\"idRecord\":"+idRecord+", \"prescriptionTitle\":"+prescription.getTitle()+" }").build();
    }
    
    @POST
    @Path("{idRecord}/dosages")
    @ApiOperation(value = "Create a Dosage in the Medical Record associated")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Dosage is created !"),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    public Response createDosage(@PathParam("idRecord") Long idRecord, @NotNull Dosage dosage) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"dosageTitle\":"+dosage+" }").build();
    }
    
    
    /////////////////////////
    //// DELETE
    /////////////////////////
    
    @DELETE
    @Path("{idRecord}")
    @ApiOperation(value = "Delete a Medical Record.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Medical Record is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    public Response deleteMedicalRecord(@PathParam("idRecord") Long idRecord) {
        /*try {
            repository.delete(id);
        } catch (NoSuchEntityException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }*/
        return Response.ok("{\"idRecord\":"+idRecord+"}").build();
    }
    
    @DELETE
    @Path("{idRecord}/exams/{idExam}")
    @ApiOperation(value = "Delete an Exam.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Exam is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Exam not found")}
    )
    public Response deleteExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idExam\":"+idExam+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @ApiOperation(value = "Delete a Diagnostic.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Diagnostic is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Diagnostic not found")}
    )
    public Response deleteDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDiagnostic\":"+idDiagnostic+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @ApiOperation(value = "Delete a Prescription.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Prescription is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Prescription not found")}
    )
    public Response deletePrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idPrescription\":"+idPrescription+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/dosages/{idDosage}")
    @ApiOperation(value = "Delete a Dosage.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Dosage is deleted."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Dosage not found")}
    )
    public Response deleteDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDosage\":"+idDosage+" }").build();
    }
    
    
    
    
    /////////////////////////
    //// GET
    /////////////////////////
    
    
    @GET
    @ApiOperation(value = "Get all Medical Records.", response = MedicalRecord.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Medical Records are returned.")}
    )
    public Response getAllMedicalRecord() {
        return Response.ok("{\"idRecord\":5 }").build();
    }
    
    @GET
    @Path("{idRecord}")
    @ApiOperation(value = "Get a specific Medical Record.", response = MedicalRecord.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Medical Record is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    public Response getMedicalRecord(@PathParam("idRecord") Long idRecord) {
        MedicalRecord m = new MedicalRecord();
        return Response.ok(m).build();
    }
    
    @GET
    @Path("{idRecord}/exams")
    @ApiOperation(value = "Get all Exams associated with a Medical Record.", response = Exam.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Exams are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    public Response getExams(@PathParam("idRecord") Long idRecord) {
        List<Exam> exams = new ArrayList<>();
        return Response.ok(exams).build();
    }
    
    @GET
    @Path("{idRecord}/exams/{idExam}")
    @ApiOperation(value = "Get a specific Exam associated with a Medical Record.", response = Exam.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Exam is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Exam not found")}
    )
    public Response getExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        Exam exam = new Exam();
        return Response.ok(exam).build();
    }
    
    @GET
    @Path("{idRecord}/diagnostics")
    @ApiOperation(value = "Get all Diagnostics associated with a Medical Record.", response = Diagnostic.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Diagnostics are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    public Response getDiagnostics(@PathParam("idRecord") Long idRecord) {
        List<Diagnostic> diagnostics = new ArrayList<>();
        return Response.ok(diagnostics).build();
    }
    
    
    @GET
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @ApiOperation(value = "Get a specific Diagnostic associated with a Medical Record.", response = Diagnostic.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Diagnostic is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Diagnostic not found")}
    )
    public Response getDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        Diagnostic diagnostic = new Diagnostic();
        return Response.ok(diagnostic).build();
    }
    
    @GET
    @Path("{idRecord}/prescriptions")
    @ApiOperation(value = "Get all Prescriptions associated with a Medical Record.", response = Prescription.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Prescriptions are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    public Response getPrescriptions(@PathParam("idRecord") Long idRecord) {
        List<Prescription> prescriptions = new ArrayList<>();
        return Response.ok(prescriptions).build();
    }
    
    @GET
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @ApiOperation(value = "Get a specific Prescription associated with a Medical Record.", response = Prescription.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Prescription is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Prescription not found")}
    )
    public Response getPrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        Prescription prescription = new Prescription();
        return Response.ok(prescription).build();
    }
    
    @GET
    @Path("{idRecord}/dosages")
    @ApiOperation(value = "Get all Dosages associated with a Medical Record.", response = Dosage.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All the Dosages are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record not found")}
    )
    public Response getAllDosages(@PathParam("idRecord") Long idRecord) {
        List<Dosage> dosages = new ArrayList<>();
        return Response.ok(dosages).build();
    }
    
    @GET
    @Path("{idRecord}/dosages/{idDosage}")
    @ApiOperation(value = "Get a specific Dosage associated with a Medical Record.", response = Dosage.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Dosage is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Medical Record or Dosage not found")}
    ) 
    public Response getDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        Dosage dosage = new Dosage();
        return Response.ok(dosage).build();
    }
        
    /* exemple de Json à passer dans le post 
   
    {
        "ss":"194061202154",
        "firstName":"Aymeric",
        "lastName":"Zecchini",
        "address":"9 rue des Lilas",
        "birthday":"02/03/94",
        "gender":"M",
        "phoneNumber":"0770138334",
        "email":"zec@gmail.com"
    }
    
    mettre en header => content-type : /application/json
    */    

}
