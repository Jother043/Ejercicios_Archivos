package Ejercicios_Java_XML;

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

public class Ejercicio3XML {

    public static void main(String[] args) {
        File file = new File("desayuno.xml");
        DocumentBuilderFactory bf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;

        {
            try {
                db = bf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();

                NodeList noFood = doc.getElementsByTagName("food");

                System.out.println("Platos con menos de 5€: ");

                for (int i = 0; i < noFood.getLength(); i++) {
                    Element noFoodNode = (Element) noFood.item(i);
                    String plato = noFoodNode.getElementsByTagName("price")
                            .item(0)
                            .getTextContent()
                            .replace(",", ".")
                            .split("€")[0];
                    double precio = Double.parseDouble(plato);
                    if (precio < 5) {
                        System.out.println(noFoodNode
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent());
                    }
                }
                System.out.println("**********************************************");
                System.out.println("Platos con más de 500 calorías: ");
                for (int i = 0; i < noFood.getLength(); i++) {
                    Element noFoodNode = (Element) noFood.item(i);
                    String plato = noFoodNode.getElementsByTagName("calories")
                            .item(0)
                            .getTextContent();
                    int calorias = Integer.parseInt(plato);
                    if (calorias < 500) {
                        System.out.println(noFoodNode
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent());
                    }
                }

                for (int i = 0; i < noFood.getLength(); i++) {
                    Element noFoodNode = (Element) noFood.item(i);
                    noFoodNode.setAttribute("id", String.valueOf(i + 1));
                }

                File destino = new File("desayuno2.xml");
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(destino);
                transformer.transform(source, result);

                File file2 = new File("desayuno2.xml");
                Document doc2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file2);
                Element document = doc2.createElement("food");
                Element name = doc2.createElement("name");
                name.appendChild(doc2.createTextNode("Gambas al ajillo"));
                document.appendChild(name);

                Element price = doc2.createElement("price");
                price.appendChild(doc2.createTextNode("5€"));
                document.appendChild(price);

                Element description = doc2.createElement("description");
                description.appendChild(doc2.createTextNode("Gambas al ajillo"));
                document.appendChild(description);

                Element calories = doc2.createElement("calories");
                calories.appendChild(doc2.createTextNode("500"));
                document.appendChild(calories);

                Transformer transformer2 = TransformerFactory.newInstance().newTransformer();
                transformer2.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source2 = new DOMSource(doc2);
                StreamResult result2 = new StreamResult(destino);
                transformer2.transform(source2, result2);


                Document doc3 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("desayuno_saludable.xml");



            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
