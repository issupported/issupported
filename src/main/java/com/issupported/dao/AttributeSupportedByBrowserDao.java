package com.issupported.dao;

import com.issupported.model.Attribute;
import com.issupported.model.AttributeSupportedByBrowser;

public interface AttributeSupportedByBrowserDao {

    AttributeSupportedByBrowser getByAttribute(Attribute attribute);
}
