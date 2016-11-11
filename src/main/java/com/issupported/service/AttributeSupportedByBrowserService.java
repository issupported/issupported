package com.issupported.service;

import com.issupported.dao.AttributeSupportedByBrowserDao;
import com.issupported.model.Attribute;
import com.issupported.model.AttributeSupportedByBrowser;

public class AttributeSupportedByBrowserService {

    private AttributeSupportedByBrowserDao attributeSupportedByBrowserDao;

    public AttributeSupportedByBrowser getByAttribute(Attribute attribute) {
        return attributeSupportedByBrowserDao.getByAttribute(attribute);
    }

    public void setAttributeSupportedByBrowserDao(AttributeSupportedByBrowserDao attributeSupportedByBrowserDao) {
        this.attributeSupportedByBrowserDao = attributeSupportedByBrowserDao;
    }
}
