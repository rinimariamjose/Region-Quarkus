package com.strebentechnik.quarkus.regions;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RegionResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllRegion() {
        return Response.ok(RegionEntity.listAll()).build();
    }
    
}
