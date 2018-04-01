package com.rest.data.extractor.demo.factory;

import com.rest.data.extractor.demo.model.Data;
import com.rest.data.extractor.demo.model.Document;
import com.rest.data.extractor.demo.model.TriggerRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityFactory {

    public static final String ID = "sdfsdfsdgxcv";

    public static Document getDocument() {
        Document document = new Document();
        Data data = new Data();
        List<Data> dataList = new ArrayList<>();
        data.setDateModified(new Date());
        data.setDatePublished(new Date());
        data.setFormat("doc");
        data.setTitle("Title");
        data.setHash("asaf234dfsf");
        data.setId("111aaa222");
        data.setUrl("google.com");
        data.setDocumentOf("document");
        dataList.add(data);
        document.setData(dataList);
        return document;
    }

    public static TriggerRequest getTriggerRequest() {
        List<String> listOfIds = new ArrayList<>();
        listOfIds.add(ID);
        TriggerRequest triggerRequest = new TriggerRequest();
        triggerRequest.setContractIds(listOfIds);
        return triggerRequest;
    }
}
