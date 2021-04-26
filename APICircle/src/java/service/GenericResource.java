/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.StringWriter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXB;


/**
 * REST Web Service
 *
 * @author Rungroj
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of service.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/Area/{raduis}")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml_AreaCircle(@PathParam("raduis")double raduis ) {
        StringWriter writer = new StringWriter();
        double pie = 3.14159;
        double result = pie * (raduis*raduis);
        JAXB.marshal(result, writer);
        return writer.toString();
    }
    
    @GET
    @Path("/Circumference/{raduis}")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml_Circumference_Circle(@PathParam("raduis")double raduis) {
        StringWriter writer = new StringWriter();
        double pie = 3.14159;
        double result = 2*pie*raduis;
        JAXB.marshal(result, writer);
        return writer.toString();
    }
    
    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
