import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class nuevo {


    public static void main(String[] args) {

        File archivo = new File("C:\\Users\\Miguel\\Desktop\\intellij\\Trimestre3\\src\\relacion7\\ejerciciosXML\\desayuno.xml");

        Document newDocument = null;
        try {
            //Creamos el objeto documento
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(archivo);
            //Obtenemos el nodo raíz
            NodeList comida = documento.getElementsByTagName("food");
            //Recorremos la lista de nodos
            for (int i = 0; i < comida.getLength(); i++) {
                Element food = (Element) comida.item(i);
                String plato = food.getElementsByTagName("calories").item(0).getTextContent();
                int calorias = Integer.parseInt(plato);
                if (calorias > 500) {
                    food.getParentNode().removeChild(food);
                }
            }

            File f = new File("C:\\Users\\Miguel\\Desktop\\intellij\\Trimestre3\\src\\relacion7\\ejerciciosXML\\desayuno_saludable.xml");
            // Escribir el nuevo documento en un archivo XML
            Transformer transformer = null;
            try {
                transformer = TransformerFactory.newInstance().newTransformer();
            } catch (TransformerConfigurationException e) {
                System.err.println("Error al crear el transformador: " + e.getMessage());
            }
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(documento);
            StreamResult result = new StreamResult(f);
            try {
                transformer.transform(source, result);
            } catch (TransformerException e) {
                System.err.println("Error al escribir el archivo XML: " + e.getMessage());
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
