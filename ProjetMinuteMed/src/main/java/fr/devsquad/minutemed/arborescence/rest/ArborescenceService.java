package fr.devsquad.minutemed.arborescence.rest;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.arborescence.domain.Node;
import fr.devsquad.minutemed.arborescence.repository.*;
import fr.devsquad.minutemed.jwt.filter.JWTNeeded;
import fr.devsquad.minutemed.jwt.util.*;
import fr.devsquad.minutemed.staff.domain.*;
import fr.devsquad.minutemed.staff.repository.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.*;
import javax.ejb.*;
import javax.inject.*;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

@Path("/nodes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
//@JWTNeeded(groups = {StaffEnum.DATA_MANAGER})
@Api("Arborescence REST Endpoint")
public class ArborescenceService {
    
    @EJB
    private ArborescenceRepository repository;
    
    @EJB
    private StaffRepository staffRepository;
   
    @Inject
    private TokenUtils tokenUtils;
    
    ///////////////
    //// POST ////
    /////////////
    
    
    @POST
    @ApiOperation(value = "Create the APHP")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The APHP is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP")
    public Response createAPHP() {
        NodeAPHP aphp = repository.findNode(51L, NodeAPHP.class);
        if(aphp == null){
            Long id = repository.saveNode(new NodeAPHP());
            return Response.ok("{\"idAPHPCreated\":"+ id +"}").build();
        }
        return Response.status(Response.Status.CONFLICT)
                .entity("APHP already exist !").build();
    }
    
    
    @POST
    @ApiOperation(value = "Create an Hospital")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/{idAPHP}/hospitals")
    public Response createHospital(@PathParam("idAPHP") Long idAPHP) {
        NodeAPHP aphp = repository.findNode(idAPHP, NodeAPHP.class);
        if(aphp == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("This APHP node does not exist !")
                    .build();
        }
        System.out.println(aphp.getIdNode());
        NodeHospital hospital = new NodeHospital(aphp);
        Long id = repository.saveNode(hospital);
        System.out.println(id);
        if(!aphp.addHospital(hospital)){
            repository.removeNode(hospital);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("This Hospital already exist in the APHP !")
                    .build();           
        }
        return Response.ok("{\"idHospitalCreated\":"+ id +"}").build();
    }
    
    
    @POST
    @ApiOperation(value = "Create a Pole")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Pole is created."),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "Unknow node.")}
    )
    @Path("/APHP/{idAPHP}/hospitals/{idHospital}/poles")
    public Response createPole(@PathParam("idAPHP") Long idAPHP, @PathParam("idHospital") Long idHospital) {
        NodeHospital hospital = repository.findNode(idHospital, NodeHospital.class);
        if(hospital == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Hospital node is required in the Pole node !")
                    .build();
        }
        if(hospital.getFather().getIdNode() != idAPHP){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idAPHP param is not equal to the father id !")
                    .build();            
        }
        NodePole pole = new NodePole(hospital);
        Long id = repository.saveNode(pole);
        if(!hospital.addPole(pole)){
            repository.removeNode(pole);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("This Pole already exist in the Hospital !")
                    .build();           
        }
        //repository.refreshNode(hospital);
        return Response.ok("{\"idPoleCreated\":"+ id +"}").build();
    }
    
    
    @POST
    @ApiOperation(value = "Create a Service")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Service is created."),
        @ApiResponse(code = 400, message = "Invalid input."),
        @ApiResponse(code = 404, message = "Unknow node.")}
    )
    @Path("/APHP/{idAPHP}/hospitals/{idHospital}/poles/{idPole}/services")
    public Response createService(@PathParam("idAPHP") Long idAPHP, @PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole) {
        NodePole pole = repository.findNode(idPole, NodePole.class);
        if(pole == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Pole node is required in the Service node !")
                    .build();
        }
        if(pole.getIdNode() != idPole){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idPole param is not equal to the father id !")
                    .build(); 
        }
        if(pole.getFather().getIdNode() != idHospital){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idHospital param is not equal to the father id !")
                    .build(); 
        }
        if(pole.getFather().getFather().getIdNode() != idAPHP){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idAPHP param is not equal to the father id !")
                    .build(); 
        }
        NodeService service = new NodeService(pole);
        Long id = repository.saveNode(service);
        if(!pole.addService(service)){
            repository.removeNode(service);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("This Service already exist in the Pole !")
                    .build();           
        }
        //repository.refreshNode(pole);
        return Response.ok("{\"idServiceCreated\":"+ id +"}").build();
    }
    
    
    @POST
    @ApiOperation(value = "Create a Hospital Unit")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital Unit is created."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Unknow node.")}
    )
    @Path("/APHP/{idAPHP}/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits")
    public Response createHospitalUnit(@PathParam("idAPHP") Long idAPHP, @PathParam("idHospital") Long idHospital,
            @PathParam("idPole") Long idPole, @PathParam("idService") Long idService) {
        NodeService service = repository.findNode(idService, NodeService.class);
        if(service == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Service node is required in the Hospital Unit node !")
                    .build();
        }
        if(service.getIdNode() != idService){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idService param is not equal to the father id !")
                    .build(); 
        }
        if(service.getFather().getIdNode() != idPole){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idPole param is not equal to the father id !")
                    .build(); 
        }
        if(service.getFather().getFather().getIdNode() != idHospital){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idHospital param is not equal to the father id !")
                    .build(); 
        }
        if(service.getFather().getFather().getFather().getIdNode() != idAPHP){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idAPHP param is not equal to the father id !")
                    .build(); 
        }
        NodeHU hu = new NodeHU(service);
        try{
            Long id = repository.saveNode(hu);
        }catch(EJBException cve){
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity("J'ai pas compris..").build();
        }
        /*
        if(!service.addHospitalUnit(hu)){
            repository.removeNode(hu);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("This Hospital Unit already exist in the Service !")
                    .build();           
        }*/
        //repository.refreshNode(service);
        return Response.status(Response.Status.CREATED).entity("{\"idHUCreated\":"+ 101 +"}").build();
    }
    
    
    @POST
    @ApiOperation(value = "Create a Care Unit")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Care Unit is created."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Unknow node.")}
    )
    @Path("/APHP/{idAPHP}/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits/{idHU}/cUnits")
    public Response createCareUnit(@PathParam("idAPHP") Long idAPHP, @PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole,
            @PathParam("idService") Long idService, @PathParam("idHU") Long idHU, @NotNull NodeCU cu) {
        NodeHU hospitalUnit = cu.getFather();
        if(hospitalUnit == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Hospital Unit node is required in the Care Unit node !")
                    .build();
        }
        if(hospitalUnit.getIdNode() != idHU){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idHU param is not equal to the father id !")
                    .build(); 
        }
        if(hospitalUnit.getFather().getIdNode() != idService){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idService param is not equal to the father id !")
                    .build(); 
        }
        if(hospitalUnit.getFather().getFather().getIdNode() != idPole){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idPole param is not equal to the father id !")
                    .build(); 
        }
        if(hospitalUnit.getFather().getFather().getFather().getIdNode() != idHospital){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idHospital param is not equal to the father id !")
                    .build(); 
        }
        if(hospitalUnit.getFather().getFather().getFather().getFather().getIdNode() != idAPHP){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The idAPHP param is not equal to the father id !")
                    .build(); 
        }
        Long id = repository.saveNode(cu);
        if(!hospitalUnit.addCareUnit(cu)){
            repository.removeNode(cu);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("This Care Unit already exist in the Hospital Unit !")
                    .build();           
        }
        //repository.refreshNode(hospitalUnit);
        return Response.ok("{\"idCUCreated\":"+ id +"}").build();
    }
    
    
    ///////////////
    //// GET /////
    /////////////
    
    @GET
    @Path("/APHP")
    @ApiOperation(value = "Get the APHP.", response = NodeAPHP.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Hospitals are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospitals not found")}
    )
    public Response getAPHP() {
        
        List<NodeAPHP> aphps = repository.findNodes(NodeAPHP.class);
        if(aphps.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(aphps.get(0)).build();
    }
    
    @GET
    @Path("/APHP/hospitals")
    @ApiOperation(value = "Get all Hospitals of the APHP.", response = NodeHospital.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Hospitals are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospitals not found")}
    )
    public Response getHospitals() {
        List<NodeHospital> hospitals = repository.findNodes(NodeHospital.class);
        return Response.ok(hospitals).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}")
    @ApiOperation(value = "Get a specific Hospital.", response = NodeHospital.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospital not found")}
    )
    public Response getHospital(@PathParam("idHospital") Long idHospital) {
        NodeHospital hospital = repository.findNode(idHospital, NodeHospital.class);
        return Response.ok(hospital).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles")
    @ApiOperation(value = "Get all Poles of an Hospital.", response = NodePole.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Poles are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Poles not found")}
    )
    public Response getPoles(@PathParam("idHospital") Long idHospital) {
        List<NodePole> poles = repository.findNodesWithFatherId(NodePole.class, idHospital);
        return Response.ok(poles).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}")
    @ApiOperation(value = "Get a specific Pole.", response = NodePole.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Pole is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Pole not found")}
    )
    public Response getPole(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole) {
        NodePole pole = repository.findNode(idPole, NodePole.class);
        if(pole.getFather().getIdNode() != idHospital){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error with the idHospital param.").build();
        }
        return Response.ok(pole).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services")
    @ApiOperation(value = "Get all Services of a Pole.", response = NodeService.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Services are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Services not found")}
    )
    public Response getServices(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole) {
        List<NodeService> services = repository.findNodesWithFatherId(NodeService.class, idPole);
        return Response.ok(services).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}")
    @ApiOperation(value = "Get a specific Service.", response = NodeService.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Service is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Service not found")}
    )
    public Response getService(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole, @PathParam("idService") Long idService) {
        NodeService service = repository.findNode(idService, NodeService.class);
        return Response.ok(service).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits")
    @ApiOperation(value = "Get all Hospital Units of a Service.", response = NodeHU.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Hospital Units are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospital Units not found")}
    )
    public Response getHospitalUnits(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole, @PathParam("idService") Long idService) {
        List<NodeHU> hu = repository.findNodesWithFatherId(NodeHU.class, idService);
        return Response.ok(hu).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits/{idHU}")
    @ApiOperation(value = "Get a specific Hospital Unit.", response = NodeHU.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital Unit is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospital Unit not found")}
    )
    public Response getHospitalUnit(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole, @PathParam("idService") Long idService, @PathParam("idHU") Long idHU) {
        NodeHU hu = repository.findNode(idHU, NodeHU.class);
        return Response.ok(hu).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits/{idHU}/CUnits")
    @ApiOperation(value = "Get all Care Units of a Hospital Unit.", response = NodeCU.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Care Units are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Care Units not found")}
    )
    public Response getCareUnits(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole, @PathParam("idService") Long idService, @PathParam("idHU") Long idHU) {
        List<NodeCU> cu = repository.findNodesWithFatherId(NodeCU.class, idHU);
        return Response.ok(cu).build();
    }
    
    @GET
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}/HUnits/{idHU}/CUnits/{idCU}")
    @ApiOperation(value = "Get a specific Care Unit.", response = NodeCU.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Care Unit is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Care Unit not found")}
    )
    public Response getCareUnit(@PathParam("idHospital") Long idHospital, @PathParam("idPole") Long idPole, @PathParam("idService") Long idService, @PathParam("idHU") Long idHU, @PathParam("idCU") Long idCU) {
        NodeCU cu = repository.findNode(idCU, NodeCU.class);
        return Response.ok(cu).build();
    }
    

    
    @GET
    @ApiOperation(value = "Get all accessible Care Units.", response = NodeCU.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All accessible Care Units are returned."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @JWTNeeded(groups = {StaffEnum.DOCTOR})
    public Response getAccessibleCareUnits(@HeaderParam(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        String token = authorizationHeader.substring("Bearer".length()).trim();
        MedicalStaff user = staffRepository.findMedicalStaff(tokenUtils.decryptIdFromToken(token));
        Set<NodeCU> careUnits = repository.findNode(user.getNode().getIdNode(), Node.class).getAccessibleNode();
        return Response.ok(careUnits).build();
    }
    
    
    
}
