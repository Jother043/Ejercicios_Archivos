
package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ejercicios_nuevos_7_4 {
    private static final int MAX_SIZE = 15; // Tamaño máximo en bytes del archivo
    private static final String LOG_FILE = "log.txt"; // Nombre del archivo de registro

    public static void main(String[] args) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        String fechaYHora = fecha.format(formatter);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File archivo = new File(LOG_FILE);
        File archivo2 = new File("log_" + fechaYHora + ".txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            System.out.println("Introduce un texto para escribir en el fichero: ");
            String texto = reader.readLine();
            bw.write(texto);
            bw.newLine(); // Agrega una nueva línea al final del texto
            bw.flush(); // Vacía el buffer para asegurarse de que el texto se escriba en el archivo

            if (archivo.length() > MAX_SIZE) {
                if (archivo2.exists()) {
                    archivo2.delete(); // Elimina el archivo si ya existe
                }
                if (archivo.renameTo(archivo2)) {
                    System.out.println("El fichero se ha renombrado correctamente");
                } else {
                    System.out.println("El fichero no se ha podido renombrar");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
