import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio8 {
    public static void main(String[] args) {

        //Declaro el archivo que voy a leer.
        File archivo = new File("C:\\Users\\Kingo\\Desktop\\archivo.txt");
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
         */
        Pattern patron = Pattern.compile("^[a-zA-Z]{2,}\\s[a-zA-Z]{2,}\\s[a-zA-Z]{2,}$");
        /*
         *Declaro el patron que voy a utilizar para validar la edad usando expresiones regulares.
         * ^ indica el inicio de la cadena.
         * [1-9] indica que solo puede contener números del 1 al 9.
         * \\s indica que puede contener espacios.
         * [1-9] indica que solo puede contener números del 1 al 9.
         * $ indica el final de la cadena.
         * Pattern. compile() compila el patron.
         */
        Pattern patron2 = Pattern.compile("^([1-9]\\s[1-9])$");
        /*
         *Declaro el objeto br que me permite leer el archivo.
         * BufferedReader lee el archivo linea por linea.
         * FileReader lee el archivo.
         * try-with-resources cierra el archivo automáticamente.
         */
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            //Declaro la variable linea que me permite leer el archivo linea por linea.
            String linea;
            //Mientras la variable línea no sea nula, se ejecuta el bucle.
            while ((linea = br.readLine()) != null) {
                //Declaro el objeto m que me permite validar el patron.
                Matcher m = patron.matcher(linea);
                //Declaro el objeto m2 que me permite validar el patron.
                Matcher m2 = patron2.matcher(linea);
                //Si la línea cumple con el patron, se imprime el mensaje.
                if (m.matches()) {
                    System.out.println("La linea cumple con el formato nombre" + ": " + linea);
                }
                //Si la línea cumple con el patron, se imprime el mensaje.
                if (m2.matches()) {
                    System.out.println("La linea cumple con el formato edad" + ": " + linea);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
