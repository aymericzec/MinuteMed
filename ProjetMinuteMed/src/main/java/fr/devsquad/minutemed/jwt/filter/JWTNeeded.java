package fr.devsquad.minutemed.jwt.filter;

import fr.devsquad.minutemed.staff.domain.StaffEnum;
import javax.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface JWTNeeded {  
    StaffEnum[] groups();
}