package com.agrica.p2p.hdf.hdfservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties(MarklogicProperties.class)
@EnableEncryptableProperties
@PropertySource("config.properties")
public class HdfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdfServiceApplication.class, args);
	}
}
