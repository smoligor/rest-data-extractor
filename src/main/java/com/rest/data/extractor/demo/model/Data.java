package com.rest.data.extractor.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@lombok.Data
@Entity
public class Data {
    @Id
    private String id;

    @Temporal(TemporalType.DATE)
    private Date dateModified;

    private String title;

    private String hash;

    @Temporal(TemporalType.DATE)
    private Date datePublished;

    private String documentOf;

    private String format;

    private String url;
}
