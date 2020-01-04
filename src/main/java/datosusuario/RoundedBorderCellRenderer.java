package datosusuario;

import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.renderer.CellRenderer;
import com.itextpdf.layout.renderer.DrawContext;

public class RoundedBorderCellRenderer extends CellRenderer {

    public RoundedBorderCellRenderer(Cell modelElement) {
        super(modelElement);
        modelElement.setBorder(Border.NO_BORDER);
    }

    /**
     * Método que redpndea los bordes de una celda
     * @param drawContext el contexto del Canvas del PDFCanvas para dibujar el redondeo.
     */
    @Override
    public void draw(DrawContext drawContext) {
        drawContext.getCanvas()
                .roundRectangle(getOccupiedAreaBBox().getX() + 1.5f,
                    getOccupiedAreaBBox().getY() + 1.5f,
                    getOccupiedAreaBBox().getWidth() - 3,
                    getOccupiedAreaBBox().getHeight() - 3,4)
        .setStrokeColorRgb(2f,16f,0f);
        drawContext.getCanvas().stroke();
        super.draw(drawContext);
    }
}
