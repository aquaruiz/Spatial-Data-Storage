package com.spatial.storage.controller;

import com.spatial.storage.dto.view.SpatialUnitViewModel;
import com.spatial.storage.model.SpatialUnit;
import com.spatial.storage.service.SpatialUnitService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
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
//        File currentFile = new File("/");
//        file.transferTo(currentFile);
//        Map map = new HashMap();
//        map.put( "url", currentFile.toURI());
//        DataStore dataStore = DataStoreFinder.getDataStore(map);
        return view("upload");
    }
}
