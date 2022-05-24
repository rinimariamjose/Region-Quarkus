package com.strebentechnik.quarkus.regions;

import java.sql.Timestamp;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
@RegisterForReflection
@Data
public class Region {
    private Long id;
    private Long  organizationId;
    private Long  territoryId;
    private String code;
    private String name;
    private String shortName;
    private String notes;
    private String createdBy;
    private String updatedBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
}
