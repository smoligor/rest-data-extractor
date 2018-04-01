package com.rest.data.extractor.demo.service.impl;

import com.rest.data.extractor.demo.model.Document;
import com.rest.data.extractor.demo.model.TriggerRequest;
import com.rest.data.extractor.demo.repository.DocumentRepository;
import com.rest.data.extractor.demo.service.DocumentExtractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Service
@Slf4j
public class DocumentExtractionServiceImpl implements DocumentExtractionService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DocumentRepository documentRepository;

    @Value("${rest.base.url}")
    private String baseUrl;

    @Override
    public void extractData(TriggerRequest request) {
        List<Document> documents = new ArrayList<>();
        request.getContractIds().forEach(id ->
                documents.add(restTemplate.getForObject(format("%s/%s/documents", baseUrl, id), Document.class)));
        documentRepository.save(documents);
        log.info("Contracts saved to db.");
    }

}
