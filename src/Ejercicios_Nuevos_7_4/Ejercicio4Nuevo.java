package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.time.LocalTime;
import java.util.Date;

import static java.time.LocalTime.now;

public class Ejercicio4Nuevo {
    public static void main(String[] args) {
        LocalTime fecha = now();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {

            System.out.println("Introduce un texto para escribir en el fichero: ");
            String texto = reader.readLine();
            bw.write(texto);
            if (new File("log.txt"). > 15) {
                File archivo = new File("log.txt");
                archivo.renameTo(new File("log_"+ fecha +".txt"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
