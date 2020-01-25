package com.spatial.storage.controller;

import com.spatial.storage.model.SpatialUnit;
import com.spatial.storage.service.SpatialUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

@Controller
@RequestMapping("/storage")
public class UnitController extends BaseController {
    private final SpatialUnitService spatialService;

    public UnitController(SpatialUnitService spatialService) {
        this.spatialService = spatialService;
    }

    @GetMapping(value = "/upload")
    public ModelAndView save() {

        return view("upload");
    }

}
