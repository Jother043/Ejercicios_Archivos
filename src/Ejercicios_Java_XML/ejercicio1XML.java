package Ejercicios_Java_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class ejercicio1XML {

    public static void main(String[] args) {

        PersonaXML persona1 = new PersonaXML("Juan", "Perez", 123456789, "12345678A", "01/01/2000");
        PersonaXML persona2 = new PersonaXML("Maria", "Gomez", 987654321, "87654321B", "02/02/2000");
        PersonaXML persona3 = new PersonaXML("Pepe", "Garcia", 135792468, "24681357C", "03/03/2000");

        ArrayList<PersonaXML> personas = new ArrayList<>();

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        File file = new File("personas.xml");

        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Element elementRaiz = doc.createElement("personas");
            doc.appendChild(elementRaiz);
            for (PersonaXML p : personas){
                Element personaElement = doc.createElement("persona");
                personaElement.setAttribute("id" , p.getDni());
                elementRaiz.appendChild(personaElement);

                Element nombreElement = doc.createElement("nombre");
                personaElement.appendChild(nombreElement);
                nombreElement.setTextContent(p.getNombre());

                Element apellidoElement = doc.createElement("apellido");
                personaElement.appendChild(apellidoElement);
                apellidoElement.setTextContent(p.getApellido());

                Element numeroTelefonoElement = doc.createElement("numeroTelefono");
                personaElement.appendChild(numeroTelefonoElement);
                numeroTelefonoElement.setTextContent(String.valueOf(p.getNumeroTelefono()));

                Element dniElement = doc.createElement("dni");
                personaElement.appendChild(dniElement);
                dniElement.setTextContent(p.getDni());

                Element fechaNacimientoElement = doc.createElement("fechaNacimiento");
                personaElement.appendChild(fechaNacimientoElement);
                fechaNacimientoElement.setTextContent(p.getFechaNacimiento());
            }
            /*
            Crear un documento XML y añadir el elemento raiz al documento XML creado anteriormente (doc).
             */
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            // Crear un transformador para poder escribir el documento XML en un archivo XML
            Transformer transformer = transformerFactory.newTransformer();
            // Indicar que queremos que el documento XML se guarde con indentación
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // Crear el archivo XML a partir del documento XML y el transformador creado anteriormente (transformer).
            DOMSource source = new DOMSource(doc);
            // StreamResult se utiliza para escribir el documento XML en un archivo XML (file).
            StreamResult result = new StreamResult(file);
            //

            transformer.transform(source, result);
            System.out.println("Archivo XML guardado con éxito.");

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }catch (TransformerException e) {
            throw new RuntimeException(e);
        }


    }
}
