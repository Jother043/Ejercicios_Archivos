package Ejercicios_Nuevos_7_4;

import java.io.*;

public class Ejercicio6Nuevo {

    private static final int MAX_SIZE = 1024;
    public static void main(String[] args) {

        File file = new File("bitacora.txt");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            if(file.length() > MAX_SIZE){
                //borrar la primera linea
                BufferedReader readerFile = new BufferedReader(new FileReader(file));
                String line = readerFile.readLine();
                while(line != null){
                    writer.write(line);
                    writer.newLine();
                    line = readerFile.readLine();
                }
                readerFile.close();
            }else{
                //agregar una linea
                writer.write("Hola mundo");
                writer.newLine();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

