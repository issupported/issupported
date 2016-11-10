package com.issupported.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Embeddable
public class AttributeSupportedByBrowserId implements Serializable {

    @Column(name = "browser_id")
    private int browserId;

    @Column(name = "version_id")
    private int attributeId;

    @Column(name = "version_id")
    private int versionId;
}
