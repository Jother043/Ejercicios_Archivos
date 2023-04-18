import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8 {
    public static void main(String[] args) {

        //Declaro el archivo que voy a leer.
        File archivo = new File("C:\\Users\\Jmiguel-Laptop\\Desktop\\archivo.txt");
        //Si el archivo no existe, se crea.
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("El archivo se ha creado correctamente");
            }
        } else {
            System.out.println("El archivo ya existe");
        }

        /*
         *Declaro el patron que voy a utilizar para validar el nombre usando expresiones regulares.
         * ^ indica el inicio de la cadena.
         * [a-zA-Z] indica que solo puede contener letras.
         * {2,} indica que puede contener 2 o más caracteres.
         * \\s indica que puede contener espacios.
         * $ indica el final de la cadena.
         * Pattern. compile() compila el patron.
         * \\p{L} indica que puede contener letras en español.
         */
        Pattern patron = Pattern.compile("^\\p{L}{2,}\\s\\p{L}{2,}\\s\\p{L}{2,}\\s(0?[1-9]|[1-9][0-9])$");
        /*
         *Declaro el patron que voy a utilizar para validar la edad usando expresiones regulares.
         * ^ indica el inicio de la cadena.
         * [1-9] indica que solo puede contener números del 1 al 9.
         * \\s indica que puede contener espacios.
         * [1-9] indica que solo puede contener números del 1 al 9.
         * $ indica el final de la cadena.
         * Pattern. compile() compila el patron.
         */

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            /* Declaro las variables que me permiten validar si se cumple el patron. */
            boolean verificacion = false;

            /* Declaro la variable linea que me permite leer el archivo linea por linea. */
            String linea;
            // Mientras la variable línea no sea nula, se ejecuta el bucle.
            while ((linea = br.readLine()) != null) {
                //Declaro el objeto m que me permite validar el patron.
                Matcher m = patron.matcher(linea);
                //Si la línea cumple con el patron, se imprime el mensaje.
                if (m.matches()) {
                    verificacion = true;
                    System.out.println("La linea cumple con el formato" + ": " + linea);
                }
                //Si la línea cumple con el patron, se imprime el mensaje.

            }
            //Si la línea no cumple con el patron, se imprime el mensaje.
            if (!verificacion) {
                System.err.println("No se cumple el formato");
            }
            if(verificacion){
                System.out.println("Se cumple el formato");
            }


        } catch (IOException e) {
            e.getMessage();
        }

    }
}
