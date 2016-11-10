package com.issupported.controller;

import com.issupported.attributesFinder.AttributesFinder;
import com.issupported.attributesFinder.Position;
import com.issupported.model.Attribute;
import com.issupported.model.AttributeSupportedByBrowser;
import com.issupported.service.AttributeService;
import com.issupported.service.AttributeSupportedByBrowserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {

    private AttributeService attributeService;
    private AttributeSupportedByBrowserService attributeSupportedByBrowserService;

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public Map<AttributeSupportedByBrowser, List<Position>> uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> itr = request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getSize()); //TODO: change to the logger

        String input = null;
        try {
            input = new String(mpf.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        AttributesFinder attributesFinder = new AttributesFinder(attributeService.getAll());

        Map<Attribute, List<Position>> parsedResult =attributesFinder.findAttributes(input);
        Map<AttributeSupportedByBrowser, List<Position>> finalResult = new HashMap<>();
        AttributeSupportedByBrowser attributeSupportedByBrowser;

        for (Attribute a: parsedResult.keySet()) {
            attributeSupportedByBrowser = attributeSupportedByBrowserService.getByAttribute(a);
            finalResult.put(attributeSupportedByBrowser, parsedResult.get(a));
        }
        return finalResult;
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
}
