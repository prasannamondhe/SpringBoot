package com.in28minutes.rest.webservices.pdfBox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
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

    public static final String RESULT_FOLDER = "F:\\SpringBoot\\Result";
    public static final String SOURCE_FOLDER = "F:\\SpringBoot\\source";

    public FormFields createTemplatePDF(FormFields formFields) throws IOException {

        File file = new File(SOURCE_FOLDER, "Registration_Form.pdf");
        PDDocument document = PDDocument.load(file);
        PDAcroForm acroForm = document.getDocumentCatalog().getAcroForm();

        if (acroForm != null) {
            List<PDField> fields = acroForm.getFields();
            for (PDField field : fields) {
                System.out.println("Partial field name is  " + field.getPartialName());
                switch (field.getPartialName()) {
                    case "Name":
                        field.setValue(formFields.getName());
                        field.setReadOnly(true);
                        break;
                    case "InstitutionCompany Name":
                        field.setValue(formFields.getCompanyName());
                        field.setReadOnly(true);
                        break;
                    case "undefined_3":
                        field.setValue(formFields.getAddress());
                        field.setReadOnly(true);
                        break;
                    case "City":
                        field.setValue(formFields.getCity());
                        field.setReadOnly(true);
                        break;
                    case "email":
                        field.setValue(formFields.getEmail());
                        field.setReadOnly(true);
                        break;
                    case "StateProvince":
                        field.setValue(formFields.getState());
                        field.setReadOnly(true);
                        break;
                }
            }
        }

        document.save(new File(RESULT_FOLDER, "Result.pdf"));
        document.close();
        return formFields;

    }
}
