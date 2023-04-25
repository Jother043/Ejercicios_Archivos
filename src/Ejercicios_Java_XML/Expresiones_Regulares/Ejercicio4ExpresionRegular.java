package Ejercicios_Java_XML.Expresiones_Regulares;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio4ExpresionRegular {
    public static void main(String[] args) {

        try {
            //Cuenta cuantas veces aparece la palabra razón en el texto.
            /*
            Creamos un contador que nos servirá para contar las veces que aparece la palabra razón.
            Creamos un BufferedReader que nos servirá para leer el archivo.
            Creamos un String que nos servirá para ir leyendo línea a línea el archivo.
            Creamos un Pattern que nos servirá para buscar la palabra razón.
            Creamos un bucle que nos servirá para ir leyendo línea a línea el archivo.
             */
            int contador = 0;
            BufferedReader reader = new BufferedReader(new FileReader("quijote.txt"));
            String linea;
            Pattern pattern = Pattern.compile("([Rr]az[óo]n)");
            //Nos servirá para ir leyendo línea a línea el archivo.
//            while ((linea = reader.readLine()) != null) {
//                /*
//                Con el split separamos las palabras de la línea y las guardamos en un array de String.
//                Creamos un bucle que nos servirá para recorrer el array de String.
//                El if nos servirá para comprobar si la palabra contiene la palabra razón.
//                 */
//                for (String palabra : linea.split(" ")) {
//                    if (pattern.matcher(palabra).find()) {
//                        contador++;
//                    }
//                }
//            }

            //Otra forma de hacerlo sin tener que recorrer las palabras con el for.
            while ((linea = reader.readLine()) != null) {

                Matcher m = pattern.matcher(linea);
                contador += m.results().count();
//                m.results().forEach( (x) -> System.out.println("#" + x.group()));
               // contador += m.results().filter(x -> x.group().contains("ó")).count();
            }

            System.out.println("La palabra razón se repite " + contador + " veces");
            //Cuenta cuantas tildes (sin tener en cuenta mayúsculas y minúsculas) hay en el texto y cuantas eñes.
            contador = 0;
            reader = new BufferedReader(new FileReader("quijote.txt"));
            Pattern pattern1 = Pattern.compile("[áéíóúñÁÉÍÓÚÑ]");
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    if (pattern1.matcher(palabra).find()) {
                        contador++;
                    }
                }

            }

            System.out.println("La palabra eñe se repite " + contador + " veces");

            /*
             Modifica el fichero para eliminar los números que aparecen tras algunas palabras.
             */

            reader = new BufferedReader(new FileReader("quijote.txt"));
            PrintWriter writer = new PrintWriter("quijote2.txt");

            while ((linea = reader.readLine()) != null) {
                writer.println(linea.replaceAll("(\\p{L}+)([0-9]+)", "$1"));
            }

            //Convertir todas las palabras con la primera letra en mayuscula en un nuevo fichero.
            reader = new BufferedReader(new FileReader("quijote.txt"));
            writer = new PrintWriter("quijote3.txt");

            while ((linea = reader.readLine()) != null) {
                writer.println(linea.replaceAll("(^\\p{L}+)", "$1"));
            }

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


    }
}
