import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderRadius;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import com.itextpdf.svg.converter.SvgConverter;

import java.io.File;

public class DatosUsuarioPDF {
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
        return tablaBorder;
    }

    public Table creaInfo(){
        return new Table(2);
    }
    private Cell creaCelda(String valorCampo, int rowSpan, int colSpan, DeviceRgb color){
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.LEFT)
                .add(new Paragraph(valorCampo).setFontColor(color))
                .setFontSize(7)
                .setWidth(60);
        return celda;
    }
}
