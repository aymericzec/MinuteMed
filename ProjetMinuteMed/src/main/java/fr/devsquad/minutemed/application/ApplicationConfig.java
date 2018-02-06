package fr.devsquad.minutemed.application;

import fr.devsquad.minutemed.filters.rest.CORSFilter;
import fr.devsquad.minutemed.authentication.rest.AuthenticationService;
import fr.devsquad.minutemed.dmp.rest.MedicalRecordService;
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
        c.add(MedicalRecordService.class);
        c.add(AuthenticationService.class);
        //c.add(ImageService.class);
        c.add(CORSFilter.class);
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}