package org.ibra.quickstart.resource;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.ibra.quickstart.service.GreetingService;

@Path("/hello")
public class GreetingResource {

	@Inject
	GreetingService greetingService;
	
	@Inject 
	@ConfigProperty(name = "greeting.message")
	String message;
	
	@Inject 
	@ConfigProperty(name = "greeting.suffix", defaultValue = "!!!")
	String sufix;
	
	@Inject 
	@ConfigProperty(name = "greeting.name")
	String name;
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
	@Path("/greet/{name}")
    public String greeting(@PathParam("name") String name) {
        return greetingService.greet(name);
    }
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> hello() {
        return CompletableFuture.supplyAsync(() -> {
        	 return message.concat(" ").concat(name).concat(sufix);
        }) ;
    }
}
