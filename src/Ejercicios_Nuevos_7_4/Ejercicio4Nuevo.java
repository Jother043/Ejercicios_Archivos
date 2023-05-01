package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static java.time.LocalTime.now;

public class Ejercicio4Nuevo {

    private static final Byte[] PESO_MAXIMO = new Byte[1024];
    public static void main(String[] args) {

        LocalDateTime fecha = LocalDateTime.now();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File archivo = new File("log.txt");
        File archivo2 = new File("");
        try {
            archivo2.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("log.txt", true))) {
            System.out.println("Introduce un texto para escribir en el fichero: ");
            String texto = reader.readLine();
            bw.write(texto);
            int pesoActual = (int) new File("log.txt").length();
            if (pesoActual > PESO_MAXIMO.length) {
                if(archivo.canWrite() && archivo2.canWrite()) {
                    System.out.println("El fichero tiene permisos de escritura");
                }
                if (archivo2.renameTo(archivo)) {
                    System.out.println("El fichero se ha renombrado correctamente");
                } else {
                    System.out.println("El fichero no se ha podido renombrar");
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
