package com.rest.data.extractor.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class TriggerRequest {
    private List<String> contractIds;
}
