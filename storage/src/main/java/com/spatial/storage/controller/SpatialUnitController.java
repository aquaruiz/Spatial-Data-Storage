package com.spatial.storage.controller;

import com.spatial.storage.model.SpatialUnit;
import com.spatial.storage.service.SpatialUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

@RestController
@RequestMapping(value = "/api/storage", produces = "application/json")
public class SpatialUnitController {
    private final SpatialUnitService spatialService;

    public SpatialUnitController(SpatialUnitService spatialService) {
        this.spatialService = spatialService;
    }

    @PostMapping(value = "/upload", consumes = "application/json")
    public ResponseEntity save(@RequestBody SpatialUnit unit, Principal principal) throws URISyntaxException {
        boolean result = spatialService.saveUnit(unit, principal.getName());

        return ResponseEntity.created(new URI("/storage/upload")).body(result);
    }

    @GetMapping(value = "/details/{id}")
    public ResponseEntity unitDetails(@PathVariable String id) throws URISyntaxException {
        SpatialUnit unit = this.spatialService.getByUnitId(id);
//        UnitDetailsModel unit = this.modelMapper.map(unit, UnitDetailsModel.class);
        return ResponseEntity.created(new URI("/heroes/details/" + id)).body(unit);
    }
}
