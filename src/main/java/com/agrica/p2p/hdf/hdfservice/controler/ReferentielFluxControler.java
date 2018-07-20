package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.model.Flux;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.agrica.p2p.hdf.hdfservice.model.ReferentielFlux;
import com.agrica.p2p.hdf.hdfservice.model.ReferentielFluxRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ReferentielFluxControler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ReferentielFluxRepository repository;


    public ReferentielFluxControler(ReferentielFluxRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ref/{fluxCode}")
    @ResponseBody
    @JsonView(ReferentielFlux.Light.class)
    public ReferentielFlux getReferentielFlux(@PathVariable String fluxCode) {
        ReferentielFlux result = this.repository.findByCode(fluxCode);
        log.info("getReferentielFlux for code {} => {}", fluxCode, result);
        return result;
    }

    @GetMapping("/flux")
    @ResponseBody
    public Flux getSampleFlux() {
        Flux result = new Flux();
        result.setDateDebutDelai(new Date());
        result.setCommentaire("Coucou");
        return result;
    }

}
