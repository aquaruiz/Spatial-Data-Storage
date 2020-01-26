package com.spatial.storage.util;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.FeatureSource;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtil {

    public static void readShapeFile (File file) throws IOException {
//        File file = JFileDataStoreChooser.showOpenFile("shp", null);
//        File file = new File("java.io.tmpdir", "ABW_roads.shp");

        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());

        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];

        FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();

        SimpleFeatureSource featureSource = dataStore.getFeatureSource(typeName);
    }

    public static File transformToFile(MultipartFile multipartFile) throws IOException {
        File file = File.createTempFile("temp-file",
                multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }

    public static File unzip(File zipFile) throws IOException {
        File unzipPath = new File("java.io.tmpdir" + File.separator + zipFile.getName().split("\\.")[0]);
        unzipPath.mkdir();
        FileInputStream fis = null;
        ZipInputStream zipIs = null;
        ZipEntry zEntry = null;
        try {
            fis = new FileInputStream(zipFile);
            zipIs = new ZipInputStream(new BufferedInputStream(fis));
            while((zEntry = zipIs.getNextEntry()) != null){
                try{
                    byte[] tmp = new byte[4*1024];
                    FileOutputStream fos = null;
                    String opFilePath = unzipPath + File.separator +zEntry.getName();
                    System.out.println("Extracting file to "+opFilePath);
                    fos = new FileOutputStream(opFilePath);
                    int size = 0;
                    while((size = zipIs.read(tmp)) != -1){
                        fos.write(tmp, 0 , size);
                    }
                    fos.flush();
                    fos.close();
                } catch(Exception ex){

                }
            }
            zipIs.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return unzipPath;
    }

    public static File findShapeFile(File unzipPath) throws IOException {
        File shapefile = new File("");
        // Find first .shp file in the unzip folder
        File[] unzippedFiles = unzipPath.listFiles();
        for (int i = 0; i < unzippedFiles.length; i++)
        {
            if (unzippedFiles[i].getName().endsWith(".shp"))
            {
                shapefile = new File(unzipPath + File.separator
                        + unzippedFiles[i].getName());
                break;
            }
        }
        if (shapefile.toString() == "")
        {
            throw new IOException("No shapefile present in '" + unzipPath
                    + "'.");
        }
        return shapefile;
    }
}
