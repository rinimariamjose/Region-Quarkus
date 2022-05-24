package com.strebentechnik.quarkus.regions;

import java.util.List;

import com.strebentechnik.quarkus.util.QuarkusMappingConfig;

import org.mapstruct.Mapper;
@Mapper(config = QuarkusMappingConfig.class)
public interface RegionTransformer {
    Region toResource(RegionEntity regionEntity);
    List<Region> map(List<RegionEntity> regionEntityList);
    RegionEntity toEntity(Region region);
    
}
