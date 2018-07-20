package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.events.EventFlux;
import com.agrica.p2p.hdf.hdfservice.model.ReferentielFlux;
import com.agrica.p2p.hdf.hdfservice.model.ReferentielFluxRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReferentielFluxControler {

    private final ReferentielFluxRepository repository;


    public ReferentielFluxControler(ReferentielFluxRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/events/{fluxCode}")
    @ResponseBody
    public ReferentielFlux getReferentielFlux(@PathVariable String fluxCode) {
        return this.repository.findByCode(fluxCode);
    }


}
