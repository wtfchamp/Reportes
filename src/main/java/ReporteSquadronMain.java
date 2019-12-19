import alumnodatossesion.DatosSesionGrupo;
import alumnoindividual.TablaAlumnoModelo;
import alumnoindividual.TablaAlumnoPDF;
import alumnosclase.TablaClaseModelo;
import alumnosclase.TablaGrupoAlumnosPDF;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import gruposasignados.TablaGruposModelo;
import gruposasignados.TablaGruposPDF;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReporteSquadronMain {
    private List<TablaGruposModelo> tablaGruposModeloList = new ArrayList<>();
    public List<TablaClaseModelo> tablaClaseModeloList = new ArrayList<>();
    public List<TablaAlumnoModelo> tablaAlumnoModeloList = new ArrayList<>();
    public static final String dir1 = "prueba1.pdf";
    public static final String dir2 = "prueba2.pdf";
    public static final String dir3 = "prueba3.pdf";
    public static final String dir4 = "datosSesion.pdf";
    public static void main(String[] args) throws IOException{
        new ReporteSquadronMain().creaPDF1(dir1);
        new ReporteSquadronMain().creaPDF2(dir2);
        new ReporteSquadronMain().creaPDF3(dir3);
        new ReporteSquadronMain().creaPDFDatosSesionGrupo();
    }

    public void creaPDF1(String dir1) throws IOException {
        this.tablaGruposModeloList.add(new TablaGruposModelo((short) 2, 'A',26));
        this.tablaGruposModeloList.add(new TablaGruposModelo((short) 2, 'B',30));
        this.tablaGruposModeloList.add(new TablaGruposModelo((short) 2, 'C',46));
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(dir1));
        try(Document documento = new Document(documentoPdf)){
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Quantitative Report").setTextAlignment(TextAlignment.CENTER).setMinWidth(50).setFontSize(20).setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            TablaGruposPDF tablaGruposPDF = new TablaGruposPDF();
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado( "Juan Reyes García", "Juanito", "juan.reyes@hotmail.com"));
            documento.add(tablaGruposPDF.creaTabla(tablaGruposModeloList));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void creaPDF2(String dir2) throws IOException{
        tablaClaseModeloList.add(
                new TablaClaseModelo(
                        "Jesus Juanito Carlos Reyes", "1/1/1","", "5/5", "", "6/6", "6/6"
                        ));
        tablaClaseModeloList.add(
                new TablaClaseModelo(
                        "Jesus Juanito Carlos Reyes", "1/1/1","", "5/5", "", "6/6", "6/6"
                        ));
        tablaClaseModeloList.add(
                new TablaClaseModelo(
                        "Jesus Juanito Carlos Reyes", "1/1/1","", "5/5", "", "6/6", "6/6"
                        ));

        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(dir2));
        try(Document documento = new Document(documentoPdf)){
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Activity Report Grupo 5° \"A\"").setTextAlignment(TextAlignment.CENTER).setMinWidth(50).setFontSize(20).setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            TablaGrupoAlumnosPDF tablaGrupoAlumnosPDF = new TablaGrupoAlumnosPDF();
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado("Jesus Reyes Juan Carlos", "Juanito", "juan.reyes@hotmail.com"));
            documento.add(tablaGrupoAlumnosPDF.creaTabla( documentoPdf, tablaClaseModeloList));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void creaPDF3(String dir3) throws IOException {
        tablaAlumnoModeloList.add(
                new TablaAlumnoModelo(
                        "What do you usually do in your bedroom after class?", "01/01/2019",30.2f, 48, 67, 89, 90,67.5f
                ));tablaAlumnoModeloList.add(
                new TablaAlumnoModelo(
                        "What do you usually do in your bedroom after class?", "01/01/2019",30.2f, 48, 67, 89, 90,67.5f
                ));tablaAlumnoModeloList.add(
                new TablaAlumnoModelo(
                        "What do you usually do in your bedroom after class?", "01/01/2019",30.2f, 48, 67, 89, 90,67.5f
                ));
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(dir3));
        try(Document documento = new Document(documentoPdf)){
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Student Juanito Activities Report").setTextAlignment(TextAlignment.CENTER).setMinWidth(50).setFontSize(20).setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            DatosUsuarioPDF datosUsuarioPDF = new DatosUsuarioPDF();
            TablaAlumnoPDF tablaAlumnoPDF = new TablaAlumnoPDF();
            documento.add(datosUsuarioPDF.creaDatosEncabezado("Jesus Reyes Juan Carlos", "Juanito", "juan.reyes@hotmail.com"));
            documento.add(tablaAlumnoPDF.creaTabla(documentoPdf, tablaAlumnoModeloList));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void creaPDFDatosSesionGrupo() throws IOException {
        /*tablaAlumnoModeloList.add(
                new TablaAlumnoModelo(
                        "What do you usually do in your bedroom after class?", "01/01/2019",30.2f, 48, 67, 89, 90,67.5f
                ));tablaAlumnoModeloList.add(
                new TablaAlumnoModelo(
                        "What do you usually do in your bedroom after class?", "01/01/2019",30.2f, 48, 67, 89, 90,67.5f
                ));tablaAlumnoModeloList.add(
                new TablaAlumnoModelo(
                        "What do you usually do in your bedroom after class?", "01/01/2019",30.2f, 48, 67, 89, 90,67.5f
                ));*/
        PdfDocument documentoPdf = new PdfDocument(new PdfWriter(dir4));
        try(Document documento = new Document(documentoPdf)){
            documento.setMargins(documento.getTopMargin()-20,
                    documento.getRightMargin()-10,
                    documento.getBottomMargin()-75,
                    documento.getLeftMargin()-10);
            EventoPagina evento = new EventoPagina(documento, documentoPdf);
            documento.add(new Paragraph("Students Login Info")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setMinWidth(50)
                    .setFontSize(20)
                    .setMarginBottom(20));
            documentoPdf.addEventHandler(PdfDocumentEvent.END_PAGE, evento);
            DatosSesionGrupo datosSesionGrupo = new DatosSesionGrupo();
            documento.add(datosSesionGrupo.creaDatosSesioonGrupo(documentoPdf));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
