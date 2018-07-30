package com.agrica.p2p.hdf.hdfservice.repository;

import com.agrica.p2p.hdf.hdfservice.model.ReferentielFlux;
import com.agrica.p2p.hdf.hdfservice.model.SensEnum;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;

public interface ReferentielFluxRepository extends PagingAndSortingRepository<ReferentielFlux, String> {


    ReferentielFlux findByCode(String code);
    ReferentielFlux findByLibelle(String libelle);
    ArrayList<ReferentielFlux> findBySens(SensEnum sens);
    ArrayList<ReferentielFlux> findAll();

}
