package com.spatial.storage;

import com.vividsolutions.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StorageApplication {

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(StorageApplication.class, args);

	}

}
