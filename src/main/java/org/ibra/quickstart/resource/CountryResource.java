package org.ibra.quickstart.resource;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.ibra.quickstart.model.Country;
import org.ibra.quickstart.service.CountryService;

@Path("country")
public class CountryResource {

    @Inject
    @RestClient
    CountryService countryService;
    
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Country> getByName(@PathParam("name") String name) {
        
        return countryService.getByName(name);
    }
}
