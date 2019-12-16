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

public class TablaAlumnoPDF {

    /**
     * Metodo que crea una tabla
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una tabla con sus valores correspondientes.
     * @throws IOException Error de lectura de archivo.
     */
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
        for (int i = 0; i < 5; i++) {
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen("forbidden.svg",pdf)));
            tabla.addCell(this.crearCampo("12/12/2019", 1, 1, new DeviceRgb(255, 255, 255)));
            tabla.addCell(this.crearCampo("30 %", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen(30,pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen("forbidden.svg",pdf)));
            tabla.addCell(this.crearCampo("89 %", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen(40,pdf)));
            tabla.addCell(this.crearCampo("100 %", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen(89,pdf)));
            tabla.addCell(this.crearCampo("", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen("forbidden.svg",pdf)));
            tabla.addCell(this.crearCampo("62 %", 1, 1, new DeviceRgb(255, 255, 255)).add(this.creaImagen(62,pdf)));
        }
        tabla.useAllAvailableWidth();
        return tabla;
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

    /**
     * Metodo que convierte un archivo xml en una imagen para la tabla
     * @param progressBarSize el valor en flotante
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una imagen.
     * @throws IOException
     */
    private Image creaImagen(float progressBarSize, PdfDocument pdf) throws IOException{
        try{
         this.progressBar(progressBarSize);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        File svg;
        svg = new File("progressBar.xml");
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        //imgSVG.setMarginTop(5);
        return imgSVG;
    }

    /**
     * Metodo que lee una imagen SVG y la convierte en Imagen para el documento
      * @param urlArchivo direccion del archivo
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una imagen.
     * @throws IOException
     */
    private Image creaImagen(String urlArchivo, PdfDocument pdf) throws IOException{
        File svg;
        svg = new File(urlArchivo);
        Image imgSVG = SvgConverter.convertToImage(svg.toURI().toURL().openStream(), pdf);
        imgSVG.setMarginLeft(15);
        return imgSVG;
    }


    /**
     * Metodo que lee una imagen SVG y la convierte en un archivo XML
     * @param progressBarSize valor en flotante
     * @throws ParserConfigurationException Error de parseo SVG-XML
     * @throws IOException Error al abrir los archivos.
     * @throws SAXException Error crear el Documento.
     * @throws TransformerException Error al guardar los datos.
     */
    private void progressBar(float progressBarSize) throws ParserConfigurationException, IOException, SAXException, TransformerException{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("recta.svg"));
        NodeList elementos = document.getElementsByTagName("rect");
        for (int i = 0; i < elementos.getLength(); i++) {
            Element el = (Element) elementos.item(i);
            if (el.getAttribute("id").equalsIgnoreCase("bar")){
                el.setAttribute("width", String.valueOf(progressBarSize));
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result result = new StreamResult(new File("progressBar.xml"));
        Source input = new DOMSource(document);
        transformer.transform(input,result);
    }

}
