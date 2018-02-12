package fr.devsquad.minutemed.arborescenceOld.rest;

import fr.devsquad.minutemed.arborescenceOld.domain.NodeAPHPOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeCUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHUOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeHospitalOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodePoleOld;
import fr.devsquad.minutemed.arborescenceOld.domain.NodeServiceOld;
import fr.devsquad.minutemed.arborescenceOld.repository.ArborescenceRepositoryOld;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.ejb.EJB;
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
    private ArborescenceRepositoryOld repository;
    
    
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
    public Response createAPHP(@NotNull NodeAPHPOld aphp) {
        Long id = repository.saveNodeAPHP(aphp);
        return Response.ok("{\"idAPHPCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create an Hospital")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospital")
    public Response createHospital(@NotNull NodeHospitalOld hospital) {
        Long id = repository.saveNodeHospital(hospital);
        return Response.ok("{\"idHospitalCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Pole")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Pole is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospital/{idHospital}/pole")
    public Response createPole(@PathParam("idHospital") Long idHospital, @NotNull NodePoleOld pole) {
        pole.setHospital(idHospital);
        Long id = repository.saveNodePole(pole);
        return Response.ok("{\"idPoleCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Service")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Service is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service")
    public Response createService(@PathParam("idPole") Long idPole, @NotNull NodeServiceOld service) {
        service.setPole(idPole);
        Long id = repository.saveNodeService(service);
        return Response.ok("{\"idServiceCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Hospital Unit")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital Unit is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}/hUnit")
    public Response createHospitalUnit(@PathParam("idService") Long idService, @NotNull NodeHUOld hu) {
        hu.setService(idService);
        Long id = repository.saveNodeHospitalUnit(hu);
        return Response.ok("{\"idHUCreated\":"+ id +"}").build();
    }
    
    @POST
    @ApiOperation(value = "Create a Care Unit")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Care Unit is created."),
        @ApiResponse(code = 400, message = "Invalid input")}
    )
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}/hUnit/{idHU}/cUnit")
    public Response createCareUnit(@PathParam("idHU") Long idHU, @NotNull NodeCUOld cu) {
        cu.setHospitalUnit(idHU);
        Long id = repository.saveNodeCareUnit(cu);
        return Response.ok("{\"idCUCreated\":"+ id +"}").build();
    }
    
    
    ///////////////
    //// GET /////
    /////////////
    
    
    @GET
    @Path("/APHP/hospitals")
    @ApiOperation(value = "Get all Hospitals of the APHP.", response = NodeHospitalOld.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Hospitals are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospitals not found")}
    )
    public Response getHospitals() {
        List<NodeHospitalOld> hospitals = repository.listNodeHospital();
        return Response.ok(hospitals).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}")
    @ApiOperation(value = "Get a specific Hospital.", response = NodeHospitalOld.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospital not found")}
    )
    public Response getHospital(@PathParam("idHospital") Long idHospital) {
        NodeHospitalOld hospital = repository.findNodeHospital(idHospital);
        return Response.ok(hospital).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/poles")
    @ApiOperation(value = "Get all Poles of an Hospital.", response = NodePoleOld.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Poles are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Poles not found")}
    )
    public Response getPoles(@PathParam("idHospital") Long idHospital) {
        List<NodePoleOld> poles = repository.listNodePole(idHospital);
        return Response.ok(poles).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}")
    @ApiOperation(value = "Get a specific Pole.", response = NodePoleOld.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Pole is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Pole not found")}
    )
    public Response getPole(@PathParam("idPole") Long idPole) {
        NodePoleOld pole = repository.findNodePole(idPole);
        return Response.ok(pole).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/services")
    @ApiOperation(value = "Get all Services of a Pole.", response = NodeServiceOld.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Services are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Services not found")}
    )
    public Response getServices(@PathParam("idPole") Long idPole) {
        List<NodeServiceOld> services = repository.listNodeService(idPole);
        return Response.ok(services).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}")
    @ApiOperation(value = "Get a specific Service.", response = NodeServiceOld.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Service is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Service not found")}
    )
    public Response getService(@PathParam("idService") Long idService) {
        NodeServiceOld service = repository.findNodeService(idService);
        return Response.ok(service).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}/hUnits")
    @ApiOperation(value = "Get all Hospital Units of a Service.", response = NodeHUOld.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Hospital Units are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospital Units not found")}
    )
    public Response getHospitalUnits(@PathParam("idService") Long idService) {
        List<NodeHUOld> hu = repository.listNodeHU(idService);
        return Response.ok(hu).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}/hUnit/{idHU}")
    @ApiOperation(value = "Get a specific Hospital Unit.", response = NodeHUOld.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Hospital Unit is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Hospital Unit not found")}
    )
    public Response getHospitalUnit(@PathParam("idHU") Long idHU) {
        NodeHUOld hu = repository.findNodeHospitalUnit(idHU);
        return Response.ok(hu).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}/hUnit/{idHU}/CUnits")
    @ApiOperation(value = "Get all Care Units of a Hospital Unit.", response = NodeCUOld.class, responseContainer = "List")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "All Care Units are returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Care Units not found")}
    )
    public Response getCareUnits(@PathParam("idHU") Long idHU) {
        List<NodeCUOld> cu = repository.listNodeCU(idHU);
        return Response.ok(cu).build();
    }
    
    @GET
    @Path("/APHP/hospital/{idHospital}/pole/{idPole}/service/{idService}/HUnit/{idHU}/CUnit/{idCU}")
    @ApiOperation(value = "Get a specific Care Unit.", response = NodeCUOld.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The Care Unit is returned."),
        @ApiResponse(code = 400, message = "Invalid input"),
        @ApiResponse(code = 404, message = "Care Unit not found")}
    )
    public Response getCareUnit(@PathParam("idCU") Long idCU) {
        NodeCUOld cu = repository.findNodeCareUnit(idCU);
        return Response.ok(cu).build();
    }
}
