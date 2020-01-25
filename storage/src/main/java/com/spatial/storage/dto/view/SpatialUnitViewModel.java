package com.spatial.storage.dto.view;

import org.springframework.web.multipart.MultipartFile;

public class SpatialUnitViewModel {
    private MultipartFile uploadfile;

    public SpatialUnitViewModel() {
    }

    public MultipartFile getUploadfile() {
        return uploadfile;
    }

    public void setUploadfile(MultipartFile uploadfile) {
        this.uploadfile = uploadfile;
    }
}
