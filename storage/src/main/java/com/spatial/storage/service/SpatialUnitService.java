package com.spatial.storage.service;

import com.spatial.storage.model.SpatialUnit;

public interface SpatialUnitService {
    boolean saveUnit(SpatialUnit spatialUnit, String username);

    SpatialUnit getByUnitId(String id);
}
