package com.agrica.p2p.hdf.hdfservice.repository;

import com.agrica.p2p.hdf.hdfservice.MarklogicProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class HorFinalRepository implements InitializingBean  {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final MarklogicProperties mlConfig;

    public HorFinalRepository(MarklogicProperties mlConfig) {
        this.mlConfig = mlConfig;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("---- Config "+  mlConfig);
    }
}
