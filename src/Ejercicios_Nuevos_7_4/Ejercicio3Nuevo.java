package Ejercicios_Nuevos_7_4;

import java.io.*;

public class Ejercicio3Nuevo {
    public static void main(String[] args) {
        //Creamos un BufferedReader para leer la palabra que queremos buscar.
        BufferedReader palabra = new BufferedReader(new InputStreamReader(System.in));
        //Creamos un String para la palabra que queremos buscar.
        String palabraBuscada;
        //Creamos un contador para saber en qué línea aparece la palabra.
        int numLinea = 0;
        try {
            //Creamos un BufferedReader para leer el texto.
            BufferedReader reader = new BufferedReader(new FileReader("Texto_100_Palabras.txt"));
            //Creamos un String para la línea que vamos a ir leyendo.
            String linea;
            //Pedimos al usuario que introduzca la palabra que quiere buscar.
            System.out.println("Introduce una palabra: ");
            //Leemos la palabra que queremos buscar.
            palabraBuscada = palabra.readLine();
            //Mientras la línea no sea nula, seguimos leyendo.
            while((linea = reader.readLine()) != null) {
                //Aumentamos el contador de líneas.
                numLinea++;
                //Si la línea contiene la palabra que queremos buscar, la mostramos.
                if (linea.contains(palabraBuscada)) {
                    System.out.println("La palabra " + palabraBuscada + " aparece en la linea " + numLinea);
                    System.out.println(linea);
                    //Si no, mostramos un mensaje diciendo que no aparece.
                }else {
                    System.out.println("La palabra " + palabraBuscada + " no aparece en la linea " + numLinea);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
