package com.in28minutes.rest.webservices.pdfBox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckBox;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Prasanna.Mondhe on 1/14/2019.
 */

@Component
public class FormService {

    public static final String RESULT_FOLDER = "D:\\Result";
    public static final String SOURCE_FOLDER = "D:\\source";

    public FormDetails createTemplatePDF(FormDetails formDetails) throws IOException {

        File file = new File(SOURCE_FOLDER, "Registration_Form.pdf");
        PDDocument document = PDDocument.load(file);
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

        if (acroForm != null) {
            List<PDField> fields = acroForm.getFields();
            for (PDField field : fields) {
                System.out.println("Partial field name is  "+field.getPartialName());
                switch (field.getPartialName()) {
                    case "Name":
                        field.setValue(formDetails.getName());
                        field.setReadOnly(true);
                        break;
                    case "InstitutionCompany Name":
                        field.setValue(formDetails.getCompanyName());
                        field.setReadOnly(true);
                        break;
                    case "undefined_3":
                        field.setValue(formDetails.getAddress());
                        field.setReadOnly(true);
                        break;
                    case "City":
                        field.setValue(formDetails.getCity());
                        field.setReadOnly(true);
                        break;
                    case "email":
                        field.setValue(formDetails.getEmail());
                        field.setReadOnly(true);
                        break;
                    case "StateProvince":
                        field.setValue(formDetails.getState());
                        field.setReadOnly(true);
                        break;
                }
            }
        }

        document.save(new File(RESULT_FOLDER, "Result.pdf"));
        document.close();
        return formDetails;

    }
}
