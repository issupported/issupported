package com.issupported.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "browser_to_attribute")
@AssociationOverrides({
        @AssociationOverride(name = "attributeSupportedByBrowserId.browser",
                joinColumns = @JoinColumn(name = "browser_id")),
        @AssociationOverride(name = "attributeSupportedByBrowserId.attribute",
                joinColumns = @JoinColumn(name = "attribute_id")),
        @AssociationOverride(name = "attributeSupportedByBrowserId.version",
                joinColumns = @JoinColumn(name = "version_id"))
})
public class AttributeSupportedByBrowser implements Serializable {

    @EmbeddedId
    private AttributeSupportedByBrowserId attributeSupportedByBrowserId;


    @Transient
    private Browser browser;

    @Transient
    private Attribute attribute;

    @Transient
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
