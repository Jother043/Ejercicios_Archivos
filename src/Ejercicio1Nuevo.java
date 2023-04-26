import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class Ejercicio1Nuevo {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader("quijote.txt"))){
            String linea;
            int contador = 0;
            Pattern p = Pattern.compile("\\p{L}+");
            while ((linea = reader.readLine()) != null) {
                contador += p.matcher(linea).results().count();
            }
            System.out.println("El número de palabras es: " + contador);


        }catch(Exception e){
            e.getMessage();
        }
    }
}
