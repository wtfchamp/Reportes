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
            TablaGruposPDF tablaGruposPDF = new TablaGruposPDF();
            TablaGrupoAlumnosPDF tablaGrupoAlumnosPDF = new TablaGrupoAlumnosPDF();
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            TablaAlumnoPDF tablaAlumnoPDF = new TablaAlumnoPDF();
            documento.add(tablaGruposPDF.creaTabla("Grupos asignados para este ciclo escolar", 9, 1,9, 9));
            float[] colWidthsAlumnos = {2, 1, 1, 1, 1, 1, 1, 1};
            documento.add(tablaGrupoAlumnosPDF.creaTabla("Alumnos de la clase", colWidthsAlumnos, 1, 8, documentoPdf));
            documento.add(datosUsuarioPDF.creaDatosEncabezado(documentoPdf));
            documento.add(tablaAlumnoPDF.creaTabla(documentoPdf));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
