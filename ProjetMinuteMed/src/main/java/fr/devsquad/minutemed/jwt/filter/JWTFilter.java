package fr.devsquad.minutemed.jwt.filter;

import fr.devsquad.minutemed.authentication.domain.UserAccount;
import fr.devsquad.minutemed.authentication.repository.AuthenticationRepository;
import fr.devsquad.minutemed.jwt.util.*;
import fr.devsquad.minutemed.staff.domain.StaffEnum;


import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Provider
@JWTNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter {

    @EJB
    private AuthenticationRepository authenticationRepository;
    
    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private Logger logger;

    @Inject
    private TokenUtils tokenUtils;
    
    @Context
    ResourceInfo resourceInfo;

    // ======================================
    // =          Business methods          =
    // ======================================

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        List<String> groups = new ArrayList<>();
        
        Class<?> resourceClass = resourceInfo.getResourceClass();
        JWTNeeded classAnnot = resourceClass.getAnnotation(JWTNeeded.class);
        if (classAnnot != null) {
          Arrays.stream(classAnnot.groups()).map(group -> group.name()).forEach(groups::add);
        }

        Method resourceMethod = resourceInfo.getResourceMethod();
        JWTNeeded methodAnnot = resourceMethod.getAnnotation(JWTNeeded.class);
        if (methodAnnot != null) {
            Arrays.stream(methodAnnot.groups()).map(group -> group.name()).forEach(groups::add);
        }
        
        if(groups.isEmpty()){
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            return;
        }
        CheckToken(requestContext, groups);
    }
    
    private void CheckToken(ContainerRequestContext requestContext, List<String> groups) throws NotAuthorizedException {
        Objects.requireNonNull(groups);
        logger.info("FILTER");
        // Get the HTTP Authorization header from the request
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        logger.info("#### authorizationHeader : " + authorizationHeader);

        // Check if the HTTP Authorization header is present and formatted correctly
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            logger.severe("#### invalid authorizationHeader : " + authorizationHeader);
            throw new NotAuthorizedException("Authorization header must be provided");
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring("Bearer".length()).trim();

        try {
    
            Long id = tokenUtils.decryptIdFromToken(token);

            UserAccount user = authenticationRepository.find(id);
            //if user id don't exist
            if (user == null) {
                throw new Exception(); 
            }
            //test the role of the user
            if (!groups.contains(user.getType()) && !groups.contains(StaffEnum.ALL.name())) {
                throw new Exception(); 
            }

            logger.info("#### valid token : " + token);

        } catch (Exception e) {
            logger.severe("#### invalid token : " + token);
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

}