package Ejercicios_Java_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Ejercicio2XML {
    public static void main(String[] args) {

        File file = new File("web1.html");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            //Crea un objeto DocumentBuilder para analizar el documento XML.
            db = factory.newDocumentBuilder();
            /*Crea un objeto Document para representar el documento XML en memoria y lo analiza con el objeto DocumentBuilder creado anteriormente.
            El método parse(), recibe como parámetro un objeto File que contiene la ruta del documento XML a analizar y devuelve un objeto Document
            que representa el documento XML en memoria y que permite acceder a sus elementos y atributos mediante métodos de la clase Document
            y de la clase Node (que es la superclase de Element, Attr, Text, etc.)
             */
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            //Imprime el titulo de la página web.
            System.out.println("Titulo de la página: " + doc.getElementsByTagName("title").item(0).getTextContent());

            //Contar cuantos div hay en la página web.
            NodeList div = doc.getElementsByTagName("div");
            System.out.println("*********************************************");
            System.out.println("Número de divs: " + doc.getElementsByTagName("div").getLength());
            //Contar cuantos div hay en la página web ue tienen el atributo id con valor.
            int contador = 0;

            for (int i = 0; i < div.getLength(); i++) {
                if (div.item(i).getAttributes().getNamedItem("id") != null) {
                    contador++;
                }
            }

            System.out.println("*********************************************");
            System.out.println("Número de divs con atributo id: " + contador);
            System.out.println("*********************************************");
            NodeList img = doc.getElementsByTagName("img");
            System.out.println("Texto alternativo de las imágenes: ");
            int numerado = 1;
            for (int i = 0; i < img.getLength(); i++) {
                System.out.println(numerado++ + ". " + img.item(i).getAttributes().getNamedItem("alt").getTextContent());
            }
            System.out.println("*********************************************");
            /*
            Imprime el título de las noticias y el texto alternativo de la imagen de cada una de ellas.
             */
            //Obtiene todos los divs de la página web y los guarda en un NodeList llamado noticias que contiene todos los divs de la página web.
            NodeList noticias = doc.getElementsByTagName("div");
            System.out.println("Noticias y texto alternativo de imagen: ");
            //Recorre el NodeList noticias.
            for (int i = 0; i < noticias.getLength(); i++) {
                //Obtiene el div actual.
                Node no = noticias.item(i);
                //Obtiene todos los hijos del div actual.
                NodeList noHijos = no.getChildNodes();
                //Recorre los hijos del div actual.
                for (int j = 0; j < noHijos.getLength(); j++) {
                    //Obtiene el hijo actual.
                    Node noHijo = noHijos.item(j);
                    /*
                    Si el nombre del hijo actual es h2, imprime el título de la noticia.
                    Si el nombre del hijo actual es img, imprime el texto alternativo de la imagen.
                     */
                    if (noHijo.getNodeName().equals("h2")) {
                        System.out.println("Título: " + noHijo.getTextContent().trim());
                    } else if (noHijo.getNodeName().equals("img")) {
                        if (noHijo.getAttributes().getNamedItem("alt") != null) {
                            System.out.println("Texto alternativo de la imagen: " + noHijo.getAttributes().getNamedItem("alt").getNodeValue());
                        }
                    }
                }
            }

            //Imprime las opciones del menu de la página web.
            System.out.println("*********************************************");
            System.out.println("Opciones del menú: ");
            NodeList menu = doc.getElementsByTagName("div");
            for (int i = 0; i < menu.getLength(); i++) {
                Node no = menu.item(i);
                NodeList noHijos = no.getChildNodes();
                if (no.getAttributes().getNamedItem("id").getNodeValue().equals("menu-principal")) {
                    for (int j = 0; j < noHijos.getLength(); j++) {
                        Node noHijo = noHijos.item(j);
                        if (noHijo.getNodeName().equals("ul")) {
                            System.out.println(noHijo.getTextContent().trim());
                            NodeList lista = noHijo.getChildNodes();
                            for (int k = 0; k < lista.getLength(); k++) {
                                Node noHijo2 = lista.item(k);
                                if (noHijo2.getNodeName().equals("li")) {
                                    System.out.println(noHijo2.getTextContent().trim());
                                }
                            }
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
