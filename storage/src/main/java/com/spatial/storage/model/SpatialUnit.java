package com.spatial.storage.model;

import org.springframework.data.geo.Point;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table( name = "spatial_units")
@Entity
public class SpatialUnit extends BaseEntity {
    private Point point;

    public SpatialUnit() {
        point = new Point();
    }
}
