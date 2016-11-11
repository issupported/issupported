package com.issupported.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AttributeSupportedByBrowserId implements Serializable {

    @ManyToOne
    private Browser browser;

    @ManyToOne
    private Attribute attribute;

    @ManyToOne
    private Version version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttributeSupportedByBrowserId that = (AttributeSupportedByBrowserId) o;

        if (browser != null ? !browser.equals(that.browser) : that.browser != null) return false;
        if (attribute != null ? !attribute.equals(that.attribute) : that.attribute != null) return false;
        return version != null ? version.equals(that.version) : that.version == null;

    }

    @Override
    public int hashCode() {
        int result = browser != null ? browser.hashCode() : 0;
        result = 31 * result + (attribute != null ? attribute.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }
}
