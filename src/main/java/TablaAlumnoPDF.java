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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

public class TablaAlumnoPDF {
    public Table creaTabla(PdfDocument pdf) throws IOException {
        Table tabla = new Table(8);
        Cell celda = this.crearCampo(1, 8);
        celda.add(new Paragraph("Filtros").setFontColor(ColorConstants.WHITE));
        tabla.addCell(celda);
        tabla.addCell(this.crearCampo("Tarea", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Asginacion", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Word Game", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Think-Develop and Share", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Match Image", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Complete Prayers", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Order Prayer", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Comprehension Match", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("", 1,8, new DeviceRgb(206, 204, 194)).add(this.creaImagen(58,pdf)));
        for (int i = 0; i < 5; i++) {
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen(20,pdf)));
            tabla.addCell(this.crearCampo("12/12/2019", 1, 1, new DeviceRgb(206, 204, 194)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen(30.5f,pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen("forbidden.svg",pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen(40.10f,pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen(50,pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen("forbidden.svg",pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(206, 204, 194)).add(this.creaImagen(62.5f,pdf)));
        }
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
     *<
     * @param rowSpan>
     * @param colSpan
     * @return
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

    private Image creaImagen(float progressBarSize, PdfDocument pdf) throws IOException{
        try{
         this.progressBar(progressBarSize);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        File svg;
        svg = new File("progressBar.svg");
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        imgSVG.setWidth(45);
        return imgSVG;
    }

    private Image creaImagen(String urlArchivo, PdfDocument pdf) throws IOException{
        File svg;
        svg = new File(urlArchivo);
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        imgSVG.setMarginLeft(22);
        return imgSVG;
    }

    private void progressBar(float progressBarSize ) throws ParserConfigurationException, IOException, SAXException, TransformerException{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("progressBar.svg"));
        NodeList elementos = document.getElementsByTagName("path");
        for (int i = 0; i < elementos.getLength(); i++) {
            Element el = (Element) elementos.item(i);
            if (el.getAttribute("id").equalsIgnoreCase("bar")){
                el.setAttribute("d", "M20,5 ".concat(String.valueOf(progressBarSize))
                        .concat(",5 A1,1 0 1 1 ")
                        .concat(String.valueOf(progressBarSize))
                        .concat(",35 L20,35 A1,1 0 1 1 20,5 z"));
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result result = new StreamResult(new File("progressBar.xml"));
        Source input = new DOMSource(document);
        transformer.transform(input,result);
    }


}
