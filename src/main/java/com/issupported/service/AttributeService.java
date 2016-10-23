package com.issupported.service;

import com.issupported.mappers.AttributeMapper;
import com.issupported.model.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("attributeService")
public class AttributeService {

    @Autowired
    private AttributeMapper attributeMapper;

    public List<Attribute> getAll() {
        return attributeMapper.getAll();
    }
}
