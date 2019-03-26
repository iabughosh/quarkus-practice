package org.ibra.quickstart.service;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.ibra.quickstart.model.Country;

@Path("/v2")
@RegisterRestClient
public interface CountryService {

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    Set<Country> getByName(@PathParam("name") String name);
}
