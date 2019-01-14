package com.in28minutes.rest.webservices.pdfBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Prasanna.Mondhe on 1/14/2019.
 */

@RestController
public class PDFImplementation {

    @Autowired
    FormService formService;

    @PostMapping(path = "/createTemplate")
    public void createEmail(@RequestBody FormDetails formDetails) throws IOException {
        formService.createTemplatePDF(formDetails);
    }
}
