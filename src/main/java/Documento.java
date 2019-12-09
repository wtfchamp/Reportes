import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;

import java.awt.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Documento {
    public static void main(String[] args) throws IOException {


        PDDocument documento = new PDDocument();
        PDDocumentInformation info = documento.getDocumentInformation();


        info.setAuthor("BETO");
        info.setTitle("Documento de Prueba");
        info.setCreator("Beto");
        info.setSubject("Prueba");

        info.setCreationDate(Calendar.getInstance());

        info.setKeywords("prueba, PDF, texto");

        PDPage pagina = new PDPage();

        documento.addPage(pagina);



        PDPageContentStream contenido = new PDPageContentStream(documento, documento.getPage(0));

        Celda celda = new Celda(10,10,"Prueba");
        celda.creaCelda(25,500,Color.BLACK,contenido);

        documento.save("prueba.pdf");
        documento.close();
    }
}
