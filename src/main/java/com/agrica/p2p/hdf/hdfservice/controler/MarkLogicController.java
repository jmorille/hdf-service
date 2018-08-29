package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.repository.MarklogicRepository;
import com.marklogic.client.document.DocumentRecord;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class MarkLogicController {

    private final MarklogicRepository repository;

    public MarkLogicController(MarklogicRepository repository) {
        this.repository = repository;
    }

//    @GetMapping("/ml/ident/{localIdent}")
//    @ResponseBody
//    public List<DocumentRecord> getMLDataFromLocalIdent(@PathVariable String localIdent) {
//        return repository.queryML("X_LOCAL_IDENT", localIdent);
//    }

    @GetMapping(value = "/ml/codeext/{code}/{date}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] getMLDataFromCode(@PathVariable String code, @PathVariable String date) throws IOException {
        String formattedDate = date.substring(6,8) + "/" + date.substring(4,6) + "/" + date.substring(0,4);

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("CODE_EXTERNE", code);
        parameters.put("DATE_DE_MISE_EN_PRODUCTION", formattedDate);

        List<DocumentRecord> list = repository.queryML(parameters);

        return repository.getBinary("/binary/" + list.get(0).getUri().split("/")[2]);
    }
}
