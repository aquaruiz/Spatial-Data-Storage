package com.spatial.storage.repository;

import com.spatial.storage.model.SpatialUnit;
import org.locationtech.jts.geom.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpatialUnitRepository extends JpaRepository<SpatialUnit, String> {
    @Query("select s from spatialUnit m where within(m.geom, ?1) = true")
    List<SpatialUnit> findWithin(Geometry filter);
}
