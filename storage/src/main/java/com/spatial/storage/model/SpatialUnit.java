package com.spatial.storage.model;

import org.hibernate.annotations.Type;
import org.locationtech.jts.geom.Geometry;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table( name = "spatial_units")
@Entity(name = "spatialUnit")
public class SpatialUnit extends BaseEntity {
    private Point point;

    @Column(columnDefinition = "Geometry", nullable = true)
    @Type(type="org.hibernate.spatial.GeometryType")
    private Geometry geom;

    @ManyToOne
    private User user;

    public SpatialUnit() {

    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
