package gr.athtech.industrial.codehub.services;

import gr.athtech.industrial.codehub.model.CodeHubUser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.List;

/**
 *
 * @author George Lalas
 */
@Service("fileService")
public class FileServices {
    private static final Logger log = LoggerFactory.getLogger(FileServices.class);

    //TODO CHANGE RETURN TYPE BASED ON BUSINESS LOGIC
    public void findWordsInUserCV(CodeHubUser user,List<String> stringValuesList){
        String filepath = user.getCvPath();
        if(filepath.contains(".pdf")){
            try {
                findTextInPDFDocument(filepath, stringValuesList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(filepath.contains(".docx")){
            findTextInWordDocument(filepath, stringValuesList);
        }
    }

    public void findTextInWordDocument(String filepath, List<String> stringValuesList ){
        XWPFDocument docx = null;
        try {
            docx = new XWPFDocument(new FileInputStream(filepath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        XWPFWordExtractor we = new XWPFWordExtractor(docx);
        for(String stringValues : stringValuesList) {
            log.info("WORD TO SEARCH: {}", stringValues);
            if (we.getText().contains(stringValues)) {
                log.info("Word {} found!", stringValues);
            }
            else{
                log.info("Word {} not found!", stringValues);
            }
        }
    }

    public void findTextInPDFDocument(String filepath, List<String> stringValuesList) throws IOException {
        File file = new File(filepath);
        PDDocument document = PDDocument.load(file);
        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        for(String stringValues : stringValuesList) {
            log.info("WORD TO SEARCH: {}", stringValues);
            if (text.contains(stringValues)) {
                log.info("Word {} found!", stringValues);
            }
            else{
                log.info("Word {} not found!", stringValues);
            }
        }
        //Closing the document
        document.close();
    }
}
