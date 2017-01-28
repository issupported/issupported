package com.issupported.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class BrowserSupportedId implements Serializable {

    @Column(name = "browser_id")
    private int browserId;

    @Column(name = "attribute_id")
    private int attributeId;

    public int getBrowserId() {
        return browserId;
    }

    public int getAttributeId() {
        return attributeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrowserSupportedId that = (BrowserSupportedId) o;

        if (browserId != that.browserId) return false;
        return attributeId == that.attributeId;

    }

    @Override
    public int hashCode() {
        int result = browserId;
        result = 31 * result + attributeId;
        return result;
    }

    @Override
    public String toString() {
        return "BrowserSupportedId{" +
                "browserId=" + browserId +
                ", attributeId=" + attributeId +
                '}';
    }
}