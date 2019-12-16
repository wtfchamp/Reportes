import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.IOException;

public class ReporteSquadronMain {
    public static final String dir = "prueba.pdf";
    public static void main(String[] args) throws IOException{
        File file = new File(dir);
        new ReporteSquadronMain().creaPDF(dir);
    }

    public void creaPDF(String dir) throws IOException {
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(dir));
        try(Document documento = new Document(documentoPdf)){
            documento.setMargins(documento.getTopMargin()-20, documento.getRightMargin()-10, documento.getBottomMargin()-75,
                        documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            TablaGruposPDF tablaGruposPDF = new TablaGruposPDF();
            TablaGrupoAlumnosPDF tablaGrupoAlumnosPDF = new TablaGrupoAlumnosPDF();
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            TablaAlumnoPDF tablaAlumnoPDF = new TablaAlumnoPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado(documentoPdf));
            documento.add(tablaGruposPDF.creaTabla(9));
            documento.add(tablaGrupoAlumnosPDF.creaTabla(documentoPdf));
            documento.add(tablaAlumnoPDF.creaTabla(documentoPdf));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
