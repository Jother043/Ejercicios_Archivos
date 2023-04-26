package Ejercicios_Nuevos_7_4;

import java.io.*;

public class Ejercicio2Nuevo {

    public static void main(String[] args) {
        /*
         * Con el BufferedReader leemos la palabra que queremos buscar en el texto.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Creamos un String de las líneas que vamos a ir leyendo.
        String linea;
        //Creamos un String de la palabra que queremos buscar.
        String palabraBuscada;
        //Creamos un contador para saber cuántas veces aparece la palabra en el texto.
        int contador = 0;
        /*
         * Hacemos un try with resources para leer el texto y buscar la palabra.
         * Le pedimos al usuario que introduzca la palabra que quiere buscar.
         * Creamos un bucle while para que vaya leyendo línea a línea el texto.
         *
         */
        try (BufferedReader reader2 = new BufferedReader(new FileReader("Texto_100_Palabras.txt"))) {
            System.out.println("Introduce una palabra: ");
            palabraBuscada = reader.readLine();
            while ((linea = reader2.readLine()) != null) {
                if (linea.contains(palabraBuscada)) {
                    contador++;
                }
            }
            System.out.println("La palabra " + palabraBuscada + " aparece " + contador + " veces en el texto.");

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
