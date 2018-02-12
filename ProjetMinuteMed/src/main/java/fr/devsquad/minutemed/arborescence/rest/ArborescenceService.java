package fr.devsquad.minutemed.arborescence.rest;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.arborescence.repository.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ejb.*;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/nodes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api("Arborescence REST Endpoint")
public class ArborescenceService {
    
    @EJB
    private ArborescenceRepository repository;
    
    
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
    public Response createAPHP(@NotNull NodeAPHP aphp) {
        try{
            repository.findNodeGeneric(new Long(1), NodeAPHP.class);
        }catch(EJBException ex){
            Long id = repository.saveGenericNode(aphp);
            return Response.ok("{\"idAPHPCreated\":"+ id +"}").build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity("APHP already exist !").build();
    }
    
    @POST
    @ApiOperation(value = "Create an Hospital")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospitals")
    public Response createHospital(@NotNull NodeHospital hospital) {
        if(hospital.getFather() == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The APHP node is required in the Hospital node !")
                    .build();
        }
        Long id = repository.saveGenericNode(hospital);
        return Response.ok("{\"idHospitalCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Pole")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Pole is created."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "The Hospital is not known.")}
    )
    @Path("/APHP/hospitals/{idHospital}/poles")
    public Response createPole(@NotNull NodePole pole) {
        if(pole.getFather() == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Hospital node is required in the Pole node !")
                    .build();
        }
        Long id = repository.saveGenericNode(pole);
        return Response.ok("{\"idPoleCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Service")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Service is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services")
    public Response createService(@NotNull NodeService service) {
        if(service.getFather() == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Pole node is required in the Service node !")
                    .build();
        }
        Long id = repository.saveGenericNode(service);
        return Response.ok("{\"idServiceCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Hospital Unit")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital Unit is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits")
    public Response createHospitalUnit(@NotNull NodeHU hu) {
        if(hu.getFather() == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Service node is required in the Hospital Unit node !")
                    .build();
        }
        Long id = repository.saveGenericNode(hu);
        return Response.ok("{\"idHUCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Care Unit")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Care Unit is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospitals/{idHospital}/poles/{idPole}/services/{idService}/hUnits/{idHU}/cUnits")
    public Response createCareUnit(@NotNull NodeCU cu) {
        if(cu.getFather() == null){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("The Hospital Unit node is required in the Care Unit node !")
                    .build();
        }
        Long id = repository.saveGenericNode(cu);
        return Response.ok("{\"idCUCreated\":"+ id +"}").build();
    }
    
    
    ///////////////
    //// GET /////
    /////////////
    
    
    @GET
    @Path("/APHP/hospitals")
    @ApiOperation(value = "Get all Hospitals of the APHP.", response = NodeHospital.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Hospitals are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospitals not found")}
    )
    public Response getHospitals() {
        List<NodeHospital> hospitals = repository.getGenericNodes(NodeHospital.class);
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
        NodeHospital hospital = repository.findNodeGeneric(idHospital, NodeHospital.class);
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
        List<NodePole> poles = repository.getGenericNodesWithFatherId(NodePole.class, idHospital);
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
    public Response getPole(@PathParam("idPole") Long idPole) {
        NodePole pole = repository.findNodeGeneric(idPole, NodePole.class);
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
    public Response getServices(@PathParam("idPole") Long idPole) {
        List<NodeService> services = repository.getGenericNodesWithFatherId(NodeService.class, idPole);
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
    public Response getService(@PathParam("idService") Long idService) {
        NodeService service = repository.findNodeGeneric(idService, NodeService.class);
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
    public Response getHospitalUnits(@PathParam("idService") Long idService) {
        List<NodeHU> hu = repository.getGenericNodesWithFatherId(NodeHU.class, idService);
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
    public Response getHospitalUnit(@PathParam("idHU") Long idHU) {
        NodeHU hu = repository.findNodeGeneric(idHU, NodeHU.class);
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
    public Response getCareUnits(@PathParam("idHU") Long idHU) {
        List<NodeCU> cu = repository.getGenericNodesWithFatherId(NodeCU.class, idHU);
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
    public Response getCareUnit(@PathParam("idCU") Long idCU) {
        NodeCU cu = repository.findNodeGeneric(idCU, NodeCU.class);
        return Response.ok(cu).build();
    }
}
