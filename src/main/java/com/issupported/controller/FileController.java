package com.issupported.controller;

import com.issupported.attributesFinder.AttributesFinder;
import com.issupported.attributesFinder.Position;
import com.issupported.model.Attribute;
import com.issupported.model.BrowserSupported;
import com.issupported.service.AttributeService;

import com.issupported.service.BrowserSupportedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
public class FileController {

    private AttributeService attributeService;
    private BrowserSupportedService browserSupportedService;

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public Map<List<BrowserSupported>, List<Position>> uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {

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

        Map<List<BrowserSupported>, List<Position>> finalResult = new HashMap<>();
        Attribute[] objects= parsedResult.keySet().toArray(new Attribute[parsedResult.keySet().size()]); //TODO: refactor
        List<BrowserSupported> browserSupportedList;
        for (Attribute a: objects) {
            browserSupportedList = browserSupportedService.getByAttribute(a);

            finalResult.put(browserSupportedList, parsedResult.get(a));
        }
        return finalResult;
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @Autowired
    public void setBrowserSupportedService(BrowserSupportedService browserSupportedService) {
        this.browserSupportedService = browserSupportedService;
    }
}
