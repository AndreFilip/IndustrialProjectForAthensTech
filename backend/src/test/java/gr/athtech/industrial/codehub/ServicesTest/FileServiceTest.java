package gr.athtech.industrial.codehub.ServicesTest;

import gr.athtech.industrial.codehub.services.FileServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {

    private static final Logger log = LoggerFactory.getLogger(FileServiceTest.class);

    @Autowired
    private FileServices fileServices;

    @Test
    public void findInWordDocTest(){
        List<String> valuesList = new ArrayList<>();
        valuesList.add("Java");
        valuesList.add("Html");
        valuesList.add("Angular");
        valuesList.add("άλλο");
        fileServices.findTextInWordDocument("C:\\temp/codeHub/test.docx", valuesList);
    }

    @Test
    public void findInWordPDFTest() throws IOException {
        List<String> valuesList = new ArrayList<>();
        valuesList.add("Java");
        valuesList.add("Html");
        valuesList.add("Angular");
        valuesList.add("άλλο");
        fileServices.findTextInPDFDocument("C:\\temp/codeHub/test.pdf", valuesList);
    }
}
