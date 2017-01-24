package com.issupported.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "browser_to_attribute")
public class BrowserSupported implements Serializable {

    @EmbeddedId
    private BrowserSupportedId id;

    @ManyToOne
    @JoinColumn(name = "browser_id", insertable = false, updatable = false)
    private Browser browser;

    @ManyToOne
    @JoinColumn(name = "attribute_id", insertable = false, updatable = false)
    private Attribute attribute;
    /*
    @Column(name = "supported")
    @Enumerated(EnumType.STRING)
    private Supported supported;*/

    @ElementCollection
    @MapKeyColumn(name = "attribute_id")
    @Column(name="supported") @Enumerated(EnumType.STRING)
    //@CollectionTable(name="browser_to_attribute", joinColumns=@JoinColumn(name="browser_id"))
    private Map<Attribute, Supported> attributeSupported = new HashMap<>();

    //TODO: store some statistics

    public BrowserSupportedId getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BrowserSupported{" +
                "id=" + id +
                ", browser=" + browser +
                ", attributeSupported=" + attributeSupported +
                '}';
    }
}
