package com.spatial.storage.controller;

import com.spatial.storage.dto.view.SpatialUnitViewModel;
import com.spatial.storage.model.SpatialUnit;
import com.spatial.storage.service.SpatialUnitService;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.DataUtilities;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.operation.valid.IsValidOp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

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
    public ModelAndView save(@ModelAttribute(name = "fileupload") SpatialUnitViewModel spatialUnitViewModel
//            , Principal principal
    ) throws IOException {

        MultipartFile file = spatialUnitViewModel.getUploadfile();

        URL zip = DataUtilities.fileToURL(new File("../../data/coast.zip"));
        URL shape = new URL("jar:"+zip+"!/110m_coastline.shp");
        Map<String, URL> params = new HashMap<>();
        params.put("url", shape);
        DataStore ds = DataStoreFinder.getDataStore(params );
        String name = ds.getTypeNames()[0];
        SimpleFeatureSource source = ds.getFeatureSource(name);
        System.out.println(name+" has "+source.getCount(Query.ALL)+" features");

        return view("upload");
    }
}
