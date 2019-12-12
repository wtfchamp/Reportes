import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderCollapsePropertyValue;
import com.itextpdf.layout.property.BorderRadius;
import com.itextpdf.layout.property.TextAlignment;
import sun.plugin.dom.exception.WrongDocumentException;

public class TablaGruposPDF {

    public Table creaTabla(String tituloTabla,int numColumnas, int rowSpan, int colSpan , int numFilas){
        Table tabla = new Table(numColumnas);
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(0, 164, 157))
                .add(new Paragraph(tituloTabla).setFontColor(ColorConstants.WHITE));
        celda.setBorderBottom(new SolidBorder(ColorConstants.WHITE,5));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);

        tabla.addCell(celda);
        celda = new Cell(1,3)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(206, 204, 194))
                .add(new Paragraph("Grado").setFontColor(ColorConstants.BLACK));
        celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        tabla.addCell(celda);
        celda = new Cell(1,3)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(206, 204, 194))
                .add(new Paragraph("Grupo").setFontColor(ColorConstants.BLACK));
        celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        tabla.addCell(celda);
        celda = new Cell(1,3)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(new DeviceRgb(206, 204, 194))
                .add(new Paragraph("Total Alumnos").setFontColor(ColorConstants.BLACK));
        celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        tabla.addCell(celda);
        for (int i = 1; i<= 20; i++){
            celda = new Cell(1,3)
                    .setTextAlignment(TextAlignment.CENTER)
                    .add(new Paragraph(String.valueOf(i)));
            celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
            celda.setBorderLeft(Border.NO_BORDER);
            celda.setBorderRight(Border.NO_BORDER);
            celda.setBorderTop(Border.NO_BORDER);
            tabla.addCell(celda);
        }
        tabla.setBorder(Border.NO_BORDER);
        tabla.setMarginBottom(30);
        tabla.useAllAvailableWidth();
        return tabla;
    }

}
