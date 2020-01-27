package com.spatial.storage.controller;

import com.spatial.storage.dto.view.SpatialUnitViewModel;
import com.spatial.storage.service.SpatialUnitService;
import com.spatial.storage.util.FileUtil;
import com.spatial.storage.util.GeometryUtil;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.geometry.Geometry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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


    @PostMapping(value = "/upload")
    public ModelAndView save(@ModelAttribute(name = "uploadfile") SpatialUnitViewModel spatialUnitViewModel
//            , Principal principal
    ) throws IOException {
        return view("upload");
    }
}
