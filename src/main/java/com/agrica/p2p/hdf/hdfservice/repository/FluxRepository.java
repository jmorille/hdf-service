package com.agrica.p2p.hdf.hdfservice.repository;

import com.agrica.p2p.hdf.hdfservice.model.Flux;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.ArrayList;
import java.util.Date;

public interface FluxRepository extends PagingAndSortingRepository<Flux, String> {

    @Query("select flux from Flux flux, ReferentielFlux rf where flux.dateReception = :dateReception and flux.referentiel.code = :code")
    Flux findByDateReceptionAndReferentielCode(Date dateReception, String code);
    ArrayList<Flux> findByReferentielCode(String code);
}
