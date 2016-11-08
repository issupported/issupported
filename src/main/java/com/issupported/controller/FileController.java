package com.issupported.controller;

import com.issupported.attributesFinder.AttributesFinder;
import com.issupported.attributesFinder.Position;
import com.issupported.model.Attribute;
import com.issupported.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
public class FileController {

    private AttributeService attributeService;

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public Map<Attribute, List<Position>> uploadFile(MultipartHttpServletRequest request, HttpServletResponse response) {

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
        System.out.println("size:" + attributesFinder.findAttributes(input).size());
        return attributesFinder.findAttributes(input);
    }

    @Autowired
    public void setAttributeService(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
}
