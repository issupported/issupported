package com.issupported.model;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "supported")
    @Enumerated(EnumType.STRING)
    private Supported supported;

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

    public Supported getSupported() {
        return supported;
    }

    public void setSupported(Supported supported) {
        this.supported = supported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrowserSupported that = (BrowserSupported) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (browser != null ? !browser.equals(that.browser) : that.browser != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        return supported != null ? supported.equals(that.supported) : that.supported == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (browser != null ? browser.hashCode() : 0);
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (supported != null ? supported.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BrowserSupported{" +
                "id=" + id +
                ", browser=" + browser +
                ", attribute=" + attribute +
                ", supported='" + supported + '\'' +
                '}';
    }
}
