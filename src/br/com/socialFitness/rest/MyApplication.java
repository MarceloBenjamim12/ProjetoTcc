package br.com.socialFitness.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.multipart.MultiPartFeature;


@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
    	packages("br.com.socialFitness.rest").register(MultiPartFeature.class);
    }
}
