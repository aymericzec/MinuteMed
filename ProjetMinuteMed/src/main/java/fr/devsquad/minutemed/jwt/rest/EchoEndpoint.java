package fr.devsquad.minutemed.jwt.rest;

import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.jwt.util.KeyGenerator;
import fr.devsquad.minutemed.jwt.util.SimpleKeyGenerator;
import fr.devsquad.minutemed.staff.domain.StaffEnum;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import javax.ws.rs.core.UriInfo;
import fr.devsquad.minutemed.jwt.filter.JWTNeeded;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/echo")
@Produces(TEXT_PLAIN)
public class EchoEndpoint {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Context
    private UriInfo uriInfo;
    
    @Inject
    private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @GET
    public Response echo(@QueryParam("message") String message) {
        return Response.ok().entity(message == null ? "no message" : message).build();
    }

    @GET
    @Path("jwt")
    @JWTNeeded(groups = {StaffEnum.DATA_MANAGER, StaffEnum.DOCTOR})
    public Response echoWithJWTToken(@QueryParam("message") String message, ContainerRequestContext requestContext) {
        System.out.println("MinuteMed JWT Hello !");
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        System.out.println(authorizationHeader);
        return Response.ok().entity(message == null ? "no message" : message).build();
    }
    
    @GET
    @Path("test")
    public Response test(){
        UserAccount user = new UserAccount(5L, "younessky", "1234", StaffEnum.DATA_MANAGER);
        
        KeyGenerator keyGenerator = new SimpleKeyGenerator();
        
        Key key = keyGenerator.generateKey();
        
        String jwtToken = Jwts.builder()
                .setSubject(user.getIdAccount().toString())
                .setIssuer(uriInfo.getPath())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
        System.out.println(jwtToken);
        key = keyGenerator.generateKey();
        System.out.println(Jwts.parser().setSigningKey(key).parseClaimsJws(jwtToken).getBody().getSubject());
        
        return Response.ok().entity(jwtToken).build();
    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}
