package alumnoindividual;

import alumnoindividual.TablaAlumnoModelo;
import com.itextpdf.io.image.ImageDataFactory;
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
import com.sun.prism.impl.ps.CachingEllipseRep;
import gruposasignados.TablaGruposModelo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.imageio.metadata.IIOMetadataController;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TablaAlumnoPDF {

    /**
     * Metodo que crea una tabla
     * @param pdf un objeto del tipo {@link PdfDocument}
     * @return una tabla con sus valores correspondientes.
     * @throws IOException Error de lectura de archivo.
     */
    public Table creaTabla(PdfDocument pdf, List<TablaAlumnoModelo> tablaAlumnoModeloLista) throws IOException {
        Table tabla = new Table(9);
        Cell celda = this.crearCampo(1, 9);
        celda.add(new Paragraph("Filtros").setFontColor(ColorConstants.WHITE));
        tabla.addCell(celda);
        tabla.addCell(this.crearCampo("Tarea", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Asginacion", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Transcript", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Word Game", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Think-Develop\nand Share", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Mix & Match", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Gap Filling", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("What Happened", 1,1, new DeviceRgb(206, 204, 194)));
        tabla.addCell(this.crearCampo("Comprehension\nMatch", 1,1, new DeviceRgb(206, 204, 194)));
        for (TablaAlumnoModelo tablaAlumnoModelo : tablaAlumnoModeloLista){
            tabla.addCell(this.tareaImagen("1XPG2xEEOmo"));
            tabla.addCell(
                    this.crearCampo(tablaAlumnoModelo.getAsignacion(), 1, 1, new DeviceRgb(255, 255, 255)));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getTrasncript()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getTrasncript(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getWordGame()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getWordGame(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getThinkDevelopShare()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getThinkDevelopShare(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getMixMatch()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getMixMatch(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getGapFilling()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getGapFilling(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getWhatHappened()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getWhatHappened(),pdf));
            tabla.addCell(
                    this.crearCampo(String.valueOf(tablaAlumnoModelo.getComprehensionMatch()).concat("%\n"), 1, 1, new DeviceRgb(255, 255, 255),tablaAlumnoModelo.getComprehensionMatch(),pdf));
        }
        tabla.useAllAvailableWidth();
        tablaAlumnoModeloLista.forEach(System.out::println);
        return tabla;
    }

    /**
     * Metodo que crea las celdas para los nombres de las columnas y los valores de las tablas.
     * @param valorCampo El nombre de la columnax
     * @param rowSpan Numero de filas a unir o fusionar
     * @param colSpan Numero de columnas a unir o fusionar
     * @return una Celda con el campo correspondiente.
     */
    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceRgb color, float progressBarSize, PdfDocument pdf) throws IOException {
        Cell celda = new Cell(rowSpan,colSpan)
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(color)
                .add(new Paragraph(valorCampo).setFontColor(ColorConstants.BLACK).add(this.creaImagen(progressBarSize, pdf)))
                .setFontSize(7);
        celda.setBorderBottom(new SolidBorder(ColorConstants.BLACK,1));
        celda.setBorderLeft(Border.NO_BORDER);
        celda.setBorderRight(Border.NO_BORDER);
        celda.setBorderTop(Border.NO_BORDER);
        return celda;
    }

    private Cell crearCampo(String valorCampo, int rowSpan, int colSpan, DeviceRgb color) throws IOException {
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

    private Cell tareaImagen(String idVideo) throws MalformedURLException {
        Cell celda = new Cell()
                .setTextAlignment(TextAlignment.CENTER)
                .setBackgroundColor(ColorConstants.WHITE)
                .add(
                        new Paragraph("").add( new Image(
                                 ImageDataFactory.create(
                                           new URL("https","i.ytimg.com", "/vi/".concat(idVideo).concat("/mqdefault.jpg"))
                                 )).setWidth(50).setHeight(30).setBorder(Border.NO_BORDER)
                        )
                       );
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
        float valor = ((50 * progressBarSize) / 100);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("recta.svg"));
        NodeList elementos = document.getElementsByTagName("rect");
        for (int i = 0; i < elementos.getLength(); i++) {
            Element el = (Element) elementos.item(i);
            if (el.getAttribute("id").equalsIgnoreCase("bar")){
                el.setAttribute("width", String.valueOf(valor));
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result result = new StreamResult(new File("progressBar.xml"));
        Source input = new DOMSource(document);
        transformer.transform(input,result);
    }



}
