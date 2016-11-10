package com.issupported.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AttributeSupportedByBrowserId implements Serializable {

    @Column(name = "browser_id", insertable = false, updatable = false)
    private int browserId;

    @Column(name = "attribute_id", insertable = false, updatable = false)
    private int attributeId;

    @Column(name = "version_id", insertable = false, updatable = false)
    private int versionId;
}
