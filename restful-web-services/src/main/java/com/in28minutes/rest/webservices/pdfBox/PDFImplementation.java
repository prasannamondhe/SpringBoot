package com.in28minutes.rest.webservices.pdfBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Prasanna.Mondhe on 1/14/2019.
 */

@RestController
public class PDFImplementation {

    @Autowired
    FormService formService;

    @PostMapping(path = "/createTemplate")
    public void fillPDFForm(@RequestBody FormFields formFields) throws IOException, URISyntaxException {
        formService.createTemplatePDF(formFields);
    }

    @GetMapping(path = "/download")
    public ResponseEntity<InputStreamResource> downloadPDFForm() throws IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("Result.pdf").getFile());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Result.pdf");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }
}
