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

import java.lang.invoke.ConstantCallSite;
import java.net.MalformedURLException;

public class DatosSesionGrupo {

    public Table creaDatosSesioonGrupo(PdfDocument pdfDocument) throws MalformedURLException {
        Table tabla = new Table(new float[] {1,1});
        tabla.addCell(creaDatosAlumno(1,2));
        tabla.addCell(creaDatosAlumno(1,2));
        tabla.addCell(creaDatosAlumno(1,2));
        tabla.addCell(creaDatosAlumno(1,2));
        tabla.addCell(creaDatosAlumno(1,2));
        tabla.addCell(creaDatosAlumno(1,2));
        tabla.useAllAvailableWidth();
        tabla.setBorder(new DashedBorder(new DeviceRgb(0, 164, 157), 1));
        return tabla;
    }

    private Cell creaDatosAlumno(int rowSpan, int colSpan) throws MalformedURLException {
        Cell celda = new Cell(rowSpan,colSpan).setBorder(Border.NO_BORDER);
        Table tabla = new Table(new float[] {1,1});
        celda.add(new Image(ImageDataFactory.create("Logo_escuadron.png")).setWidth(50).setHeight(30).setMarginLeft(110));
        tabla.addCell(celda);
        tabla.addCell(new Cell(rowSpan, colSpan).add(new Paragraph("El Mau").setFontColor(ColorConstants.WHITE).setBackgroundColor(new DeviceRgb(0, 164, 157))));
        tabla.setBorder(Border.NO_BORDER);
        tabla.useAllAvailableWidth();
        celda = new Cell().setBorder(new DashedBorder(new DeviceRgb(0, 164, 157),1));
        celda.add(tabla);
        return celda;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas y los valores de las tablas.
     * @param valorCampo El nombre de la columnax
     * @param rowSpan Numero de filas a unir o fusionar
     * @param colSpan Numero de columnas a unir o fusionar
     * @return una Celda con el campo correspondiente.
     */
    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceRgb color){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color)
                .add(new Paragraph(valorCampo).setFontColor(ColorConstants.BLACK))
                .setFontSize(7);
        celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    /**
     * Metodo que crea el titulo de la tabla
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de columnas a unir o fusionar
     * @return una Celda con el valor correspondientes.
     */
    private Cell crearCampo(int rowSpan, int colSpan){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(0, 164, 157));
        celda.setBorderBottom(new SolidBorder(ColorConstants.WHITE,5));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }
}
