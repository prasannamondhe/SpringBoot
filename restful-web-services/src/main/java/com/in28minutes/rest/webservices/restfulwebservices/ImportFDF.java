package com.in28minutes.rest.webservices.restfulwebservices;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Prasanna.Mondhe on 1/14/2019.
 */
public class ImportFDF {
    public static final String RESULT_FOLDER = "D:\\Destination";

    public void testFillLikeStDdt() throws IOException {
        File file = new File("D:\\target\\Registration_Form.pdf");
        PDDocument document = PDDocument.load(file);
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

        if (acroForm != null) {
            List<PDField> fields = acroForm.getFields();
            for (PDField field : fields) {
                switch (field.getPartialName()) {
                    case "City" /*"devices"*/:
                        field.setValue("Aurangabad");
                        field.setReadOnly(true);
                        break;
                }
            }
        }

        document.save(new File(RESULT_FOLDER, "FillFormFieldStDdt.pdf"));
        document.close();
    }

    public static void main(String[] args) throws IOException {
        ImportFDF importFDF = new ImportFDF();
        importFDF.testFillLikeStDdt();
    }

}
