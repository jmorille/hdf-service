package com.agrica.p2p.hdf.hdfservice.events;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EventFluxControler {

    private final EventFluxRepository repository;

    public EventFluxControler(EventFluxRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/events/{fluxName}")
    @ResponseBody
    public EventFlux[] getEventFlux(@PathVariable String fluxName) {
       // this.repository.findAll();
        return null;
    }
}
