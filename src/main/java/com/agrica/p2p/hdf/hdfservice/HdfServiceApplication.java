package com.agrica.p2p.hdf.hdfservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MarklogicProperties.class)
public class HdfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdfServiceApplication.class, args);
	}
}
