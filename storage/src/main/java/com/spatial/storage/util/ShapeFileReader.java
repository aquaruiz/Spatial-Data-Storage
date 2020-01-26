package com.spatial.storage.util;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShapeFileReader {
    public static void readShapeFile (MultipartFile multipart) throws IOException {

//        File file = JFileDataStoreChooser.showOpenFile("shp", null);
        File file = new File("java.io.tmpdir", "ABW_roads.shp");


        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);

        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();

        DataStore store = DataStoreFinder.getDataStore(map);
        SimpleFeatureSource featureSource = store.getFeatureSource(store.getTypeNames()[0]);

        System.out.println( "Hello World!" );


    }
}
