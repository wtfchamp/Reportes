import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.svg.converter.SvgConverter;

import java.io.File;

public class DatosUsuarioPDF {

    /**
     * Metodo que crea una tabla
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una nueva tabla con sus valores correspondientes.
     * @throws Exception Error de lectura de archivo
     */
    public Table creaDatosEncabezado(PdfDocument pdf) throws Exception{
        Table tabla = new Table(new float[]{1,1});
        Table tablaBorder = new Table(1);
        File svg;
        svg = new File("maestro.svg");
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        imgSVG.setWidth(30).setHeight(30).setMarginLeft(15);
        tabla.addCell(this.creaCelda("", 2,1,  new DeviceRgb(0,0,0)).setBorder(Border.NO_BORDER).add(imgSVG));
        tabla.addCell(this.creaCelda("Jose Ismael Gonzalez Tzontecomani", 1,1, new DeviceRgb(0,0,0)).setBorder(Border.NO_BORDER));
        tabla.addCell(this.creaCelda("zonteco", 1, 1, new DeviceRgb(153, 153, 153)).setBorder(Border.NO_BORDER));
        tabla.addCell(this.creaCelda("Apodo: zonteco", 1, 2, new DeviceRgb(153, 153, 153)).setBorder(Border.NO_BORDER));
        tabla.addCell(this.creaCelda("Correo: correo@escuela.com", 1, 2, new DeviceRgb(153, 153, 153)).setBorder(Border.NO_BORDER));
        tablaBorder.setBorder(Border.NO_BORDER);
        Cell celda = new Cell().add(tabla);
        celda.setNextRenderer(new RoundedBorderCellRenderer(celda));
        tablaBorder.addCell(celda);
        tablaBorder.setBorder(Border.NO_BORDER);
        tablaBorder.setMarginBottom(30);
        return tablaBorder;
    }

    /**
     * Metodo que crea una celda para los datos del usuario
     * @param valorCampo Datos para llenar los campos de la celda
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de columnas a unir o fusionar
     * @param color un objeto del tipo {@link DeviceRgb}
     * @return una nueva Celda con el valor correspondiente.
     */
    private Cell creaCelda(String valorCampo, int rowSpan, int colSpan, DeviceRgb color){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.LEFT)
                .add(new Paragraph(valorCampo).setFontColor(color))
                .setFontSize(7)
                .setWidth(60);
        return celda;
    }
}
