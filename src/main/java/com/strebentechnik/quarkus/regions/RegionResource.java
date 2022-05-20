package com.strebentechnik.quarkus.regions;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
@Path("/regions")
public class RegionResource {
    
   // Create 
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   @Produces(MediaType.APPLICATION_JSON)
   @Transactional
   public Response createRegion(RegionEntity regionEntity) {
       regionEntity.persist();
       return Response.status(Status.CREATED).build();
   }
   

   // Get all 
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Response listAllRegion() {
       return Response.ok(RegionEntity.listAll()).build();
   }

    @Path("/{id}")
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public Response getRegionById(@PathParam("id") Long id) {
        RegionEntity regionEntity = RegionEntity.findById(id);
         return Response.ok(regionEntity).build();
     }
 
     // Delete regionby ID
     @Path("/{id}")
     @DELETE
     @Produces(MediaType.APPLICATION_JSON)
     @Transactional
     public Response deleteRegion(@PathParam("id") Long id) {
        RegionEntity.deleteById(id);
         return Response.noContent().build();
     }
}
