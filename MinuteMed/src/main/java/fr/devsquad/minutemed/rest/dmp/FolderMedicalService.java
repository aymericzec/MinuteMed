/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.rest.dmp;

import fr.devsquad.minutemed.database.JPADoctor;
import fr.devsquad.minutemed.dmp.GenderEnum;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author myfou
 */
@Path("/record")
public class FolderMedicalService extends Application {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMedicalRecord(MedicalRecord medicalRecord) throws IOException {
        JPADoctor doctor = new JPADoctor();
        doctor.createMedicalRecord(medicalRecord);
        
        System.out.println("toto la vache");
        
        JsonArrayBuilder result = Json.createArrayBuilder(); 
        
        return Response.status(201).entity(result).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecord() throws IOException {
        //MedicalRecord medicalRecord = new MedicalRecord("194061202154", "Aymeric", "Zecchini", "zec@gmail.com", "zec@gmail.com", "0770138334", "02/03/94", GenderEnum.M);
        
        System.out.println("test");
        
        JsonArrayBuilder result = Json.createArrayBuilder(); 
        result.add(3.14);
        
        return Response.status(201).entity(result).build();

    }
    
}
