package com.rest.data.extractor.demo.controller;

import com.rest.data.extractor.demo.model.TriggerRequest;
import com.rest.data.extractor.demo.service.DocumentExtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.lang.String.format;

@RestController
@RequestMapping("/contracts")
public class DocumentExtractionController {

    @Autowired
    private DocumentExtractionService documentExtractionService;

    @PostMapping("/extract/documents")
    public ResponseEntity triggerDataExtraction(@RequestBody TriggerRequest request) {
        documentExtractionService.extractData(request);
        return new ResponseEntity<>(format("{\"message\" : \"%s\"}", "Contracts extraction completed."), getHeaders(), HttpStatus.OK);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
