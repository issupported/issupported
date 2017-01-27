package com.issupported.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "browser_to_attribute")
public class BrowserSupported implements Serializable{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "browser_id")
    private Browser browser;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attribute;

    /*
    @Column(name = "supported")
    @Enumerated(EnumType.STRING)
    private Supported supported;*/

    //TODO: store some statistics

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "supported_status_id")
    @MapKeyColumn(name = "attribute_id")
    @CollectionTable(name = "browser_to_attribute_status", joinColumns = @JoinColumn(name = "browser_to_attribute_id"))
    private Map<Attribute, String> attributeSupported = new HashMap<>();

    @Override
    public String toString() {
        return "BrowserSupported{" +
                "id=" + id +
                ", browser=" + browser +
                ", attributeSupported=" + attributeSupported +
                '}';
    }
}
