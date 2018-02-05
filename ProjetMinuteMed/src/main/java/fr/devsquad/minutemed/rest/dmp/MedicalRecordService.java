/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.rest.dmp;

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
 * @author myfou
 */
@Path("/records")
public class MedicalRecordService {
    
    //http://localhost:8080/MinuteMed/api/records/4/dosages/5
    
    @POST
    @Path("{idRecord}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMedicalRecord(@PathParam("idRecord") Long idRecord) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"name\":"+idRecord+"}").build();
    }
    
    @POST
    @Path("{idRecord}/exams/{idExam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idExam\":"+idExam+" }").build();
    }
    
    @POST
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDiagnostic\":"+idDiagnostic+" }").build();
    }
    
    @POST
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idPrescription\":"+idPrescription+" }").build();
    }
    
    @POST
    @Path("{idRecord}/dosages/{idDosage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDosage\":"+idDosage+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}")
    @Produces(MediaType.APPLICATION_JSON)
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
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idExam\":"+idExam+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDiagnostic\":"+idDiagnostic+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idPrescription\":"+idPrescription+" }").build();
    }
    
    @DELETE
    @Path("{idRecord}/dosages/{idDosage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDosage\":"+idDosage+" }").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicalRecord() {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"getAll\":\"all\"}").build();
    }
    
    @GET
    @Path("{idRecord}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecord(@PathParam("idRecord") Long idRecord) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+"}").build();
    }
    
    @GET
    @Path("{idRecord}/exams")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExams(@PathParam("idRecord") Long idRecord) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"allExams\":"+idRecord+"}").build();
    }
    
    @GET
    @Path("{idRecord}/exams/{idExam}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getExam(@PathParam("idRecord") Long idRecord, @PathParam("idExam") Long idExam) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idExam\":"+idExam+" }").build();
    }
    
    @GET
    @Path("{idRecord}/diagnostics")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiagnostics(@PathParam("idRecord") Long idRecord) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"allDiagnostics\":"+idRecord+"}").build();
    }
    
    
    @GET
    @Path("{idRecord}/diagnostics/{idDiagnostic}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDiagnostic(@PathParam("idRecord") Long idRecord, @PathParam("idDiagnostic") Long idDiagnostic) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDiagnostic\":"+idDiagnostic+" }").build();
    }
    
    @GET
    @Path("{idRecord}/prescriptions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptions(@PathParam("idRecord") Long idRecord) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"allPrescriptions\":"+idRecord+"}").build();
    }
    
    @GET
    @Path("{idRecord}/prescriptions/{idPrescription}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescription(@PathParam("idRecord") Long idRecord, @PathParam("idPrescription") Long idPrescription) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idPrescription\":"+idPrescription+" }").build();
    }
    
    @GET
    @Path("{idRecord}/dosages")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDosages(@PathParam("idRecord") Long idRecord) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"allDosages\":"+idRecord+"}").build();
    }
    
    @GET
    @Path("{idRecord}/dosages/{idDosage}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDosage(@PathParam("idRecord") Long idRecord, @PathParam("idDosage") Long idDosage) {
        /*Book book = repository.find(id);
        if (book == null)
            return Response.status(Response.Status.NOT_FOUND).build();*/
        return Response.ok("{\"idRecord\":"+idRecord+", \"idDosage\":"+idDosage+" }").build();
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
