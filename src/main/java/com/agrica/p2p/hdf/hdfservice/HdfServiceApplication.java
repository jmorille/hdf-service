package com.agrica.p2p.hdf.hdfservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySources;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableConfigurationProperties(MarklogicProperties.class)
@EnableEncryptableProperties
@EncryptablePropertySources({@EncryptablePropertySource("classpath:config.yml") })
public class HdfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdfServiceApplication.class, args);
	}
}
