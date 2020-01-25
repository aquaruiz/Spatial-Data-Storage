package com.spatial.storage.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Table(name = "users")
@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
    private Set<SpatialUnit> spatialUnits;

    public User() {
        this.spatialUnits = new HashSet<>();
    }

    @Column( name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany
    public Set<SpatialUnit> getSpatialUnits() {
        return Collections.unmodifiableSet(spatialUnits);
    }

    private void setSpatialUnits(Set<SpatialUnit> spatialUnits) {
        this.spatialUnits = spatialUnits;
    }

    public void addSpatialUnit(SpatialUnit spatialUnit) {
        this.spatialUnits.add(spatialUnit);
    }
}
