package alumnodatossesion;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.svg.converter.SvgConverter;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class DatosSesionGrupo {

    public Table creaDatosSesioonGrupo(PdfDocument pdfDocument) throws IOException {
        Table tabla = new Table(new float[] {1,1});
        tabla.startNewRow();
        tabla.addCell(creaDatosAlumno( pdfDocument, "Jesús Reyes Juan Carlos Espinoza Sanchéz", "tzonteco", "juanito")
                .add(new Paragraph("www.e-squadron.com.mx")
                        .setTextAlignment(TextAlignment.CENTER).setMarginTop(20).setMarginBottom(20)));
        tabla.addCell(creaDatosAlumno( pdfDocument, "Jesús Reyes Juan Carlos Espinoza Sanchéz", "tzonteco", "juanito")
                .add(new Paragraph("www.e-squadron.com.mx")
                        .setTextAlignment(TextAlignment.CENTER).setMarginTop(20).setMarginBottom(20)));
        tabla.addCell(creaDatosAlumno( pdfDocument, "Jesús Reyes Juan Carlos Espinoza Sanchéz", "tzonteco", "juanito")
                .add(new Paragraph("www.e-squadron.com.mx")
                        .setTextAlignment(TextAlignment.CENTER).setMarginTop(20).setMarginBottom(20)));
        tabla.addCell(creaDatosAlumno( pdfDocument, "Jesús Reyes Juan Carlos Espinoza Sanchéz", "tzonteco", "juanito")
                .add(new Paragraph("www.e-squadron.com.mx")
                        .setTextAlignment(TextAlignment.CENTER).setMarginTop(20).setMarginBottom(20)));
        tabla.useAllAvailableWidth().setMarginTop(40);
        return tabla;
    }

    private Cell creaDatosAlumno(PdfDocument pdf, String nombreAlumno, String apodoProfesor, String apodoAlumno) throws IOException {
        Table tabla = new Table(new float[] {1,1});
        tabla.addCell(new Cell(1,2)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(Border.NO_BORDER)
                .add(new Paragraph()
                        .add(new Image(ImageDataFactory.create("Logo_escuadron.png"))
                                .setWidth(70).setHeight(30)
                                .setMarginTop(20).setMarginBottom(20))));
        tabla.addCell(this.crearCampoNombreAlumno(new Paragraph(nombreAlumno)));
        tabla.addCell(this.crearCampoMaestro(new Paragraph()
                .add(new Image(ImageDataFactory.create("maestro.png"))
                        .setWidth(30).setHeight(30))));
        tabla.addCell(this.crearCampoMaestro(new Paragraph("Teacher Username\n".concat(apodoProfesor))));
        tabla.addCell(this.creaCampoAlumno(apodoAlumno));
        tabla.addCell(this.creaCampoAlumno(pdf));
        tabla.setWidth(200);
        tabla.setMarginLeft(35);
        Cell celda = new Cell().setBorder(new DashedBorder(new DeviceRgb(0, 164, 234),1));
        celda.add(tabla);
        return celda;
    }

    private Cell crearCampoNombreAlumno(Paragraph nombre){
        Cell celda = new Cell(1,2)
                .setTextAlignment(TextAlignment.CENTER)
                .setFontColor(ColorConstants.WHITE)
                .setBackgroundColor(new DeviceRgb(0,164,234));
        celda.add(nombre);
        celda.setBorder(Border.NO_BORDER);
        return celda;
    }

    private Cell crearCampoMaestro(Paragraph apodo){
        Cell celda = new Cell(1,1)
                .setTextAlignment(TextAlignment.CENTER);
        celda.add(apodo);
        celda.setBorderBottom(new DashedBorder(new DeviceRgb(0,164,234),1))
                .setBorderLeft(Border.NO_BORDER)
                .setBorderRight(Border.NO_BORDER)
                .setBorderTop(Border.NO_BORDER);
        return celda;
    }

    private Cell creaCampoAlumno(String apodoAlumno) throws MalformedURLException {
        Cell celda = new Cell(1,1)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(Border.NO_BORDER);
        Paragraph texto = new Paragraph("Student\n")
                .add(new Image(ImageDataFactory.create("maestro.png")).setWidth(30).setHeight(30));
        texto.add("\n".concat(apodoAlumno));
        celda.add(texto);
        return celda;
    }

    private Cell creaCampoAlumno(PdfDocument pdf) throws IOException{
        Cell celda = new Cell(1,1)
                .setTextAlignment(TextAlignment.CENTER)
                .setBorder(Border.NO_BORDER);
        Paragraph texto = new Paragraph("Password\n")
                .add(SvgConverter.convertToImage(new File("planeta1.svg").toURI().toURL().openStream(), pdf).setWidth(30).setHeight(30))
                .add("\t")
                .add(SvgConverter.convertToImage(new File("nave1.svg").toURI().toURL().openStream(), pdf).setWidth(30).setHeight(30));
        celda.add(texto);
        return celda;
    }
}
