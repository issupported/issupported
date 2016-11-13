package com.issupported.dao;

import com.issupported.model.Attribute;
import com.issupported.model.BrowserSupported;

import java.util.List;

public interface BrowserSupportedDao {

    List<BrowserSupported> getByAttribute(Attribute attribute);

}
