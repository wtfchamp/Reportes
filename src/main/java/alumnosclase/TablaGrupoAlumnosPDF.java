package alumnosclase;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.svg.converter.SvgConverter;

import java.io.File;
import java.util.List;

public class TablaGrupoAlumnosPDF {

    /**
     * Metodo que crea una tabla
     * @param pdf objeto del tipo {@link PdfDocument}
     * @return una Tabla con los valores correspondientes.
     * @throws Exception
     */
    public Table creaTabla(PdfDocument pdf, List<TablaClaseModelo> tablaClaseModeloLista) throws Exception {
        float[] colWidths = {2, 1, 1, 1, 1, 1, 1, 1};
        Table tabla = new Table(colWidths);
        Cell celda = this.crearCampo(1, 9);
        celda.add(new Paragraph("Alumno de la clase").setFontColor(ColorConstants.WHITE));
        tabla.addCell(celda);
        tabla.addCell(this.crearCampo("Nombre", 1, 2, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Think-Develop and Share", 1, 1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Word Game", 1, 1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Match Image", 1, 1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Order Prayer", 1, 1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Mix & Match", 1, 1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Complete Prayers", 1, 1, new DeviceRgb(206, 204, 194)));
        File svg;
        svg = new File("forbidden.svg");
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        imgSVG.setMarginLeft(22);
        for (TablaClaseModelo tablaClaseModelo : tablaClaseModeloLista){
            tabla.addCell(this.crearCampo("Mario Maurio de Teresita Garcia Gonzalez",1,2, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("1/1/1",1,1, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("",1,1, new DeviceRgb(255, 255, 255)).add(imgSVG));
            tabla.addCell(this.crearCampo("5/5",1,1, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("",1,1, new DeviceRgb(255, 255, 255)).add(imgSVG));
            tabla.addCell(this.crearCampo("6/6",1,1, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("6/6",1,1, new DeviceRgb(255, 255, 255)));
        }
        tabla.setBorder(Border.NO_BORDER);
        tabla.setMarginBottom(20);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas.
     * @param valorCampo El nombre de la columna
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
     * Metodo que crea una celda para el titulo de la tabla
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de filas a unir o fusionar
     * @return una nueva Celda con el valor correspondiente.
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
