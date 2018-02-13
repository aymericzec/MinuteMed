package fr.devsquad.minutemed.application;

//import fr.devsquad.minutemed.arborescence.rest.ArborescenceService;
//import fr.devsquad.minutemed.filters.rest.CORSFilter;
//import fr.devsquad.minutemed.authentication.rest.AuthenticationService;
//import fr.devsquad.minutemed.dmp.rest.MedicalRecordService;
import fr.devsquad.minutemed.jwt.filter.JWTTokenNeededFilter;
import fr.devsquad.minutemed.jwt.rest.EchoEndpoint;
import fr.devsquad.minutemed.jwt.rest.UserEndpoint;

import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(JacksonFeature.class);
        //c.add(ArborescenceService.class);
        //c.add(MedicalRecordService.class);
        //c.add(AuthenticationService.class);
        c.add(UserEndpoint.class);
        c.add(EchoEndpoint.class);
        //c.add(ImageService.class);
        //c.add(CORSFilter.class);
        c.add(JWTTokenNeededFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
