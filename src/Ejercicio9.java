import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio9 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        File archivo = new File("C:\\Users\\Kingo\\Desktop\\matriculas.txt");
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

        try {
            Pattern patron = Pattern.compile("^[1-9]\\s[1-9]\\s[1-9]\\s[1-9]\\s[A-Z]\\s[A-Z]\\s[A-Z]$");
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            FileWriter fw = new FileWriter("C:\\Users\\Kingo\\Desktop\\MatriculasCorrectas.txt");
            String linea;
            while ((linea = br.readLine()) != null) {
                Matcher m = patron.matcher(linea);
                if (m.matches()) {
                    fw.write(linea);
                    System.out.println("La linea cumple con el formato matricula" + ": " + linea);
                }else {
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
