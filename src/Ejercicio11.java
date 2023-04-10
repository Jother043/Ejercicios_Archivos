import java.io.*;
import java.util.regex.Pattern;

public class Ejercicio11 {
    public static void main(String[] args) {
        File fichero = new File("C:\\Users\\Jmiguel-Laptop\\Desktop\\minusculas.txt");

        if(!fichero.exists()){
            try {
                fichero.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("El archivo ya existe");
        }

        Pattern patron = Pattern.compile("^\\s[^A-Z]+\\s$");
        try ( BufferedReader br = new BufferedReader(new FileReader(fichero))){

            while (br.readLine() != null){


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
