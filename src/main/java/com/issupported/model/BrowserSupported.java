package com.issupported.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "browser_to_attribute")
public class BrowserSupported implements Serializable{

    @EmbeddedId
    private BrowserSupportedId id;

    @ManyToOne
    @JoinColumn(name = "browser_id", insertable = false, updatable = false)
    private Browser browser;

    @ManyToOne
    @JoinColumn(name = "attribute_id", insertable = false, updatable = false)
    private Attribute attribute;

    @Column(name = "supported_status")
    @Enumerated(EnumType.STRING)
    private SupportedStatus supportedStatus;

    //TODO: store some statistics


    public BrowserSupportedId getId() {
        return id;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public SupportedStatus getSupportedStatus() {
        return supportedStatus;
    }

    public void setSupportedStatus(SupportedStatus supportedStatus) {
        this.supportedStatus = supportedStatus;
    }

    @Override
    public String toString() {
        return "BrowserSupported{" +
                "browser=" + browser +
                ", attribute=" + attribute +
                ", supportedStatus=" + supportedStatus +
                '}';
    }
}
