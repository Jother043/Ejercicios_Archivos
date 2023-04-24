import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejercicio3XML {

    public static void main(String[] args) {
        File file = new File("desayuno.xml");
        DocumentBuilderFactory bf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;

        try {
            db = bf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList platoList = doc.getElementsByTagName("food");
            for (int i = 0; i < platoList.getLength(); i++) {
                Node platoNode = platoList.item(i);
                for (int j = 0; j < platoNode.getChildNodes().getLength(); j++) {
                    Node platoChildNode = platoNode.getChildNodes().item(j);
                    if (platoChildNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element platoChildElement = (Element) platoChildNode;
                        String precio = platoChildElement.getAttribute("price");
                        double price = Double.parseDouble(precio);
                        if (platoChildElement.getTagName().equals("name")) {
                            System.out.println("Nombre: " + platoChildElement.getTextContent());
                        } else if (price < 5) {
                            System.out.println("Precio: " + platoChildElement.getTextContent());
                        } else if (platoChildElement.getTagName().equals("description")) {
                            System.out.println("Descripción: " + platoChildElement.getTextContent());
                        } else if (platoChildElement.getTagName().equals("calories")) {
                            System.out.println("Calorías: " + platoChildElement.getTextContent());
                        }
                    }
                }

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
