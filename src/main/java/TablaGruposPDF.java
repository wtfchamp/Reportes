import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class TablaGruposPDF {

    /**
     * Metodo que crea una tabla con valores
     * @param numColumnas numero de columnas a crear, valor default 9
     * @return una tabla con sus valores correspondientes.
     */
    public Table creaTabla(int numColumnas){
        Table tabla = new Table(numColumnas);
        tabla .addCell(this.crearCampo(1,9).add(new Paragraph("Grupos asignados para este ciclo escolar").setFontColor(ColorConstants.WHITE)));
        tabla.addCell(this.crearCampo("Grado", 1, 3, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Grupo", 1, 3, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Total Alumnos", 1, 3, new DeviceRgb(206, 204, 194)));
        for (int i = 1; i<= 4; i++){
            tabla.addCell(this.crearCampo("2°", 1, 3, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("B", 1, 3, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("20", 1, 3, new DeviceRgb(2555, 255, 255)));
        }
        tabla.setBorder(Border.NO_BORDER);
        tabla.setMarginBottom(30);
        tabla.useAllAvailableWidth();
        return tabla;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas.
     * @param valorCampo El nombre de la columna
     * @param rowSpan Numero de filas a unir o fusionar
     * @param colSpan Numero de columnas a unir o fusionar
     * @return una Celda con el valor correspondiente.
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
     * Metodo para crear el titulo de la tabla
     * @param rowSpan numero de filas a unir o fusionar
     * @param colSpan numero de columnas a unir o fusionar
     * @return una Celda con las modificaciones correspondientes.
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
