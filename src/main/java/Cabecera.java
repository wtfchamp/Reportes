import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;

public class Cabecera{
    String nombreProfesor;
    String apodo;
    String correo;
    String escuela;
    String cicloEscolar;

    public Cabecera(String nombreProfesor, String apodo, String correo, String escuela, String cicloEscolar){
        this.nombreProfesor = nombreProfesor;
        this.apodo = apodo;
        this.escuela = escuela;
        this.correo = correo;
        this.cicloEscolar = cicloEscolar;
    }

    public void formato() throws FileNotFoundException {
        PdfWriter  pdfWriter = new PdfWriter("Cabecera.pdf");
        PdfDocument pdfDoc = new PdfDocument(pdfWriter);
        Document documento = new Document(pdfDoc, PageSize.LETTER);

        EventoPagina evento = new EventoPagina(documento, pdfDoc);
        pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, evento);

        documento.setMargins(documento.getTopMargin()-20, documento.getRightMargin()-10, documento.getBottomMargin()-75
                            , documento.getLeftMargin()-10);

            documento.add(new Paragraph("   Prueba de encabezado y pie de pagina"));
        documento.close();
    }

}