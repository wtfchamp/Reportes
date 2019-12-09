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

        contenido.setNonStrokingColor(Color.LIGHT_GRAY);
        contenido.addRect(200,650,100,100);
        contenido.fill();

        contenido.beginText();
            contenido.setNonStrokingColor(Color.BLACK);
            contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
            contenido.newLineAtOffset(25,500);
            String texto = "Esta es una prueba de como escribir en pdf";
            contenido.showText(texto);
            contenido.endText();
        contenido.close();

        documento.save("prueba.pdf");
        documento.close();
    }
}
