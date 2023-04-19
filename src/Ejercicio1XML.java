import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Ejercicio1XML {
    public static void main(String[] args) {

        PersonaXML miguel = new PersonaXML("Miguel", "García", "666666666", "12345678A", new Date());
        PersonaXML juan = new PersonaXML("juan", "Rodriguez", "666666666", "12345678A", new Date());
        PersonaXML manuel = new PersonaXML("manuel", "Gutierrez", "666666666", "12345678A", new Date());
        PersonaXML rodrigo = new PersonaXML("rodrigo", "Perez", "666666666", "12345678A", new Date());

        ArrayList<PersonaXML> personas = new ArrayList<>();
        personas.add(miguel);
        personas.add(juan);
        personas.add(manuel);
        personas.add(rodrigo);

        File file = new File("personas.xml");

        try {
            // Crear un documento XML
            Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            // Crear un elemento raiz
            Element raiz = documento.createElement("personas");
            // Añadir el elemento raiz al documento
            documento.appendChild(raiz);

            for(PersonaXML persona : personas){
                // Crear un elemento persona
                Element personaElement = documento.createElement("persona");
                // Añadir el elemento persona al elemento raiz
                raiz.appendChild(personaElement);

                // Crear un elemento nombre
                Element nombreElement = documento.createElement("nombre");
                // Añadir el elemento nombre al elemento persona
                personaElement.appendChild(nombreElement);
                // Añadir el contenido del elemento nombre
                nombreElement.setTextContent(persona.getNombre());

                // Crear un elemento apellido
                Element apellidoElement = documento.createElement("apellido");
                // Añadir el elemento apellido al elemento persona
                personaElement.appendChild(apellidoElement);
                // Añadir el contenido del elemento apellido
                apellidoElement.setTextContent(persona.getApellido());

                // Crear un elemento telefono
                Element telefonoElement = documento.createElement("telefono");
                // Añadir el elemento telefono al elemento persona
                personaElement.appendChild(telefonoElement);
                // Añadir el contenido del elemento telefono
                telefonoElement.setTextContent(persona.getTelefono());

                // Crear un elemento dni
                Element dniElement = documento.createElement("dni");
                // Añadir el elemento dni al elemento persona
                personaElement.appendChild(dniElement);
                // Añadir el contenido del elemento dni
                dniElement.setTextContent(persona.getDni());

                // Crear un elemento fechaNacimiento
                Element fechaNacimientoElement = documento.createElement("fechaNacimiento");
                // Añadir el elemento fechaNacimiento al elemento persona
                personaElement.appendChild(fechaNacimientoElement);
                // Añadir el contenido del elemento fechaNacimiento
                fechaNacimientoElement.setTextContent(persona.getFechaNacimiento().toString());
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
