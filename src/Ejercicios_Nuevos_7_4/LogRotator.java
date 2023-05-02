package Ejercicios_Nuevos_7_4;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRotator {

    private static final int MAX_FILE_SIZE = 100; // Tamaño máximo del archivo en bytes
    private static final String LOG_FILE_NAME = "log.txt";
    private static final String LOG_FILE_NAME_PATTERN = "log_%s.txt";

    public static void main(String[] args){

        // Crea un objeto BufferedReader para leer la entrada del usuario.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Crea un objeto BufferedWriter para escribir en el archivo de registro.
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(LOG_FILE_NAME, true));
            System.out.println("Escribe el texto para añadir al archivo: ");
            String input = reader.readLine();
            writer.write(input + "\n");
            reader.close();
            writer.close();
            // Comprueba si el archivo de registro supera el tamaño máximo.
            if (new File(LOG_FILE_NAME).length() > MAX_FILE_SIZE) {
                rotateLogFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void rotateLogFile() throws IOException {
        // Obtiene la fecha y hora actual y la formatea para que se pueda usar en el nombre del archivo.
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        // Crea el nombre del nuevo archivo de registro.
        String newLogFileName = String.format(LOG_FILE_NAME_PATTERN, timestamp);
        // Crea un objeto File para el archivo de registro actual y otro para el nuevo archivo de registro.
        File oldLogFile = new File(LOG_FILE_NAME);
        // Crea un nuevo archivo con el nombre del archivo de registro con la fecha y hora actual.
        File newLogFile = new File(newLogFileName);

        //si el archivo se ha renombrado correctamente, imprime un mensaje por pantalla.
        if (oldLogFile.renameTo(newLogFile)) {
            System.out.println("Archivo renombrado a " + newLogFileName);
        } else {
            // Si no se puede renombrar el archivo, lanza una excepción.
            throw new IOException("No se pudo renombrar el archivo.");
        }
        // Crea un nuevo archivo de registro vacío.
        oldLogFile.createNewFile();

    }
}
