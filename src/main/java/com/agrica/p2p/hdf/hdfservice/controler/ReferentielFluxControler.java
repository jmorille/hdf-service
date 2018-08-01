package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.model.ReferentielFlux;
import com.agrica.p2p.hdf.hdfservice.model.SensEnum;
import com.agrica.p2p.hdf.hdfservice.repository.ReferentielFluxRepository;
import com.agrica.p2p.hdf.hdfservice.views.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class ReferentielFluxControler {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final ReferentielFluxRepository repository;


    public ReferentielFluxControler(ReferentielFluxRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ref/code/{fluxCode}")
    @ResponseBody
    @JsonView(Views.Light.class)
    public ReferentielFlux getReferentielFlux(@PathVariable String fluxCode) {
        ReferentielFlux result = this.repository.findByCode(fluxCode);
        log.info("getReferentielFlux for code {} => {}", fluxCode, result);
        return result;
    }

    @GetMapping("/ref/sens/{fluxSens}")
    @ResponseBody
    @JsonView(Views.Full.class)
    public ArrayList<ReferentielFlux> getReferentielFluxBySens(@PathVariable String fluxSens) {
        ArrayList<ReferentielFlux> results = this.repository.findBySens(SensEnum.valueOf(fluxSens));
        log.info("getReferentielFlux for code {} => {}", fluxSens, results);
        return results;
    }

    @GetMapping("/ref/senscode/{fluxCode}")
    @ResponseBody
    @JsonView(Views.Full.class)
    public String getSensFlux(@PathVariable String fluxCode) {
        ReferentielFlux ref = this.repository.findByCode(fluxCode);
        return ref.getSens().getCode().equals("OUT") ? "Going out" : "Coming in";
    }

//    @GetMapping("/flux")
//    @ResponseBody
//    public Flux getSampleFlux() {
//        Flux result = new Flux();
//        result.setDateDebutDelai(new Date());
//        result.setCommentaire("Coucou");
//        return result;
//    }

    @PostMapping("/ref")
    @ResponseBody
    public ResponseEntity<Object> postReferentielFlux(@Valid @RequestBody ReferentielFlux referentielFlux) {
        ReferentielFlux created = this.repository.save(referentielFlux);
        log.info(created.toString());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/ref")
    @ResponseBody
    @JsonView(Views.Full.class)
    public Iterable<ReferentielFlux> getAllReferentielFlux() {
        return this.repository.findAll();
    }

}
