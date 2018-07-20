package com.agrica.p2p.hdf.hdfservice.model;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReferentielFluxRepository  extends PagingAndSortingRepository< ReferentielFlux, String> {


    ReferentielFlux findByCode(String code);

}
