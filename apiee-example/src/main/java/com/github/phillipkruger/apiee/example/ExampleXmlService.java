package com.github.phillipkruger.apiee.example;

import io.swagger.v3.oas.annotations.Operation;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.extern.java.Log;

@Path("/example/xml")
@Produces({MediaType.APPLICATION_XML}) 
@Consumes({MediaType.APPLICATION_XML})
@Log
public class ExampleXmlService {
    
    @Context
    private UriInfo uriInfo;  
    
    @Context
    private HttpServletRequest request;
    
    @POST
    @Operation(description = "Post some example content", summary = "This will post some object to the server")
    public Response postExample(SomeObject someObject) {
        log.log(Level.INFO, "POST: {0}", someObject);
        return Response.created(uriInfo.getRequestUri()).build();
    }
    
    @GET
    @Operation(description = "Retrieve some example content", summary = "This will return some object to the client")
    public Response getExample(){
        SomeObject object = new SomeObject("apiee example","https://github.com/phillip-kruger/apiee-example");
        log.log(Level.INFO, "GET: {0}", object);
        return Response.ok(object).build();
    }
    
}