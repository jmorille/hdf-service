package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.model.Flux;
import com.agrica.p2p.hdf.hdfservice.model.ReferentielFlux;
import com.agrica.p2p.hdf.hdfservice.repository.FluxRepository;
import com.agrica.p2p.hdf.hdfservice.repository.ReferentielFluxRepository;
import com.agrica.p2p.hdf.hdfservice.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.joda.time.DateTimeComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class FluxController {

    private final ReferentielFluxRepository referentielFluxRepository;

    private final FluxRepository repository;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
        Flux created = this.repository.save(flux);
        log.info(created.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/flux/{refCode}/{date}")
    @ResponseBody
    public Optional<Flux> getSpecificFlux(@PathVariable String refCode, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        ArrayList<Flux> fluxes = repository.findByReferentielCode(refCode);
        return fluxes
                .stream()
                .filter(flux -> DateTimeComparator.getDateOnlyInstance().compare(date,flux.getDateReception()) == 0)
                .findFirst();
    }


    /*in case there are more than one flux matching date and ref code*/
    @GetMapping("/fluxes/{refCode}/{date}")
    @ResponseBody
    public List<Flux> getSpecificFluxes(@PathVariable String refCode, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date date) {
        ArrayList<Flux> fluxes = repository.findByReferentielCode(refCode);

        return fluxes
            .stream()
            .filter(flux -> DateTimeComparator.getDateOnlyInstance().compare(date,flux.getDateReception()) == 0)
            .collect(Collectors.toList());
    }

    @GetMapping("/flux/range/{startDate}/{endDate}")
    @ResponseBody
    @JsonView(Views.Light.class)
    public List<Flux> getSpecificFluxByRange(@PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
        Iterable<Flux> fluxes = repository.findAll();

        return StreamSupport
                .stream(fluxes.spliterator(), false)
                .filter(flux -> flux.getDateReception().after(startDate) && flux.getDateReception().before(endDate))
                .collect(Collectors.toList());
    }

    @GetMapping("/flux/code/{refCode}/range/{startDate}/{endDate}")
    @ResponseBody
    @JsonView(Views.Light.class)
    public List<Flux> getSpecificFluxByRangeAndCode(@PathVariable String refCode, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date startDate, @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date endDate) {
        Iterable<Flux> fluxes = repository.findByReferentielCode(refCode);
        return StreamSupport
                .stream(fluxes.spliterator(), false)
                .filter(flux -> flux.getDateReception().after(startDate) && flux.getDateReception().before(endDate))
                .collect(Collectors.toList());
    }

}
