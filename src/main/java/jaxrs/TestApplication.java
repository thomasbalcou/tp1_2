package jaxrs;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jaxrs.rest.*;

public class TestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();
        
        clazzes.add(OpenApiResource.class);
        
        clazzes.add(ProfessionnelRessource.class);
        clazzes.add(RDVRessource.class);
        clazzes.add(UtilisateurRessource.class);
        
        clazzes.add(SwaggerResource.class);


        return clazzes;
    }

}
