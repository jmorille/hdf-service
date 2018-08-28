package com.agrica.p2p.hdf.hdfservice.controler;

import com.agrica.p2p.hdf.hdfservice.model.MLAuthenticator;
import com.agrica.p2p.hdf.hdfservice.repository.MarklogicRepository;
import com.google.common.io.ByteStreams;
import com.marklogic.client.document.DocumentRecord;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.net.Authenticator;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

    @GetMapping(value = "/ml/codeext/{code}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public byte[] getMLDataFromCode(@PathVariable String code) throws IOException {
        List<DocumentRecord> list = repository.queryML("CODE_EXTERNE", code);


        //does not work
//        HttpGet request = new HttpGet("http://qualif-marklogic-web:8090/v1/documents?uri=/binary/" + list.get(0).getUri().split("/")[2]);
//        String auth = "hor_user" + ":" + "hor_user";
//        byte[] encodedAuth = Base64.encodeBase64(
//                auth.getBytes(StandardCharsets.ISO_8859_1));
//        String authHeader = "Basic " + new String(encodedAuth);
//        request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
//
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpResponse response = client.execute(request);
//        return response.toString();

        //doesn't work to attack the URL directly, need authentication
//        InputStream in = new URL("http://qualif-marklogic-web:8090/v1/documents?uri=/binary/" + list.get(0).getUri().split("/")[2]).openStream();



//        return ByteStreams.toByteArray(in);

        return repository.getBinary("/binary/" + list.get(0).getUri().split("/")[2]);
    }
}