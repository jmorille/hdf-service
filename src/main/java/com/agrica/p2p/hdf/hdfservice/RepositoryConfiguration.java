package com.agrica.p2p.hdf.hdfservice;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import io.github.malteseduck.springframework.data.marklogic.core.MarkLogicOperations;
import io.github.malteseduck.springframework.data.marklogic.core.MarkLogicTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.marklogic.client.DatabaseClientFactory.newClient;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public MarkLogicOperations marklogicTemplate() {
        DatabaseClient client = newClient("host", 8000, new DatabaseClientFactory.DigestAuthContext("yk", "pw"));
        return new MarkLogicTemplate(client);
    }
}
