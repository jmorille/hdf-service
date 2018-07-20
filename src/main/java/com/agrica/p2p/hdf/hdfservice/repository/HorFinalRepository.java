package com.agrica.p2p.hdf.hdfservice.repository;

import com.agrica.p2p.hdf.hdfservice.MarklogicProperties;
import org.springframework.stereotype.Repository;

@Repository
public class HorFinalRepository {

    private final MarklogicProperties mlConfig;

    public HorFinalRepository(MarklogicProperties mlConfig) {
        this.mlConfig = mlConfig;
    }


}
