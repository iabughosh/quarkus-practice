package org.ibra.quickstart.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.ibra.quickstart.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/task")
public class TaskResource {

    private final Logger LOG = LoggerFactory.getLogger(TaskResource.class);
    
	@Inject
	TaskService taskService;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public Response create() {
		
		taskService.createTask();
		return Response.ok().build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		
	    ObjectMapper mapper = new ObjectMapper();
	    String jsonResult;
        try {
            jsonResult = mapper.writeValueAsString(taskService.fetchAll());
            LOG.info(jsonResult);
        } catch (JsonProcessingException e) {
            
            LOG.error("JSON-P Exception", e);
            return Response.status(Status.SERVICE_UNAVAILABLE).build();
        }
	    
		return Response.ok(jsonResult, MediaType.APPLICATION_JSON).build();
	}
}
