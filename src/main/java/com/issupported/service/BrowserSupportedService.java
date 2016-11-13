package com.issupported.service;

import com.issupported.dao.hibernate.HBrowserSupportedDao;
import com.issupported.model.Attribute;
import com.issupported.model.BrowserSupported;

import java.util.List;

public class BrowserSupportedService {

    private HBrowserSupportedDao browserSupportedDao;

    public List<BrowserSupported> getByAttribute(Attribute attribute) {
        return browserSupportedDao.getByAttribute(attribute);
    }

    public void setBrowserSupportedDao(HBrowserSupportedDao browserSupportedDao) {
        this.browserSupportedDao = browserSupportedDao;
    }
}
