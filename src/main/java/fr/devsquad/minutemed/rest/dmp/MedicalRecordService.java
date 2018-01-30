/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.rest.dmp;

import fr.devsquad.minutemed.database.JPADoctor;
import fr.devsquad.minutemed.dmp.MedicalRecord;
import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author myfou
 */
@Path("/record")
public class MedicalRecordService {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMedicalRecord(MedicalRecord medicalRecord) throws IOException {
        System.out.println("POST");
        JPADoctor doctor = new JPADoctor();
        doctor.createMedicalRecord(medicalRecord);
        
        return Response.ok(medicalRecord.getId()).build();

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
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecord() throws IOException {

        System.out.println("GET");
        
        return Response.ok("{\"name\":5}").build();

    }
    

}
