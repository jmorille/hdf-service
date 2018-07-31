package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.model.Flux;
import com.agrica.p2p.hdf.hdfservice.model.ReferentielFlux;
import com.agrica.p2p.hdf.hdfservice.repository.FluxRepository;
import com.agrica.p2p.hdf.hdfservice.repository.ReferentielFluxRepository;
import org.joda.time.DateTimeComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class FluxController {

    private final ReferentielFluxRepository referentielFluxRepository;

    private final FluxRepository repository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public FluxController(ReferentielFluxRepository referentielFluxRepository, FluxRepository repository) {
        this.repository = repository;
        this.referentielFluxRepository = referentielFluxRepository;
    }

    @GetMapping("/flux")
    @ResponseBody
    public Iterable<Flux> getAllFlux() {
        return this.repository.findAll();
    }

    @PostMapping("/flux/{refCode}")
    @ResponseBody
    public ResponseEntity<String> postFlux(@RequestBody Flux flux, @PathVariable String refCode) {
        ReferentielFlux referentielFlux = referentielFluxRepository.findByCode(refCode);
        flux.setReferentiel(referentielFlux);
        log.info(refCode + " " + referentielFlux.toString());
        Flux created = this.repository.save(flux);
        log.info(created.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/flux/{refCode}/{date}")
    @ResponseBody
    public Flux getSpecificFlux(@PathVariable String refCode, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        ArrayList<Flux> fluxes = repository.findByReferentielCode(refCode);
        for(Flux flux : fluxes) {
            if(DateTimeComparator.getDateOnlyInstance().compare(date,flux.getDateReception()) == 0)
                return flux;

        }
        return null;
    }

    @GetMapping("/flux/{refCode}/range/{startDate}/{endDate}")
    @ResponseBody
    public Flux getSpecificFluxByRange(@PathVariable String refCode, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
        ArrayList<Flux> fluxes = repository.findByReferentielCode(refCode);
        for(Flux flux : fluxes) {
            log.info("Flux : " + flux.toString());
            if(flux.getDateReception().after(startDate) && flux.getDateReception().before(endDate))
                return flux;

        }
        return null;
    }

}
