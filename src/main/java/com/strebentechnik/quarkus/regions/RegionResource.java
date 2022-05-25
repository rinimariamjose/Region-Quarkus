package com.strebentechnik.quarkus.regions;

import java.util.Objects;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
@Path("/regions")
@Tag(name="region")
public class RegionResource {
    @Inject
    RegionTransformer regionTransformer;
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
     @Path("/{id}")
     @PUT
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     @Transactional
     public Response updateRegion(@PathParam("id") Long id, Region region) {
        RegionEntity regionEntity = RegionEntity.findById(id);
 
         if (Objects.nonNull(region.getOrganizationId())) {
            regionEntity.organizationId= region.getOrganizationId();
         }
         if (Objects.nonNull(region.getTerritoryId())) {
            regionEntity.territoryId = region.getTerritoryId();
         }
         if (Objects.nonNull(region.getCode())) {
            regionEntity.code = region.getCode();
         }
         if (Objects.nonNull(region.getName())) {
            regionEntity.name = region.getName();
         }
         if (Objects.nonNull(region.getShortName())) {
            regionEntity.shortName = region.getShortName();
         }
         if (Objects.nonNull(region.getNotes())) {
            regionEntity.notes =region.getNotes();
         }
         if (Objects.nonNull(region.getCreatedBy())) {
            regionEntity.createdBy = region.getCreatedBy();
         }
         if (Objects.nonNull(region.getUpdatedBy())) {
            regionEntity.updatedBy = region.getUpdatedBy();
         }
         if (Objects.nonNull(region.getCreatedAt())) {
            regionEntity.createdAt = region.getCreatedAt();
         }
         if (Objects.nonNull(region.getUpdatedAt())) {
            regionEntity.updatedAt = region.getUpdatedAt();
         }
         return Response.noContent().build();
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

