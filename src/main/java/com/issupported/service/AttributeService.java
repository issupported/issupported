package com.issupported.service;

import com.issupported.dao.AttributeDao;
import com.issupported.model.Attribute;


import java.util.List;

public class AttributeService {
    
    private AttributeDao attributeDao;

    public List<Attribute> getAll() {
        return attributeDao.getAll();
    }

    public void setAttributeDao(AttributeDao attributeDao) {
        this.attributeDao = attributeDao;
    }
}
