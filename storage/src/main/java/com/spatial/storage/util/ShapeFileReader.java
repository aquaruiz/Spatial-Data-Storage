package com.spatial.storage.util;

import com.vividsolutions.jts.geom.Geometry;
import org.apache.commons.io.FileUtils;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ShapeFileReader {
    public static void readShapeFile (MultipartFile multipart) throws IOException {

        File shapefile = new File("java.io.tmpdir", multipart.getName());

        // Create the file using the touch method of the FileUtils class.
        FileUtils.touch(shapefile);

        // Write bytes from the multipart file to disk.
        FileUtils.writeByteArrayToFile(shapefile, multipart.getBytes());

        HashMap<String, URL> connect = new HashMap<String, URL>();
        ArrayList<Geometry> result = new ArrayList<Geometry>();

        connect.put("url", shapefile.toURI().toURL());
        DataStore dataStore = DataStoreFinder.getDataStore(connect);
        String[] typeNames = dataStore.getTypeNames();
        String typeName = typeNames[0];

        System.out.println("Reading content " + typeName);

//        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+multipart.getName());
//        multipart.transferTo(convFile);
//
//         TODO check if zip file
//        URL shape = convFile.toURL();
////        URL shape = new URL("jar:"+convFile+"!/ABW_roads.shp");
//        Map<String, URL> params = new HashMap<>();
//        params.put("url", shape);
//        DataStore ds = DataStoreFinder.getDataStore(params);
//        String name = ds.getTypeNames()[0];
//        SimpleFeatureSource source = ds.getFeatureSource(name);
//        System.out.println(name+" has "+source.getCount(Query.ALL)+" features");

    }
}
