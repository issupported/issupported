package com.issupported.controller;

import com.issupported.attributesFinder.AttributesFinder;
import com.issupported.attributesFinder.Position;
import com.issupported.model.Attribute;
import com.issupported.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    private AttributeService attributeService;
    private AttributesFinder attributesFinder;
    private String test= ".wrapper{\n" +
            "    border-radius: 2px;\n" +
            "    cursor: alias;\n" +
            "}\n" +
            ".box{\n" +
            "    border-radius: 10px;\n" +
            "    cursor: col-resize;\n" +
            "}";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<Attribute, List<Position>> find() {
        attributesFinder = new AttributesFinder(attributeService.getAll());
        return attributesFinder.findAttributes(test);
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
}
