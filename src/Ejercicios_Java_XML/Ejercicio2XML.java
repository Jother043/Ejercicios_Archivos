package Ejercicios_Java_XML;

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

public class Ejercicio2XML {
    public static void main(String[] args) {
        //Crea un objeto File que contiene la ruta del documento XML a analizar.
        File file = new File("web1.html");
        //DocumentBuilderFactory es una clase abstracta que crea objetos DocumentBuilder para analizar documentos XML.
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
                    if (!div.item(i).getAttributes().getNamedItem("id").getTextContent().equals("")) {
                        contador++;
                    }
                }
            }

            System.out.println("*********************************************");
            System.out.println("Número de divs con atributo id: " + contador);
            System.out.println("*********************************************");
            NodeList img = doc.getElementsByTagName("img");
            System.out.println("Texto alternativo de las imágenes: ");
            int numerado = 1;
            for (int i = 0; i < img.getLength(); i++) {
                if (img.item(i).getAttributes().getNamedItem("alt") != null) {
                    System.out.println(numerado++ + ". " + img.item(i).getAttributes().getNamedItem("alt").getTextContent());
                }
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

                //Recorre los hijos del div actual.
                Element e = (Element) no;
                if (e.getAttribute("class").equals("noticia")) {
                    //Obtiene todos los hijos del div actual.
                    NodeList noHijos = no.getChildNodes();
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
            }

            //Imprime las opciones del menu de la página web.
            System.out.println("*********************************************");
            System.out.println("Opciones del menú: ");
            NodeList menu = doc.getElementsByTagName("div");
            for (int i = 0; i < menu.getLength(); i++) {
                Node no = menu.item(i);
                Element e = (Element) no;
                if (no.getNodeName().equals("div") && e.getAttribute("id").equals("menu-principal")) {
                    NodeList noHijos = ((Element) no).getElementsByTagName("li");
                    for (int j = 0; j < noHijos.getLength(); j++) {
                        Node noHijo = noHijos.item(j);
                        if (noHijo.getNodeName().equals("li")) {
                            System.out.println(noHijo.getTextContent());
//
                        }
                    }
                }
            }

            System.out.println( "*********************************************");

            for(int i = 0; i < menu.getLength(); i++) {
                Element div1 = (Element) menu.item(i);
                if (div1.hasAttribute("class") && div1.getAttribute("class").equals("noticia")) {
                    String titular = div1.getElementsByTagName("h2").item(0).getTextContent();
                    String textoImg = div1.getElementsByTagName("img").item(0).getAttributes().getNamedItem("alt").getTextContent();
                    System.out.println(titular + " " + textoImg);
                }
            }

            for(int i = 0; i < menu.getLength(); i++) {
                Element div2 = (Element) menu.item(i);
                if(div2.hasAttribute("class") && div2.getAttribute("class").equals("noticia")) {
                    String titular = div2.getElementsByTagName("h2").item(0).getTextContent();
                    String texto = div2.getElementsByTagName("p").item(0).getTextContent();
                    System.out.println("Titular: \n" + titular + " Texto: \n" + texto);
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
