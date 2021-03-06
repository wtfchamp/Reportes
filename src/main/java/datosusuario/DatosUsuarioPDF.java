package datosusuario;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import datosusuario.RoundedBorderCellRenderer;

public class DatosUsuarioPDF {

    /**
     * Metodo que crea los datos del usario
     * @param nombre nombre del usuario
     * @param apodo apodo del usuario
     * @param correo correo del usuario
     * @return una tabla con sus valores correspondientes
     * @throws Exception error al abrir la imagen
     */
    public Table creaDatosEncabezado(String nombre, String apodo, String correo) throws Exception{
        Table tabla = new Table(new float[]{1,1});
        Table tablaBorder = new Table(1);
        Image imagen = new Image(ImageDataFactory.create("maestro.png"));
        imagen.setWidth(30).setHeight(30).setMarginLeft(15);
        tabla.addCell(this.creaCelda("", 2,1,  new DeviceRgb(0,0,0)).setBorder(Border.NO_BORDER).add(imagen));
        tabla.addCell(this.creaCelda(nombre, 1,1, new DeviceRgb(0,0,0)).setBorder(Border.NO_BORDER));
        tabla.addCell(this.creaCelda(apodo, 1, 1, new DeviceRgb(153, 153, 153)).setBorder(Border.NO_BORDER));
        tabla.addCell(this.creaCelda("Apodo: ".concat(apodo), 1, 2, new DeviceRgb(153, 153, 153)).setBorder(Border.NO_BORDER));
        tabla.addCell(this.creaCelda("Correo: ".concat(correo), 1, 2, new DeviceRgb(153, 153, 153)).setBorder(Border.NO_BORDER));
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
