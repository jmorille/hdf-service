package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.repository.MarklogicRepository;
import com.marklogic.client.document.DocumentRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MarkLogicController {

    private final MarklogicRepository repository;

    public MarkLogicController(MarklogicRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ml/ident/{localIdent}")
    @ResponseBody
    public List<DocumentRecord> getMLDataFromLocalIdent(@PathVariable String localIdent) {
        return repository.queryML("X_LOCAL_IDENT", localIdent);
    }
}
