package com.rest.data.extractor.demo.repository;

import com.rest.data.extractor.demo.model.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
