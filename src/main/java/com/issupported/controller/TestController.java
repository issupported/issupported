package com.issupported.controller;

import com.issupported.model.Attribute;
import com.issupported.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    private AttributeService attributeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Attribute> getAll() {
        return attributeService.getAll();
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
}
