package com.rest.data.extractor.demo.utils;

import com.rest.data.extractor.demo.model.Document;
import com.rest.data.extractor.demo.repository.DocumentRepository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static com.rest.data.extractor.demo.factory.EntityFactory.getDocument;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class Utils {

    public static void constructMock(RestTemplate restTemplate) {
        String id = "sdfsdfsdgxcv";
        String url = "https://lb.api-sandbox.openprocurement.org/api/2.4/contracts/" + id + "/documents";
        when(restTemplate.getForObject(url, Document.class)).thenReturn(getDocument());
    }

    public static void assertDataSaved(DocumentRepository documentRepository) {

        List<Document> documents = (List<Document>) documentRepository.findAll();
        String dataId = documents.get(0).getData().get(0).getId();
        assertEquals("111aaa222", dataId);
    }
}
