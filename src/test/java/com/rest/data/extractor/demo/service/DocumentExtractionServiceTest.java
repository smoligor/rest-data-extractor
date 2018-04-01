package com.rest.data.extractor.demo.service;

import com.rest.data.extractor.demo.repository.DocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static com.rest.data.extractor.demo.factory.EntityFactory.getTriggerRequest;
import static com.rest.data.extractor.demo.utils.Utils.assertDataSaved;
import static com.rest.data.extractor.demo.utils.Utils.constructMock;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@DirtiesContext(classMode = BEFORE_CLASS)
public class DocumentExtractionServiceTest {


    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    @InjectMocks
    private DocumentExtractionService documentExtractionService;

    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void documentExtractionServiceTest() {
        constructMock(restTemplate);
        documentExtractionService.extractData(getTriggerRequest());
        assertDataSaved(documentRepository);
    }
}
