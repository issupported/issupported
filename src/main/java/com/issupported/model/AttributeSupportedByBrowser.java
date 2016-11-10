package com.issupported.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "browser_to_attribute")
public class AttributeSupportedByBrowser implements Serializable {

    @EmbeddedId
    private AttributeSupportedByBrowserId attributeSupportedByBrowserId;

    @OneToOne
    @JoinColumn(name = "browser_id", insertable = false, updatable = false)
    private Browser browser;

    @OneToOne
    @JoinColumn(name = "attribute_id", insertable = false, updatable = false)
    private Attribute attribute;

    @OneToOne
    @JoinColumn(name = "version_id", insertable = false, updatable = false)
    private Version version;

    @Column(name = "supported")
    private String supported;

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

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public String getSupported() {
        return supported;
    }

    public void setSupported(String supported) {
        this.supported = supported;
    }
}
