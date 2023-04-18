import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Declaro el archivo que voy a leer
        File archivo = new File("C:\\Users\\kingo\\Desktop\\matriculas.txt");
        File archivo2 = new File("C:\\Users\\kingo\\Desktop\\MatriculasCorrectas.txt");
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
        if (!archivo2.exists()) {
            try {
                archivo2.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                System.out.println("El archivo2 se ha creado correctamente");
            }
        } else {
            System.out.println("El archivo2 ya existe");
        }
        Pattern patron = Pattern.compile("^(\\d{4}\\s[^aeiouAEIOU\\d\\W_]{3})$");
        //^\p{L}+\s\d{4}-([A-Z&&[^AEIOU]]{3})$
        try (BufferedReader br = new BufferedReader(new FileReader(archivo)); BufferedWriter fw = new BufferedWriter(new FileWriter(archivo2))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                Matcher m = patron.matcher(linea);
                if (m.find()) {
                    fw.write(m.group(1));
                    System.out.println("La linea cumple con el formato matricula" + ": " + linea);
                } else {
                    System.out.println("La linea no cumple con el formato matricula" + ": " + linea);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
