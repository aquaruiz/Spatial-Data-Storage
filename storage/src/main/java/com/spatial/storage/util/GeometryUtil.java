package com.spatial.storage.util;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.opengis.feature.Feature;
import org.opengis.feature.GeometryAttribute;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class GeometryUtil {

//    public static ArrayList<Geometry> makeGeomerty(SimpleFeatureSource featureSource) throws IOException, FactoryException {
//        ArrayList<Geometry> result = new ArrayList<Geometry>();
//
//        FeatureCollection<?, ?> collection = featureSource.getFeatures();
//
//        SimpleFeatureType schema = (SimpleFeatureType) featureSource.getSchema();
//        CoordinateReferenceSystem dataCRS = schema.getCoordinateReferenceSystem();
//        CoordinateReferenceSystem worldCRS = CRS.decode("EPSG:4326");
//        MathTransform transform = CRS.findMathTransform(dataCRS, worldCRS);
//        FeatureIterator<?> iterator = collection.features();
//
//        while (iterator.hasNext()) {
//            Feature feature = iterator.next();
//            System.out.println(feature.getName().toString());
//            GeometryAttribute geometryAttr = feature.getDefaultGeometryProperty();
//            Geometry geometry = (Geometry) geometryAttr.getValue();
//            if (geometry != null) {
//                Geometry resultGeometry = JTS.transform(geometry, transform);
//                result.add(resultGeometry);
//            }
//        }
//
//        iterator.close();
//
//        return result;
//    }

//    public static Geometry readWKTString(String wkt, GeometryFactory geomFact) throws ParseException, IOException, org.locationtech.jts.io.ParseException {
//        WKTReader reader = new WKTReader(geomFact);
//        WKTFileReader fileReader = new WKTFileReader(new StringReader(wkt), reader);
//        List geomList = fileReader.read();
//
//        if (geomList.size() == 1) {
//            return (Geometry) geomList.get(0);
//        }
//        return (Geometry) geomFact.createGeometryCollection(GeometryFactory.toGeometryArray(geomList));
//    }
}
