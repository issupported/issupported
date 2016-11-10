package com.issupported.model;

import javax.persistence.*;

@Entity
@Table(name = "browser_to_attribute")
public class AttributeSupportedByBrowser {

    @Id
    @OneToOne
    @Column(name = "browser_id")
    private Browser browser;

    @Id
    @OneToOne
    @Column(name = "version_id")
    private Attribute attribute;

    @Id
    @OneToOne
    @Column(name = "version_id")
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
