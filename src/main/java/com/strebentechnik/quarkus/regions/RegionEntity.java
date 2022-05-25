package com.strebentechnik.quarkus.regions;

import java.sql.Timestamp;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity(name = "region")
public class RegionEntity extends PanacheEntity{
    
    public Long id;
    public Long  organizationId;
    public Long  territoryId;
    public String code;
    public String name;
    public String shortName;
    public String notes;
    public String createdBy;
    public String updatedBy;
    public Timestamp createdAt;
    public Timestamp updatedAt;
    
}
