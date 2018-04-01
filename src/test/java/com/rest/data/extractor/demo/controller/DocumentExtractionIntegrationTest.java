package com.rest.data.extractor.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rest.data.extractor.demo.repository.DocumentRepository;
import com.rest.data.extractor.demo.service.DocumentExtractionService;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.rest.data.extractor.demo.factory.EntityFactory.getTriggerRequest;
import static com.rest.data.extractor.demo.utils.Utils.assertDataSaved;
import static com.rest.data.extractor.demo.utils.Utils.constructMock;
import static io.restassured.RestAssured.given;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = BEFORE_CLASS)
public class DocumentExtractionIntegrationTest {

    @LocalServerPort
    private int port;

    @Before
    public void init() {
        RestAssured.port = port;
    }

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    @InjectMocks
    private DocumentExtractionService documentExtractionService;

    @MockBean
    private RestTemplate restTemplate;


    @Test
    public void dataExtractionIntegrationTest() throws JsonProcessingException {
        constructMock(restTemplate);

        given()
                .contentType("application/json")
                .body(getTriggerRequest())
                .post("contracts/extract/documents")
                .then().log().all()
                .statusCode(200);
        assertDataSaved(documentRepository);
    }


}
