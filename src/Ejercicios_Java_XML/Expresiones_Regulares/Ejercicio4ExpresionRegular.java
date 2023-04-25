package Ejercicios_Java_XML.Expresiones_Regulares;

import java.io.*;
import java.util.Locale;
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
            System.out.println("*".repeat(50));
            System.out.println("La palabra eñe se repite " + contador + " veces");

            /*
             Modifica el fichero para eliminar los números que aparecen tras algunas palabras.
             */

            reader = new BufferedReader(new FileReader("quijote.txt"));
            PrintWriter writer = new PrintWriter("quijote2.txt");

            while ((linea = reader.readLine()) != null) {
                writer.println(linea.replaceAll("(\\p{L}+)([0-9]+)", "$1"));
            }
            System.out.println("*".repeat(50));
            System.out.println("Se ha creado el fichero quijote2.txt");
            writer.close();
            //Leemos el archivo.
            reader = new BufferedReader(new FileReader("quijote.txt"));
            //Creamos un printWriter para escribir en el archivo y lo llamamos quijote3.txt.

            PrintWriter pw = new PrintWriter("quijote3.txt");
            //Creamos un StringBuilder que nos servirá para ir concatenando las palabras en el nuevo fichero .txt.
            StringBuilder sb = new StringBuilder();
            /*
            Mientras que la línea no sea null, es decir, mientras que haya líneas que leer.
            Creamos un array de String que nos servirá para separar las palabras de la línea.
            El array de String lo recorremos con un for each.
             */
            while ((linea = reader.readLine()) != null) {
                //El array lo creamos con el método split, que nos servirá para separar las palabras de la línea.
                String[] palabras = linea.split(" ");
                //Recorremos el array de String.
                for (String palabra : palabras) {
                    //Si la palabra contiene números, se elimina.
                    if (palabra.matches("(\\p{all}+)")) {
                        //Con el método substring nos servirá para coger la primera letra de la palabra y ponerla en mayúscula.
                        sb.append(palabra.substring(0, 1).toUpperCase()).append(palabra.substring(1)).append(" ");
                    }
                }
                //añadimos un salto de línea por cada línea leída que sabremos que es cada vez que el bucle while se ejecute.
                sb.append("\n");
            }
            //Escribimos en el archivo.
            pw.println(sb.toString());
            System.out.println("*".repeat(50));
            System.out.println("Se ha creado el fichero quijote3.txt");
            //Cerramos el archivo (Es importante cerrar el archivo para que se guarde).
            pw.close();
            //repetimos el * 50 veces para que se vea mejor en la consola.
            System.out.println("*".repeat(50));
            System.out.println("Palabras con más de 8 letras");
            //Leemos el archivo.
            reader = new BufferedReader(new FileReader("quijote.txt"));
            //Mientras que la línea no sea null, es decir, mientras que haya líneas que leer.
            while ((linea = reader.readLine()) != null) {
                //Creamos un array de String que nos servirá para separar las palabras de la línea.
                String[] palabras = linea.split(" ");
                for (String palabra : palabras) {
                    //Si la palabra tiene más de 8 letras, se imprime.
                    if (palabra.matches("(\\p{L}{8,})")) {
                        System.out.println(palabra);
                    }
                }
            }
            System.out.println("*".repeat(50));
            //Busca aquellas frases que tengan menos de 15 palabras
            reader = new BufferedReader(new FileReader("quijote.txt"));
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split(" ");
                if (palabras.length < 15) {
                    System.out.println(linea);
                }
            }

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


    }
}
