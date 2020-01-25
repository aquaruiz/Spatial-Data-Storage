package com.spatial.storage.service;

import com.spatial.storage.model.SpatialUnit;
import com.spatial.storage.model.User;
import com.spatial.storage.repository.SpatialUnitRepository;
import com.spatial.storage.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpatialServiceImpl implements SpatialUnitService {
    private final SpatialUnitRepository spatialUnitRepository;
    private final UserRepository userRepository;

    public SpatialServiceImpl(SpatialUnitRepository spatialUnitRepository, UserRepository userRepository) {
        this.spatialUnitRepository = spatialUnitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean saveUnit(SpatialUnit spatialUnit, String username) {
        Optional<User> user = this.userRepository.findUserByUsername(username);

        if (user.isEmpty()){
            return false;
        }

        // TODO modelling to DB entity

//        spatialUnit.setUser(user.get());
        return spatialUnitRepository.saveAndFlush(spatialUnit) != null;
    }

    @Override
    public SpatialUnit getByUnitId(String id) {
        Optional<SpatialUnit> unit = this.spatialUnitRepository.findById(id);

        if (unit.isEmpty()) {
            return null;
        }

        return unit.get();
    }
}
