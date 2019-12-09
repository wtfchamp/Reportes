import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;

public class Celda {
    int largo;
    int ancho;
    String texto;

    public Celda(int largo, int ancho, String texto){
        this.largo = largo;
        this.ancho = ancho;
        this.texto = texto;
    }


    public void creaCelda(int posX, int posY, Color color, PDPageContentStream contenido) throws IOException {
        contenido.setNonStrokingColor(Color.LIGHT_GRAY);
        contenido.addRect(posX,posY,largo,ancho);
        contenido.fill();
        contenido.beginText();
        contenido.setNonStrokingColor(Color.BLACK);
        contenido.setFont(PDType1Font.TIMES_ROMAN, 12);
        contenido.newLineAtOffset(posX,posY);
        String text = texto;
        contenido.showText(texto);
        contenido.endText();
        contenido.close();
    }
}
